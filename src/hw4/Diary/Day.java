package hw4.Diary;

import java.util.ArrayList;
import java.util.Iterator;

public class Day {

    private int weekDay;
    private ArrayList<Note> dayList;

    Day (int weekDay){
        dayList = new ArrayList<>();
        this.weekDay = weekDay;
    }

    void getDayTaskList (){
        Iterator <Note> iterat = dayList.iterator();
        while(iterat.hasNext()){
            System.out.println(iterat.next());
        }
    }

    void setDayTaskList (Note task){
        dayList.add (task);
    }

    public int getWeekDay(){
        return weekDay;
    }


}
