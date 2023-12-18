package time;

public class Calendar {
    private final int FIRST_DAY_IN_MONTH = 1;
    private final int FINAL_DAY_IN_MONTH = 30;
    private int calendar[] = {FIRST_DAY_IN_MONTH, FIRST_DAY_IN_MONTH, FIRST_DAY_IN_MONTH, FIRST_DAY_IN_MONTH,
            FIRST_DAY_IN_MONTH, FIRST_DAY_IN_MONTH, FIRST_DAY_IN_MONTH, FIRST_DAY_IN_MONTH,
            FIRST_DAY_IN_MONTH, FIRST_DAY_IN_MONTH, FIRST_DAY_IN_MONTH, FIRST_DAY_IN_MONTH};
    private DayOfWeek currentWeekDay;
    private int currentDay;
    private Month currentMonth;

    public Calendar(){
        this.currentMonth = Month.JANUARY;
        this.currentDay = FIRST_DAY_IN_MONTH;
        this.currentWeekDay = DayOfWeek.MONDAY;
    }
    public int getDate(){
        return calendar[currentDay];
    }

    /**
     * incrementCurrentDay will increment the current day of the month in this class's calendar.
     *
     * if the value of currentDay is equal to the constant FINAL_DAY_IN_MONTH, we will call methods
     * incrementCurrentMonth(), resetCurrentDayToFirstDay() and setCalendarDayToCurrentDay().
     */
    public void incrementCurrentDay(){
        boolean currentDayIsFinalDayOfMonth = (this.currentDay == FINAL_DAY_IN_MONTH);
        if(currentDayIsFinalDayOfMonth){
            incrementCurrentMonth();
            resetCurrentDayToFirstDay();
            setCalendarDayToCurrentDay();
        } else {
            this.currentDay++;
            //this.calendar[this.currentMonth.ordinal()] = this.currentDay;
            setCalendarDayToCurrentDay();
        }
        //Day of week always increments, so do this outside conditional statement.
        incrementDayOfWeek();
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
        this.currentDay = this.FIRST_DAY_IN_MONTH;

    }
    private void setCalendarDayToCurrentDay(){
        this.calendar[this.currentMonth.ordinal()] = this.currentDay;
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
    public int getCalendarDate(){
        return this.calendar[this.currentMonth.ordinal()];
    }
    public Month getCurrentMonth(){
        return this.currentMonth;
    }
    public int getLastDayInMonth(){
        return this.FINAL_DAY_IN_MONTH;
    }
    public DayOfWeek getCurrentWeekDay(){
        return this.currentWeekDay;
    }
    public String toString(){
        String currentInfo = "Current Date: " + getCalendarDate() + "\n"
                + "Current Day of Week: " + this.currentWeekDay + "\n"
                + "Current Month: " + this.currentMonth + "\n";
        return currentInfo;
    }

}
