package me.marin1000.java8to11.class7;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // 유지 시간
@Target(ElementType.TYPE_USE)       // 선언 위치
@Repeatable(ChickenContainer.class) // 어노테이션 중복 사용 가능
public @interface Chicken {
    String value();
}
