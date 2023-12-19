package time.calendarClassTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import time.Calendar;

@Test()
public class calendarClassTests {
    public void assertCalendarIntegerOfDayInMonth(){
        Calendar calendar = new Calendar();
        for (int i = 1; i < calendar.getLastDayInMonth(); i++){
            Assert.assertEquals(i, calendar.getCurrentDayOfMonth());
            calendar.incrementCurrentDay();
        }

    }

}