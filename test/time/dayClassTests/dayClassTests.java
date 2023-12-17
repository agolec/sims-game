package time.dayClassTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import time.Day;

@Test()
public class dayClassTests{
    public void assertCalendarIntegerOfDayInMonth(){
        Day day = new Day();
        for (int i = 1; i < day.getLastDayInMonth(); i++){
            Assert.assertEquals(i,day.getCalendarDate());
            day.incrementCurrentDay();
        }

    }

}