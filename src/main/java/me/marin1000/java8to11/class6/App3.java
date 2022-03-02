package me.marin1000.java8to11.class6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *     Executors
 *     고수준 (High-Level) Concurrency 프로그래밍
 *     ● 쓰레드를 만들고 관리하는 작업을 애플리케이션에서 분리.
 *     ● 그런 기능을 Executors에게 위임.
 *     Executors가 하는 일
 *     ● 쓰레드 만들기: 애플리케이션이 사용할 쓰레드 풀을 만들어 관리한다.
 *     ● 쓰레드 관리: 쓰레드 생명 주기를 관리한다.
 *     ● 작업 처리 및 실행: 쓰레드로 실행할 작업을 제공할 수 있는 API를 제공한다.
 *     주요 인터페이스
 *     ● Executor: execute(Runnable)
 *     ● ExecutorService: Executor 상속 받은 인터페이스로, Callable도 실행할 수 있으며, Executor를 종료 시키거나, 여러 Callable을 동시에 실행하는 등의 기능을 제공한다.
 *     ● ScheduledExecutorService: ExecutorService를 상속 받은 인터페이스로 특정 시간 이후에 또는 주기적으로 작업을 실행할 수 있다.
 */
public class App3 {
    public static void main(String[] args) {
        // ExecutorService로 작업 실행하기
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
        });

        // ExecutorService로 멈추기
        executorService.shutdown();    // 처리중인 작업 기다렸다가 종료
//        executorService.shutdownNow(); // 당장 종료

        // 다중 쓰레드 ( 여기선 2개의 쓰레드를 사용 )
        // 작업들은 두개의 쓰레드에서 나눠서 처리함
        // * 블록킹 큐 에서 작업들을 쌓아놓고 작업이 끝난 쓰레드에 위임해줌
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        executorService1.submit(getRunnable("[A] "));
        executorService1.submit(getRunnable("[B] "));
        executorService1.submit(getRunnable("[C] "));
        executorService1.submit(getRunnable("[D] "));
        executorService1.submit(getRunnable("[E] "));

        // 스케쥴 쓰레드
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // 3초 후에 실행
        scheduledExecutorService.schedule(getRunnable("3초뒤 실행되는 Schedule Thread "), 3, TimeUnit.SECONDS);
        // 1초 후에 실행 그 이후에는 2초마다 실행
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("반복 Schedule Thread "),1,2,TimeUnit.SECONDS);
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }


}
