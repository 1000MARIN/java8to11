package me.marin1000.java8to11.class6;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone()); //  작업이 끝났는지 아닌지
        System.out.println("Started!");

        helloFuture.get(); // 블록킹 ( 기다림 )

        System.out.println(helloFuture.isDone()); //  작업이 끝났는지 아닌지.
        System.out.println("End!!");
        executorService.shutdown();

        ExecutorService executorService2 = Executors.newFixedThreadPool(4);

        Callable<String> A = () -> {
            Thread.sleep(2000L);
            return "A";
        };
        Callable<String> B = () -> {
            Thread.sleep(3000L);
            return "B";
        };
        Callable<String> C = () -> {
            Thread.sleep(1000L);
            return "C";
        };

        // invokeAll : 모든 작업이 다 끝날 때 까지 기다렸다가 return 함
        List<Future<String>> futures = executorService2.invokeAll(Arrays.asList(A, B, C));
        for(Future<String> f : futures) {
            System.out.println(f.get());
        }
        // invokeAny : 제일 빨리 끝나는 작업을 먼저 호출함 - 블록킹
        String s = executorService2.invokeAny(Arrays.asList(A, B, C));
        System.out.println(s);

        executorService2.shutdown();
    }
}
