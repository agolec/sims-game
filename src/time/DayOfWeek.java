package time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum DayOfWeek {
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
    public static List<DayOfWeek> nextNDays(DayOfWeek currentDayOfWeek, int daysForForcast){
        int daysForForcastValidation = 0;
        List<DayOfWeek> nextThreeDaysOfWeek = new ArrayList<>();
        int currentDayIndex = currentDayOfWeek.ordinal();
        int[] nextNDaysIndexes;
        daysForForcastValidation = validateDaysOfForcastInput(daysForForcast);
        nextNDaysIndexes = new int[daysForForcastValidation];
        getNextNDayValues(daysForForcastValidation, currentDayIndex, nextNDaysIndexes);
        populateList(nextThreeDaysOfWeek,nextNDaysIndexes);
        return nextThreeDaysOfWeek;
    }

    private static void getNextNDayValues(int daysForForcastValidation, int currentDayIndex, int[] nextnDaysIndexes) {
        for(int i = 0; i < daysForForcastValidation; i++){
            nextnDaysIndexes[i] = (currentDayIndex + (i+1)) % DayOfWeek.values().length;
        }
    }

    private static int validateDaysOfForcastInput(int daysOfForcast){
        if(daysOfForcast > DayOfWeek.values().length){
            return DayOfWeek.values().length;
        } else {
            return daysOfForcast;
        }
    }
    private static void populateList(List<DayOfWeek> daysOfForcast,int[] indexes){
        for(int i = 0; i < indexes.length;i++){
            daysOfForcast.add(DayOfWeek.values()[indexes[i]]);
        }
    }
}
