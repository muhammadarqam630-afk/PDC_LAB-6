package Q3;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentStudentMap {

    public static void main(String[] args)
            throws InterruptedException {

        final int threadCount = 5;
        final int recordsPerThread = 1000;

        ConcurrentHashMap<String, Integer> students =
            new ConcurrentHashMap<>();

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

        try {

            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();

                throw new IllegalStateException(
                    "Workers did not finish in time."
                );
            }

        } catch (InterruptedException e) {

            executor.shutdownNow();
            Thread.currentThread().interrupt();
            throw e;
        }

        int expected = threadCount * recordsPerThread;

        System.out.println("Threads: " + threadCount);
        System.out.println("Expected entries: " + expected);
        System.out.println("Actual entries: " + students.size());
    }
}
