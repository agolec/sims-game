package weather;

import time.Calendar;
import time.DayOfWeek;

import java.util.ArrayList;
import java.util.List;

public class ThreeDayForcast {
    public static ThreeDayForcast singleInstance;
    Calendar cal;
    List<DayOfWeek> nextThreeDays;
    final int DAYS_OF_FORCAST = 3;
    private ThreeDayForcast(Calendar cal){
        this.cal = Calendar.getInstance();
        nextThreeDays = DayOfWeek.nextNDays(this.cal.getCurrentWeekDay(),DAYS_OF_FORCAST);
    }
    public static synchronized ThreeDayForcast getInstance(Calendar cal){
        if(singleInstance == null){
            singleInstance = new ThreeDayForcast(cal);
        }
        return singleInstance;
    }
    public void printList(){
        System.out.println(nextThreeDays);
    }
}
