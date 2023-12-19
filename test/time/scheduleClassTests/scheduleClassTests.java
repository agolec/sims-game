package time.scheduleClassTests;

import org.testng.annotations.Test;
import time.Calendar;
import time.Schedule;

@Test
public class scheduleClassTests {
    public void test(){
        Calendar cal = new Calendar();
        Schedule playerSchedule = new Schedule(cal);
        playerSchedule.clearSchedule();
        playerSchedule.setSchedule(3);

        System.out.println(playerSchedule.getSchedule());
        System.out.println(playerSchedule);
    }

}
