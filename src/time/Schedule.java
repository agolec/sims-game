package time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Schedule extends Calendar {
    List<DayOfWeek> schedule;
    private int FIVE_DAY_WORK_WEEK = 5;
    private final List<DayOfWeek> daysOfTheWeek = Arrays.asList(DayOfWeek.values());

    public Schedule(){
        this.schedule = setSchedule();
    }
    public Schedule(int daysToWork){
        this.schedule = initializeSchedule(daysToWork);
    }
    public List<DayOfWeek> setSchedule(){
        List<DayOfWeek> daysOfTheWeek = Arrays.asList(DayOfWeek.values());
        List<DayOfWeek> workWeek = new ArrayList<>();
        Collections.shuffle(daysOfTheWeek);
        for(int i = 0; i < FIVE_DAY_WORK_WEEK;i++){
            workWeek.add(daysOfTheWeek.get(i));
        }
        return workWeek;
    }
    public List<DayOfWeek> initializeSchedule(final int daysToWork){
        return generateSchedule(daysToWork);
    }
    public void setSchedule(final int daysToWork){
        this.schedule = generateSchedule(daysToWork);
    }
    public List<DayOfWeek> generateSchedule(final int daysToWork){
        int numberOfDaysToWork = daysToWork;
        System.out.println("length of doww.values: " + DayOfWeek.values().length);
        if(numberOfDaysToWork > DayOfWeek.values().length){
            numberOfDaysToWork = DayOfWeek.values().length;
        }
        List<DayOfWeek> daysOfTheWeek = Arrays.asList(DayOfWeek.values());
        List<DayOfWeek> workWeek = new ArrayList<>();
        Collections.shuffle(daysOfTheWeek);
        for(int i = 0; i < numberOfDaysToWork;i++){
            workWeek.add(daysOfTheWeek.get(i));
        }
        return workWeek;
    }
    public List<DayOfWeek> getSchedule(){
        return this.schedule;
    }
    public void clearSchedule(){
        if(this.schedule != null){
            this.schedule.clear();
        }
    }
}
