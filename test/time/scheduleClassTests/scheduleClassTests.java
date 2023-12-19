package time.scheduleClassTests;

import org.testng.annotations.Test;
import time.Schedule;

@Test
public class scheduleClassTests {
    public void test(){
        Schedule playerSchedule = new Schedule();
        playerSchedule.clearSchedule();
        playerSchedule.setSchedule(3);

        System.out.println(playerSchedule.getSchedule());
    }

}
