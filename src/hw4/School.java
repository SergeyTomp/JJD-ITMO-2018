package hw4;

public class School {
    public static void main (String [] args){

        Teacher tmpTeach = new Teacher("Math",5,10,50,"female","MaryVanna");        // создаём учителя
        Pupil tmpPup = new Pupil(1,"1A",0,0, 7, "male", "Sidorov");         // создаём ученика
        Subject tmpSub = new Subject("Math", 1);                                                                // создаём предмет

        Flow flow1A = new Flow(tmpTeach,"1A", new Journal());                           // создаём класс 1А
        flow1A.flowJournal.subjDayMark.put(tmpSub.getTitle(), flow1A.flowJournal.dayMark);    //создаём таблицу предмет - дата - оценка
        flow1A.flowJournal.pupilSubjDayMark.put(tmpPup.name, flow1A.flowJournal.subjDayMark); //создаём журнал, к имени ученика приписывается табл. предмет - дата - оценка


    }
}
