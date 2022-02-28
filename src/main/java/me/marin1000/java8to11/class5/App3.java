package me.marin1000.java8to11.class5;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App3 {

    public static void main(String[] args) {
        // 날짜 사이의 일수 계산하기 - Period : 사람용
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2022, Month.DECEMBER, 31);

        Period period = Period.between(today, thisYearBirthday);
        System.out.println(period.getDays());

        Period until = today.until(thisYearBirthday);
        System.out.println(until.get(ChronoUnit.DAYS));

        // 날짜 사이의 일수 계산하기 - Duration : 기계용
        Instant now = Instant.now();
        Instant plus = now.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now, plus);
        System.out.println(between.getSeconds());

        // 포맷팅팅
        LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now1.format(MMddyyyy));

        LocalDate parse = LocalDate.parse("07/15/1982", MMddyyyy);
        System.out.println(parse);

        // Date <-> Instant
        Date date = new Date();
        Instant instant2 = date.toInstant();
        Date from = Date.from(instant2);
        System.out.println(from);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        ZonedDateTime zonedDateTime2 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar from1 = GregorianCalendar.from(zonedDateTime2);
        System.out.println(from);

        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);

        LocalDateTime now2 = LocalDateTime.now();
        now.plus(10, ChronoUnit.DAYS);


    }

}
