package hw4.Diary;

import java.util.ArrayList;
import java.util.Iterator;

public class Day {

    private int weekDay;
    private ArrayList<Note> dayList;

    Day (int weekDay){
        this.dayList = new ArrayList<>();
        this.weekDay = weekDay;
    }

    void setDayTask (Note task){
        dayList.add (task);
    }

    void getDayTaskList (){
        Iterator <Note> iterat = dayList.iterator();
        while(iterat.hasNext()){
            iterat.next().printTask();
        }
    }

    Note getTask(int taskNum){
        return dayList.get(taskNum);
    }

    public String getWeekDay(){
        switch (weekDay){
            case 1: return "Понедельник";
            case 2: return "Вторник";
            case 3: return "Среда";
            case 4: return "Четверг";
            case 5: return "Пятница";
            case 6: return "Суббота";
            case 7: return "Воскресенье";
            default: return "другой день";
        }
    }
}
