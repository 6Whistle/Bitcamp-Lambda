package com.erichgamma.api.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WeekendStrategy {
    Monday("1", i -> "Monday"),
    Tuesday("2", i -> "Tuesday"),
    Wednesday("3", i -> "Wednesday"),
    Thursday("4", i -> "Thursday"),
    Friday("5", i -> "Friday"),
    Saturday("6", i -> "Saturday"),
    Sunday("7", i -> "Sunday"),
    WeekError("8", i -> "WeekError");
    private final String name;
    private final Function<Scanner, String> function;
    private static final Map<String, WeekendStrategy> weekMap = Stream.of(values()).collect(Collectors.toMap(i -> i.name, j -> j));

    WeekendStrategy(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String execute(Scanner sc) {
        System.out.println("1~7 입력: ");
        String s = sc.next();
        return Optional.ofNullable(weekMap.get(s)).orElse(WeekError).function.apply(sc);
    }
}
