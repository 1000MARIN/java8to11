package me.marin1000.java8to11;

public class Foo {
    public static void main(String[] args) {
        RunSomething runSomething = (number) -> {
            return number + 10;
        };

        System.out.println(runSomething.doit(1));
        System.out.println(runSomething.doit(1));
        System.out.println(runSomething.doit(1));
    }
}
