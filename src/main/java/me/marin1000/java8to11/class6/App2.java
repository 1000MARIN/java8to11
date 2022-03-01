package me.marin1000.java8to11.class6;

public class App2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread: " + Thread.currentThread().getName());
            }
        });
        System.out.println("Hello" + Thread.currentThread().getName());
    }
}
