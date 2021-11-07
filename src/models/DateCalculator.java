package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateCalculator {

    public static long dateCalculator(String startDate, String endDate) throws ParseException {
        DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR, 24);
        Date dateStart = simpleDateFormat.parse(startDate);
        Date dateEnd = simpleDateFormat.parse(endDate);
            long getDiff = dateEnd.getTime() - dateStart.getTime();
            return TimeUnit.MILLISECONDS.toDays(getDiff);
    }

    public static int dateCompare(String startDate, String endDate) throws ParseException {
        DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateStart = simpleDateFormat.parse(startDate);
        Date dateEnd = simpleDateFormat.parse(endDate);
        return dateStart.compareTo(dateEnd);
    }

//    public static void main(String[] args) throws ParseException {
//        System.out.println(dateCalculator("20/09/1996","20/10/1996"));
//        System.out.println(dateCompare("20/09/1996","20/09/1996"));
//    }

}
