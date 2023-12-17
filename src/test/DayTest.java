package test;

import time.Day;
import time.Month;

public class DayTest {
    public static void main(String[] args){
        Day day = new Day();
        System.out.println(day);

        boolean doneOneJanuaryLoop = false;
        do{
            for(int i = 0; i < day.getLastDayInMonth();i++){
                if(day.getCurrentMonth() == Month.DECEMBER && day.getCalendarDate() == 27){
                    System.out.println("break here.");
                }
                day.incrementCurrentDay();
                System.out.println(day);
            }
            doneOneJanuaryLoop = true;
            System.out.println();
            System.out.println("end of month.");
        }while(doneOneJanuaryLoop && day.getCurrentMonth() != Month.JANUARY);

    }
}
