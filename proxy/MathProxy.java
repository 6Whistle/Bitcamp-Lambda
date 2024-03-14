package com.erichgamma.api.proxy;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MathProxy {
    //abs
    public static Function<Integer, Integer> absInt = Math::abs;
    public static Function<Long, Long> absLong = Math::abs;
    public static Function<Float, Float> absFloat = Math::abs;
    public static Function<Double, Double> absDouble = Math::abs;

    //max
    public static BiFunction<Integer, Integer, Integer> maxInt = Math::max;
    public static BiFunction<Long, Long, Long> maxLong = Math::max;
    public static BiFunction<Float, Float, Float> maxFloat = Math::max;
    public static BiFunction<Double, Double, Double> maxDouble = Math::max;

    //random
    public static Supplier<Double> randomDouble = Math::random;
    public static BiFunction<Character, Character, Character> randomCharInRange = (a, b) -> (char)((Math.random() * a) + b);
    public static BiFunction<Integer, Integer, Integer> randomIntInRange = (a, b) -> (int)(Math.random() * a + b);
    public static BiFunction<Long, Long, Long> randomLongInRange = (a, b) -> (long)(Math.random() * a + b);
    public static BiFunction<Float, Float, Float> randomFloatInRange = (a, b) -> (float)(Math.random() * a + b);
    public static BiFunction<Double, Double, Double> randomDoubleInRange = (a, b) -> Math.random() * a + b;

    //floor Float
    public static Function<Float, Integer> floorFloatToInt = (a) -> (int) Math.floor(a);
    public static Function<Float, Long> floorFloatToLong = (a) -> (long) Math.floor(a);
    public static Function<Float, Float> floorFloatToFloat = (a) -> (float) Math.floor(a);
    public static Function<Float, Double> floorFloatToDouble = Math::floor;

    //floor Double
    public static Function<Double, Integer> floorDoubleToInt = (a) -> (int) Math.floor(a);
    public static Function<Double, Long> floorDoubleToLong = (a) -> (long) Math.floor(a);
    public static Function<Double, Float> floorDoubleToFloat = (a) -> (float) Math.floor(a);
    public static Function<Double, Double> floorDoubleToDouble = Math::floor;

    //round Float
    public static Function<Float, Integer> roundFloatToInt = (a) -> (int) Math.round(a);
    public static Function<Float, Integer> roundFloatToLong = Math::round;
    public static Function<Float, Float> roundFloatToFloat = (a) -> (float) Math.round(a);
    public static Function<Float, Double> roundFloatToDouble = (a) -> (double) Math.round(a);

    //round Double
    public static Function<Double, Integer> roundDoubleToInt = (a) -> (int) Math.round(a);
    public static Function<Double, Long> roundDoubleToLong = Math::round;
    public static Function<Double, Float> roundDoubleToFloat = (a) -> (float) Math.round(a);
    public static Function<Double, Double> roundDoubleToDouble = (a) -> (double) Math.round(a);

    //ceil Float
    public static Function<Float, Integer> ceilFloatToInt = (a) -> (int) Math.ceil(a);
    public static Function<Float, Long> ceilFloatToLong = (a) -> (long) Math.ceil(a);
    public static Function<Float, Float> ceilFloatToFloat = (a) -> (float) Math.ceil(a);
    public static Function<Float, Double> ceilFloatToDouble = Math::ceil;

    //ceil Double
    public static Function<Double, Integer> ceilDoubleToInt = (a) -> (int) Math.ceil(a);
    public static Function<Double, Long> ceilDoubleToLong = (a) -> (long) Math.ceil(a);
    public static Function<Double, Float> ceilDoubleToFloat = (a) -> (float) Math.ceil(a);
    public static Function<Double, Double> ceilDoubleToDouble = Math::ceil;


    //parse Int
    public static Function<Integer, Long> parseIntToLong = (a) -> (long) a;
    public static Function<Integer, Float> parseIntToFloat = Integer::floatValue;
    public static Function<Integer, Double> parseIntToDouble = Integer::doubleValue;

    //parse Long
    public static Function<Long, Integer> parseLongToInt = Long::intValue;
    public static Function<Long, Float> parseLongToFloat = Long::floatValue;
    public static Function<Long, Double> parseLongToDouble = Long::doubleValue;

    //parse Float
    public static Function<Float, Integer> parseFloatToInt = Float::intValue;
    public static Function<Float, Long> parseFloatToLong = Float::longValue;
    public static Function<Float, Double> parseFloatToDouble = Float::doubleValue;

    //parse Double
    public static Function<Double, Integer> parseDoubleToInt = Double::intValue;
    public static Function<Double, Long> parseDoubleToLong = Double::longValue;
    public static Function<Double, Float> parseDoubleToFloat = Double::floatValue;



}

