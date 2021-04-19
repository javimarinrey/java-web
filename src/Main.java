import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main {


    public static void main(String[] args) throws ParseException {

        /*int yearBefore = 2020;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = sdf.parse("01/01/2022 23:59:59");
        Calendar calendarSearch = Calendar.getInstance();
        calendarSearch.setTime(date);

        System.out.println("daysBetween = " + getNumDaysBetweenYears(calendarSearch, yearBefore));*/


        String d = "    0.84662";
        System.out.println(Double.parseDouble(d));
        System.out.println(new Double((d).replaceAll("\\s", "")));


    }

    private static long getNumDaysBetweenYears(Calendar calendar, int years) {

        boolean aplicar = false;

        Calendar tmp = Calendar.getInstance();
        tmp.set(calendar.get(Calendar.YEAR), Calendar.JANUARY, 1);
        if (tmp.get(Calendar.WEEK_OF_YEAR) == 53 ) {
            aplicar = true;
            System.out.println("El año empieza en la semana 53");
        }

        // Desplazar semana si se encuentra entre la 53 o 52 para cuadrar el cálculo de dias.
        if (calendar.get(Calendar.WEEK_OF_YEAR) == 53 || calendar.get(Calendar.WEEK_OF_YEAR) == 52) {
            calendar.set(Calendar.WEEK_OF_YEAR, 2); // mover a semana a 2
        }

        print(calendar);

        Calendar other = Calendar.getInstance();
        other.set(Calendar.YEAR, years);
        other.set(Calendar.WEEK_OF_YEAR, calendar.get(Calendar.WEEK_OF_YEAR));
        other.set(Calendar.DAY_OF_WEEK, calendar.get(Calendar.DAY_OF_WEEK));

        print(other);

        LocalDate dateCurrent = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DATE));
        LocalDate dateOther = LocalDate.of(other.get(Calendar.YEAR), other.get(Calendar.MONTH)+1, other.get(Calendar.DATE));
        int days = (int) DAYS.between(dateOther,dateCurrent);
        System.out.println("dias = " + days);
        if (aplicar) {
            System.out.println("aplicar -7 dias");
            days = days - 7;
        }
        return days;
    }

    private static void print (Calendar calendar) {
        System.out.println(calendar.getTime());
        //System.out.println("DATE=" + calendar.get(Calendar.DATE));
        //System.out.println("MONTH=" + calendar.get(Calendar.MONTH));
        /*System.out.println("DAY_OF_WEEK=" + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("DAY_OF_MONTH=" + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("DAY_OF_WEEK_IN_MONTH=" + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("DAY_OF_YEAR=" + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("WEEK_OF_MONTH=" + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("WEEK_OF_YEAR=" + calendar.get(Calendar.WEEK_OF_YEAR));*/
        System.out.println("===================");
    }


}
