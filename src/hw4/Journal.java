package hw4;

import java.util.Hashtable;
// журнал класса
public class Journal {
    Hashtable <String, Integer> dayMark;            // табл. дата -> оценка
    Hashtable <String, Hashtable> subjDayMark;      // табл. предметы -> (дата -> оценка)
    Hashtable <String, Hashtable> pupilSubjDayMark; // табл. ученик -> (предметы -> (дата -> оценка))

    Journal (){
        dayMark = new Hashtable <>();
        subjDayMark = new Hashtable <>();
        pupilSubjDayMark = new Hashtable<>();
    }
}
