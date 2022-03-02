package me.marin1000.java8to11.class6;

public class App2 {
    public static void main(String[] args) throws InterruptedException {
        // Runnable 구현 또는 람다

        //  현재 Thread sleep, 다른 Thread 먼저 실행
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000L);    // 현재 Thread 재우기, 다른 Thread 먼저 실행
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread: " + Thread.currentThread().getName());
        });
        thread1.start();

        // interupt : 다른 쓰레드 깨우기
        Thread thread2 = new Thread(() -> {
            while (true) {
                System.out.println("Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("exit!");
                    return;
                }
            }
        });
        thread2.start();

        System.out.println("Hello" + Thread.currentThread().getName());

        // 3초 뒤에 thread2를 깨움
        Thread.sleep(3000L);
        thread2.interrupt();

        // 다른 Thread를 기다림
        thread2.join();
        System.out.println(thread2 + " is finished");
    }
}
