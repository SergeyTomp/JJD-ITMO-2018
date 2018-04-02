package hw4.Diary;

import java.lang.reflect.Array;

public class Week {

    Day [] week;

    Week (){
        week = new Day[7];
    }

    void addDay (Day day){
        week [day.getWeekDay() - 1] = day;
    }
}
