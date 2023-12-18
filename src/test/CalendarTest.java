package test;

import time.Calendar;
import time.Month;

public class CalendarTest {
    public static void main(String[] args){
        Calendar calendar = new Calendar();
        System.out.println(calendar);

        boolean doneOneJanuaryLoop = false;
        do{
            for(int i = 0; i < calendar.getLastDayInMonth(); i++){
                if(calendar.getCurrentMonth() == Month.DECEMBER && calendar.getCalendarDate() == 27){
                    System.out.println("break here.");
                }
                calendar.incrementCurrentDay();
                System.out.println(calendar);
            }
            doneOneJanuaryLoop = true;
            System.out.println();
            System.out.println("end of month.");
        }while(doneOneJanuaryLoop && calendar.getCurrentMonth() != Month.JANUARY);

    }
}
