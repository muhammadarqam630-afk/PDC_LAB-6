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

        System.out.println(
            "Count matches: " + (students.size() == expected)
        );

        if (students.size() != expected) {
            throw new IllegalStateException(
                "Some student records are missing."
            );
        }
    }
}