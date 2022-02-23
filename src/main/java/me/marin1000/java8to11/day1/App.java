package me.marin1000.java8to11.day1;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
        // 람다가 하는 일이 기존 메소드 또는 생성자를 호출하는 거라면, 메소드 레퍼런스를 사용해서
        //매우 간결하게 표현할 수 있다.
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("chuljin"));

        System.out.println("=================");

        Function<String, Greeting> chuljinGreeting = Greeting::new;
        Greeting chuljin = chuljinGreeting.apply("chuljin");
        System.out.println(chuljin.getName());

        System.out.println("=================");

        Supplier<Greeting> newGreeting = Greeting::new;

        System.out.println("=================");

        String[] names = {"chuljin", "son", "john"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
