package com.ppolivka.java;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ProjectLoom {

    public static class GoodOldThreads {

        public static void main(String[] args) {

            try (var executor = Executors.newThreadPerTaskExecutor(Executors.defaultThreadFactory())) {
                IntStream.range(0, 100_000).forEach(i -> executor.submit(() -> {
                    blockingOperation(i);
                }));
            }
        }

    }

    public static class VirtualThreads {

        public static void main(String[] args) {

            try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
                IntStream.range(0, 100_000).forEach(i -> executor.submit(() -> {
                    blockingOperation(i);
                }));
            }

        }
    }


    static int blockingOperation(int i) {
        try {
            Thread.sleep(Duration.ofSeconds(1));
            System.out.println(i);
            return i;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
