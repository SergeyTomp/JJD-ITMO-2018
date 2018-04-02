package hw4.School;

import java.util.Hashtable;

public class School {
    public static void main (String [] args){

        Hashtable <String, Teacher> staff = new Hashtable<>();                                                              // пустая таблица учителей
        staff.put("MaryVanna", new Teacher("Math",5,10,50,"female","MaryVanna"));   // создаём учителя и записываем в таблицу
        // остальных учителей точно также создаём и заносим в таблицу

        Pupil tmpPupl = new Pupil(1,"1A",0,0, 7, "male", "Sidorov");         // создаём ученика, принимаем его в класс
        // остальных учеников этого же класса точно также создаём и приписываем к классу

        Subject tmpSubj = new Subject("Math", 1);                                                                // создаём программу обучения по предмету

        Flow flow1A = new Flow (staff.get("MaryVanna"), "1A", new Journal());                // создаём класс 1А с пустым журналом
        flow1A.flowJournal.subjDayMark.put(tmpSubj.getTitle(), flow1A.flowJournal.dayMark);         // создаём таблицу предмет - дата - оценка
        flow1A.flowJournal.pupilSubjDayMark.put(tmpPupl.getName(), flow1A.flowJournal.subjDayMark); // журнал класса 1А, ученику приписывается табл. предмет - дата - оценка


    }
}
