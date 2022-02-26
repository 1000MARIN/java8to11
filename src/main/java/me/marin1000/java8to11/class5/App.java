package me.marin1000.java8to11.class5;

import org.yaml.snakeyaml.scanner.ScannerImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * [ Date와 Time ] - Date와 Time 소개
 *
 * 자바 8에 새로운 날짜와 시간 API가 생긴 이유
 *
 * ● 그전까지 사용하던 java.util.Date 클래스는 mutable 하기 때문에 thead safe하지 않다.
 * ● 클래스 이름이 명확하지 않다. Date인데 시간까지 다룬다.
 * ● 버그 발생할 여지가 많다. (타입 안정성이 없고, 월이 0부터 시작한다거나..)
 * ● 날짜 시간 처리가 복잡한 애플리케이션에서는 보통 ​Joda Time​을 쓰곤했다.
 *
 *  자바 8에서 제공하는 Date-Time API
 *  ● JSR-310 스팩의 구현체를 제공한다.
 *  ● 디자인 철학
 *     ○ Clear
 *     ○ Fluent
 *     ○ Immutable
 *     ○ Extensible
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);   // 기계용 시간

        Calendar jinBirthDay = new GregorianCalendar(1988, Calendar.JANUARY, 19);
        System.out.println(jinBirthDay.getTime());
        jinBirthDay.add(Calendar.DAY_OF_YEAR, 1); // 날짜 하루 뒤로
        System.out.println(jinBirthDay.getTime());
    }
}
