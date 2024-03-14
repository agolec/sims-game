package weather;

import time.Calendar;
import time.DayOfWeek;
import time.Month;
import time.Season;

import java.time.MonthDay;
import java.util.List;
import java.util.Random;

public class ForcastDays {
    public static ForcastDays singleInstance;
    Calendar cal;
    List<DayOfWeek> nextThreeDays;
    List <Weather> weatherForDays;
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
    public List<Weather> generateWeather(){
        int[] probabilities = new int[DAYS_OF_FORCAST];
        probabilities = generateProbabilities(DAYS_OF_FORCAST);

        return null;
    }
    private int[] generateProbabilities(int size){
//        int[] probabilities = new int[size];
//        Random random = new Random();
//        for(int i = 0; i < size;){
//            switch(cal.getCurrentSeason()){
//                case SPRING:
//                    probabilities[probabilities.length] = random.nextInt(0,500);
//                    brea
//
//            }
//        }
        return new int [0];

    }
    public void printList(){
        System.out.println(nextThreeDays);
    }
}
