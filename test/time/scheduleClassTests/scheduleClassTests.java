package time.scheduleClassTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import time.DayOfWeek;
import time.Schedule;

@Test
public class scheduleClassTests {
    Schedule playerSchedule = new Schedule();
    public void ScheduleClassTests(){
        Assert.assertEquals(5,Schedule.WORK_DAYS_IN_WEEK);
        Assert.assertEquals(7,Schedule.NUMBER_OF_DAYS_IN_WEEK);
    }
    public void assignNumberOfDays(){
        System.out.println("assigning number of work days in the week");
        playerSchedule.setNumberOfDaysWorking(3);
        System.out.println("number of days working: " + playerSchedule.getNumberOfDaysWorking());
        System.out.println("Generating schedule. . .");
        playerSchedule.generateSchedule();
        int[] daysWorking = playerSchedule.getSchedule();
        for(int i = 0; i < daysWorking.length;i++){
            System.out.print(daysWorking[i] + " ");
        }
    }
}
