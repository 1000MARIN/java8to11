package me.marin1000.java8to11.class5;

import java.sql.SQLOutput;
import java.time.*;

public class App2 {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);                            // 기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC")));   // 기준시 UTC, GMT

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime birthDay =
                LocalDateTime.of(1988, Month.JANUARY, 19, 0, 0, 0, 0);

    }

}
