package me.marin1000.java8to11.class7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 유지시간
@Target(ElementType.TYPE_USE)       // 사용위치
public @interface ChickenContainer {
    Chicken[] value();
}
