package time;

public class Calendar {
    private final int FIRST_DAY_IN_MONTH = 1;
    private final int FINAL_DAY_IN_MONTH = 30;
    private Month currentMonth;
    private int currentDayOfMonth;
    private DayOfWeek currentWeekDay;
    private static Calendar singleInstance  = null;
    private Season currentSeason = null;


    private Calendar(){
        this.currentMonth = Month.JANUARY;
        this.currentDayOfMonth = FIRST_DAY_IN_MONTH;
        this.currentWeekDay = DayOfWeek.MONDAY;
        this.currentSeason = setSeason();
    }
//    public Calendar(Calendar originCalendar){
//        this.currentMonth = originCalendar.getCurrentMonth();
//        this.currentDayOfMonth = originCalendar.getCurrentDayOfMonth();
//        this.currentWeekDay = originCalendar.getCurrentWeekDay();
//    }
    public static synchronized Calendar getInstance(){
        if(singleInstance == null){
            singleInstance = new Calendar();
        }
        return singleInstance;
    }
    public Month getCurrentMonth(){
        return this.currentMonth;
    }

    public DayOfWeek getCurrentWeekDay(){
        return this.currentWeekDay;
    }
    public int getCurrentDayOfMonth(){
        return this.currentDayOfMonth;
    }

    public int getLastDayInMonth(){
        return this.FINAL_DAY_IN_MONTH;
    }

    /**
     * incrementCurrentDay will increment the current day of the month in this class's calendar.
     *
     * if the value of currentDay is equal to the constant FINAL_DAY_IN_MONTH, we will call methods
     * incrementCurrentMonth(), resetCurrentDayToFirstDay() and setCalendarDayToCurrentDay().
     */
    public void incrementCurrentDay(){
        if(currentDayIsFinalDayOfMonth()){
            incrementCurrentMonth();
            resetCurrentDayToFirstDay();
        } else {
            this.currentDayOfMonth++;
        }
        //Day of week always increments, so do this outside conditional statement.
        incrementDayOfWeek();
    }

    private boolean currentDayIsFinalDayOfMonth() {
        return this.currentDayOfMonth == FINAL_DAY_IN_MONTH;
    }
    private void incrementCurrentMonth(){
        switch(this.currentMonth){
            case JANUARY -> this.currentMonth = Month.FEBRUARY;
            case FEBRUARY -> this.currentMonth = Month.MARCH;
            case MARCH -> this.currentMonth = Month.APRIL;
            case APRIL -> this.currentMonth = Month.MAY;
            case MAY -> this.currentMonth = Month.JUNE;
            case JUNE -> this.currentMonth = Month.JULY;
            case JULY -> this.currentMonth = Month.AUGUST;
            case AUGUST -> this.currentMonth = Month.SEPTEMBER;
            case SEPTEMBER-> this.currentMonth = Month.OCTOBER;
            case OCTOBER -> this.currentMonth = Month.NOVEMBER;
            case NOVEMBER -> this.currentMonth = Month.DECEMBER;
            case DECEMBER -> this.currentMonth = Month.JANUARY;
        }
    }
    private void resetCurrentDayToFirstDay(){
        this.currentDayOfMonth = this.FIRST_DAY_IN_MONTH;

    }
    private void incrementDayOfWeek(){
        switch(this.currentWeekDay){
            case SUNDAY -> this.currentWeekDay = DayOfWeek.MONDAY;
            case MONDAY -> this.currentWeekDay = DayOfWeek.TUESDAY;
            case TUESDAY -> this.currentWeekDay = DayOfWeek.WEDNESDAY;
            case WEDNESDAY -> this.currentWeekDay = DayOfWeek.THURSDAY;
            case THURSDAY -> this.currentWeekDay = DayOfWeek.FRIDAY;
            case FRIDAY -> this.currentWeekDay = DayOfWeek.SATURDAY;
            case SATURDAY -> this.currentWeekDay = DayOfWeek.SUNDAY;
        }
    }
    public Season setSeason(){
        Season newSeason = null;
        switch(this.currentMonth){
            case DECEMBER:
            case JANUARY:
            case FEBRUARY:
                newSeason = Season.WINTER;
                break;
            case MARCH:
            case APRIL:
            case MAY:
                newSeason = Season.SPRING;
                break;
            case JUNE:
            case JULY:
            case AUGUST:
                newSeason = Season.SUMMER;
                break;
            case SEPTEMBER:
            case OCTOBER:
            case NOVEMBER:
                newSeason = Season.FALL;
                break;
        }
        return newSeason;
    }
    public Season getCurrentSeason(){
        return this.getCurrentSeason();
    }

    public String toString(){
        String currentInfo = "Current Date: " + this.getCurrentDayOfMonth() + "\n"
                + "Current Day of Week: " + this.getCurrentWeekDay() + "\n"
                + "Current Month: " + this.getCurrentMonth() + "\n";
        return currentInfo;
    }

}
