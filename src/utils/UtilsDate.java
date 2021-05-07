package utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;

public class UtilsDate {

    public static String formatTime(long miliseconds) {
        int total_seconds = (int) miliseconds / 1000;
        int sec = total_seconds % 60;
        int min = (total_seconds / 60) % 60;
        int hours = (total_seconds / 60) / 60;
        return hours + "h:" + min + "m:" + sec + "s";
    }

    /**
     *
     * @param year
     * @param week
     * @param dayOfWeek { 1: MONDAY, ..., 7:SUNDAY }
     * @return
     */
    public static String getDateFromWeekYear(int year, int week, int dayOfWeek) {
        LocalDate localDate = LocalDate.ofYearDay(year, week)
                .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, week)
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.of(dayOfWeek)));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDate.format(formatter);
    }

}
