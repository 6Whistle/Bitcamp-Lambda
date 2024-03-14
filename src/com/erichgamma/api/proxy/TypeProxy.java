package com.erichgamma.api.proxy;

import java.util.function.Function;

public class TypeProxy {
    public static Function<?, String> toString = String::valueOf;
    public static Function<String, Integer> stringToInt = Integer::parseInt;
    public static Function<String, Long> stringToLong = Long::parseLong;
    public static Function<String, Float> stringToFloat = Float::parseFloat;
    public static Function<String, Double> stringToDouble = Double::parseDouble;
}
