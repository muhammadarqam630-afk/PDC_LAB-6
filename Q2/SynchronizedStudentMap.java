package Q2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedStudentMap {

    public static void main(String[] args)
            throws InterruptedException {

        final int threadCount = 3;
        final int recordsPerThread = 100;

        HashMap<String, Integer> originalMap = new HashMap<>();

        Map<String, Integer> students =
            Collections.synchronizedMap(originalMap);

        ExecutorService executor =
            Executors.newFixedThreadPool(threadCount);

        for (int t = 0; t < threadCount; t++) {

            final int threadId = t;

            executor.submit(() -> {

                for (int i = 0; i < recordsPerThread; i++) {

                    String key =
                        "Student-" + threadId + "-" + i;

                    students.put(key, i % 101);
                }
            });
        }

        executor.shutdown();
    }
}
