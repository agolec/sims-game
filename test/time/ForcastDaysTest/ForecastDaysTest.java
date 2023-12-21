package time.ForcastDaysTest;

import org.testng.annotations.Test;
import time.Calendar;
import weather.ForcastDays;

public class ForecastDaysTest {
    Calendar cal = Calendar.getInstance();
    ForcastDays forcast;
    @Test
    public void testDays(){
        forcast = ForcastDays.getInstance(cal);
        forcast.printList();
    }
}
