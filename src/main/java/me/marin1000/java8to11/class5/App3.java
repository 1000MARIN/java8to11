package me.marin1000.java8to11.class5;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class App3 {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2022, Month.DECEMBER, 31);

        Period period = Period.between(today, thisYearBirthday);
        System.out.println(period.getDays());
    }

}
