package me.marin1000.java8to11.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class App {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("chuljin");
        name.add("son");
        name.add("toby");
        name.add("foo");

        // 아래와 동일일
        name.forEach(System.out::println);

        System.out.println("=================");

        for (String n : name) {
            System.out.println(n);
        }

        System.out.println("=================");

        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("=================");
        while (spliterator1.tryAdvance(System.out::println));

        System.out.println("=================");

        name.removeIf(s -> s.startsWith("c")); // c로 시작하는 단어는 빼라
        name.forEach(System.out::println);

        System.out.println("=================");

        name.sort(String::compareToIgnoreCase); // 문자열 정렬
        name.forEach(System.out::println);


    }
}
