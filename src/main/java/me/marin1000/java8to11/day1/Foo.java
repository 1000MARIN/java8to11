package me.marin1000.java8to11.day1;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        RunSomething runSomething = (number) -> number + 10;
        System.out.println(runSomething.doit(1));
        System.out.println(runSomething.doit(1));
        System.out.println(runSomething.doit(1));

        System.out.println("=================");


        // T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;
        System.out.println(plus10.apply(3));
        System.out.println(multiply2.apply(3));
        System.out.println(plus10.andThen(multiply2).apply(3)); // (3 + 10) * 2

        System.out.println("=================");

        //Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수 인터페이스
        UnaryOperator<Integer> plus5 = (i) -> i + 5;
        UnaryOperator<Integer> multiply3 = (i) -> i * 3;
        System.out.println(plus5.andThen(multiply3).apply(3)); // 24

        System.out.println("=================");

        // BiFunction<T, U, R>의 특수한 형태로, 동일한 타입의 입렵값 두개를 받아 리턴하는 함수 인터페이스
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(2, 3));

        System.out.println("=================");

        // T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
        Consumer<Integer> printT = System.out::println;
        printT.accept(10);

        System.out.println("=================");

        // T 타입의 값을 제공하는 함수 인터페이스
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        System.out.println("=================");

        // T 타입을 받아서 boolean을 리턴하는 함수 인터페이스
        Predicate<String> startsWithChuljin = (s) -> s.startsWith("chuljin");
        System.out.println(startsWithChuljin.test("chuljin"));
        System.out.println(startsWithChuljin.test("jin"));

        System.out.println("==================================");

        Foo foo = new Foo();
        foo.run();
    }

    private void run() {
        int baseNumber = 10;

//        // 로컬 클래스
//        class LocalClass {
//            void printBaseNumber() {
//                int baseNumber = 11;
//                System.out.println(baseNumber);
//            }
//        }
//
//        // 익명 클래스
//        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(baseNumber);
//            }
//        };

        // 람다
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);
    }


}
