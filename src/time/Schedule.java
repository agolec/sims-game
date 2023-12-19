package time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Schedule extends Calendar {
    public final static int WORK_DAYS_IN_WEEK = 5;
    public final static int NUMBER_OF_DAYS_IN_WEEK = DayOfWeek.values().length;
    public final static int FULL_SHIFT_HOURS = 8;
    private int[] workSchedule;
    private int numberOfDaysWorking;
    public Schedule(){
        workSchedule = new int[NUMBER_OF_DAYS_IN_WEEK];
        numberOfDaysWorking = 0;
    }
    public void setNumberOfDaysWorking(int numberOfDaysWorking){
        if(numberOfDaysWorking > WORK_DAYS_IN_WEEK){
            numberOfDaysWorking = WORK_DAYS_IN_WEEK;
        }
        this.numberOfDaysWorking = numberOfDaysWorking;
    }
    public int getNumberOfDaysWorking(){
        return this.numberOfDaysWorking;
    }

    public int getDaysInWorkSchedule(){
        return workSchedule.length;
    }

    /**
     * generateSchedule() should take the value of numberOfDaysWorking that is
     * given to the class with the setNumberOfDaysWorking() method, and assign an 8 hour shift
     * into the same number of elements of the workSchedule array. The remaining elements of workSchedule should be 0.
     *
     */
    public void generateSchedule(int numberOfDaysWorking){
        int hours = 0;
        setNumberOfDaysWorking(numberOfDaysWorking);
        List<Integer> daysOfWeek = new ArrayList<Integer>(NUMBER_OF_DAYS_IN_WEEK);
        for(int i = 0; i < NUMBER_OF_DAYS_IN_WEEK;i++){
            daysOfWeek.add(i);
        }
        Collections.shuffle(daysOfWeek);
        System.out.println("shuffled: " + daysOfWeek);
        //get value of daysOfWeek.get(i), which should be a number between 1-7, and assign it to workschedule[i]
        for(int i = 0; i < this.numberOfDaysWorking; i++){
            hours = daysOfWeek.get(i);
            if(hours != 0){
                workSchedule[i] = hours;
            }
            else {
                workSchedule[i] = 0;
            }
        }
    }
    /**
     * generateSchedule() should take the value of numberOfDaysWorking that is
     * given to the class with the setNumberOfDaysWorking() method, and assign an 8 hour shift
     * into the same number of elements of the workSchedule array. The remaining elements of workSchedule should be 0.
     *
     */
    public void generateSchedule(){
        int workingThisDay = 0;
        List<Integer> daysOfWeek = new ArrayList<Integer>(NUMBER_OF_DAYS_IN_WEEK);
        for(int i = 0; i < NUMBER_OF_DAYS_IN_WEEK;i++){
            daysOfWeek.add(i);
        }
        Collections.shuffle(daysOfWeek);
        System.out.println("shuffled: " + daysOfWeek);
        //get value of daysOfWeek.get(i), which should be a number between 1-7, and assign it to workschedule[i]
        for(int i = 0; i < this.numberOfDaysWorking; i++){
            workingThisDay = daysOfWeek.get(i);
            workSchedule[workingThisDay] = 8;
        }
    }
//    private int determineDayWorked(int day){
//        DayOfWeek dayWorking = DayOfWeek.SUNDAY;
//        switch(day){
//            case 0 -> {
//                dayWorking = DayOfWeek.SUNDAY;
//            }
//            case 1 -> {
//                dayWorking = DayOfWeek.MONDAY;
//            }
//            case 2 -> {
//                dayWorking = DayOfWeek.TUESDAY;
//            }
//            case 3 -> {
//                dayWorking = DayOfWeek.WEDNESDAY;
//            }
//            case 4 -> {
//                dayWorking = DayOfWeek.THURSDAY;
//            }
//            case 5 -> {
//                dayWorking = DayOfWeek.FRIDAY;
//            }
//            case 6 -> {
//                dayWorking = DayOfWeek.SATURDAY;
//            }
//        }
//        return dayWorking;
//    }
    public int[] getSchedule(){
        return Arrays.copyOf(this.workSchedule, this.workSchedule.length);
    }


}
