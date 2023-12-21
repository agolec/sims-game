package weather;

import time.Calendar;
import time.DayOfWeek;

import java.util.List;

public class ForcastDays {
    public static ForcastDays singleInstance;
    Calendar cal;
    List<DayOfWeek> nextThreeDays;
    final int DAYS_OF_FORCAST = 3;
    private ForcastDays(Calendar cal){
        this.cal = Calendar.getInstance();
        nextThreeDays = DayOfWeek.nextNDays(this.cal.getCurrentWeekDay(),DAYS_OF_FORCAST);
    }
    public static synchronized ForcastDays getInstance(Calendar cal){
        if(singleInstance == null){
            singleInstance = new ForcastDays(cal);
        }
        return singleInstance;
    }
    public void printList(){
        System.out.println(nextThreeDays);
    }
}
