package proxy;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class DateProxy {

    //get
    public static Supplier<LocalTime> getLocalTime = LocalTime::now;
    public static Supplier<LocalDate> getLocalDate = LocalDate::now;
    public static Supplier<LocalDateTime> getLocalDateTime = LocalDateTime::now;

}
