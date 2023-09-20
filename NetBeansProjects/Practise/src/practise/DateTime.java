package practise;

import java.time.LocalDate;
import java.time.Month;
import java.time.DayOfWeek;
import java.util.Date;
import java.time.*;
import java.sql.Timestamp;

public class DateTime {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("Current date is " + localDate);
        int year = 2022;
        int monthOfYear = 11;
        int dayOfMonth = 03;
        LocalDate set = LocalDate.of(year, monthOfYear, dayOfMonth);
        Month monthOfYearMonth = localDate.getMonth();   // getMonth return type Month
        int monthOfYearInt = localDate.getMonthValue();  // getMonthValue return type int
        LocalDate set2 = LocalDate.of(year, monthOfYearMonth, dayOfMonth);
        System.out.println("Setting our own date " + set);
        System.out.println("Setting our own date with Month return type for month " + set2);
        DayOfWeek day = localDate.getDayOfWeek();
        System.out.println("Today day is " + day);
        LocalDate dateIncre = localDate.plusDays(30);
        System.out.println("Adding 30 days from Current date " + dateIncre);
        LocalDate monthIncre = localDate.plusMonths(2);
        System.out.println("Adding 2 months from Current month " + monthIncre);
        LocalDate yearIncre = localDate.plusYears(1);
        System.out.println("Adding 1 year from current year " + yearIncre);
        LocalDate weekIncre = localDate.plusWeeks(1);
        System.out.println("Adding 1 Week from Current date " + weekIncre);
        LocalDate allIncre = localDate.plusDays(30).plusMonths(2).plusYears(1);   // one by one process(Like streams)
        System.out.println("Overall adding " + allIncre);
        int lengthOfMonth = localDate.lengthOfMonth();
        int lengthOfYear = localDate.lengthOfYear();
        System.out.println("Length of Month is " + lengthOfMonth);
        System.out.println("Length of Year is " + lengthOfYear);
        String dateInString = "2022-11-02";
        LocalDate dateInLocalDate = LocalDate.parse(dateInString);
        System.out.println("convert String Date into LocalDate format " + dateInLocalDate);
        String LocalDateToString = dateInLocalDate.toString();
        System.out.println("convert Date format to String " + LocalDateToString + "\n\n");
        System.out.println("*********************TIME**************************");
        LocalTime time = LocalTime.now();
        System.out.println("current LocalTime " + time);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        System.out.println("getting hour from Time " + hour);
        System.out.println("getting minute from Time " + minute);
        System.out.println("getting second from Time " + second);
        String timeInString = "10:10:44";  //important
        LocalTime stringToTime = LocalTime.parse(timeInString); // important
        System.out.println("String Time to LocalTime convertion " + stringToTime);
        String timeToString = time.toString();
        System.out.println("Convert Time to String format " + timeToString);
        int hour1 = 10;
        int minute1 = 59;
        int second1 = 55;
        LocalTime assignTime = LocalTime.of(hour1, minute1, second1);
        System.out.println("Individual to LocalTime conversion " + assignTime);
        boolean after = assignTime.isAfter(time);
        System.out.println("Birth Time is After Current Time : " + after);
        boolean before = assignTime.isBefore(time);
        System.out.println("Birth Time is After Current Time : " + before);
        LocalTime plusTime = LocalTime.now().plusHours(01).plusMinutes(10).plusSeconds(10);
        System.out.println("plus the 1 Hour & 10 Minute & 10 Second from Current time " + plusTime + "\n\n");
        System.out.println("****************************LocalDateTime****************************");
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("LocalDateTime is " + dateTime);
        LocalDate LDFromLDT = dateTime.toLocalDate();  // Extract from LocalDateTime
        LocalTime LTFromLDT = dateTime.toLocalTime();  // Extract from LocalsDateTime 
        System.out.println("Convert LocalDateTime to LocalDate " + LDFromLDT);
        System.out.println("Convert LocalDateTime to LocalTime " + LTFromLDT);
        LocalDateTime ldt = LocalDateTime.of(2024, 02, 16, 10, 58, 59);
        System.out.println("Assiging seperately " + ldt);
        LocalDateTime datePlusTime = LocalDateTime.of(localDate, time);
        System.out.println("LocalDate + LocalTime = " + datePlusTime);
        System.out.println("***********************SQL TIMESTAMP**********************");
        Timestamp timestamp = Timestamp.valueOf(dateTime);
        System.out.println("timestamp  :  "+timestamp);
        LocalDateTime ldtTs = timestamp.toLocalDateTime();
        LocalDate ld = LocalDate.of(2022, 02, 16);
        Period period = Period.between(ld, LocalDate.now());
        System.out.println("Period " + period);
        System.out.println("\n\n***************************PERIOD & DURATION**************************");
        System.out.println("Period for Days   | Duration for Time");
        Period period1 = Period.between(LocalDate.now(), LocalDate.now().plusDays(1).plusMonths(2));
        System.out.println("period difference from today to till Date " + period1);
        Duration ltDifference = Duration.between(LocalTime.now(), LocalTime.now().plusHours(2).plusMinutes(60));
        System.out.println("Duration difference between from now to till given time " + ltDifference);
        System.out.println("Finding number of day Minutes & Hours & Seconds from Time");
        long minuteCon = ltDifference.toMinutes();
        System.out.println("Total Minutes in 3 Hours is " + minuteCon);
        long secondCon = ltDifference.toSeconds();
        System.out.println("Total Seconds in 3 Hours is " + secondCon);
        Date date = new Date();
        System.out.println(date);
        System.out.println("------testing-----");
        java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());
            java.sql.Timestamp sqlTS = new java.sql.Timestamp(utilDate.getTime());
            System.out.println("date : "+sqlDate);
            System.out.println("date : "+sqlTime);
            System.out.println("date : "+sqlTS);
    }

}
//class LocalTimeS{
//    public static void main2(String[] args) {
//        LocalTime time = LocalTime.;
//        
//    }
//}
