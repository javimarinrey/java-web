import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class MainDate {

    public static void main(String[] args){

        int semana = 17;
        int year = 2021;

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, semana);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fecha_ini_semana = formatter.format(cal.getTime());
        cal.add(Calendar.DATE, 6);
        String fecha_fin_semana = formatter.format(cal.getTime());

        System.out.println("fecha ini: " + fecha_ini_semana);
        System.out.println("fecha fin: " + fecha_fin_semana);

        System.out.println(getDatebyWeek(year, semana));
    }

    private static String getDatebyWeek(int year, int week) {
        LocalDate start = LocalDate.ofYearDay(year, week)
                .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, week)
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate end = LocalDate.ofYearDay(year, week)
                .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, week)
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "Del " + start.format(formatter) + " al " + end.format(formatter);
    }
}
