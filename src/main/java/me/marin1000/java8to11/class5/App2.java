package me.marin1000.java8to11.class5;

import java.sql.SQLOutput;
import java.time.*;

public class App2 {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);                            // 기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC")));   // 기준시 UTC, GMT

        // 현재 자신의 위치
        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);

        // 위치 기준 시간
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);

        // 현재 자신의 시스템 존을 참고한 현재 시간
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        // 날짜 만들기
        LocalDateTime birthDay =
                LocalDateTime.of(1988, Month.JANUARY, 19, 0, 0, 0, 0);
        ZonedDateTime nowInKorea = zonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        // 존에 해당하는 현재시간
        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);

        // 서로 형변환 가능 (ZonedDateTime/Instant)
        Instant instant1 = zonedDateTime1.toInstant();
    }

}
