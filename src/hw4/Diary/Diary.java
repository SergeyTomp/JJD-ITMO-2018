package hw4.Diary;

public class Diary {

    public static void main (String [] args){
        Year year2020 = new Year (2020); //создаём год
        Note task = new Note ("Дело_1"); //создаём запись
        year2020.getWeek(15).getDay(3).setDayTask(task); //заносим запись в нужный день
        task = new Note ("Дело_2"); //создаём запись
        year2020.getWeek(15).getDay(3).setDayTask(task); //заносим запись в нужный день
        task = new Note ("Дело_3"); //создаём запись
        year2020.getWeek(15).getDay(3).setDayTask(task); //заносим запись в нужный день
        year2020.getWeek(15).getDay(3).getDayTaskList(); //выводим список задач на день
        System.out.println(year2020.getWeek(15).getDay(3).getWeekDay());//выводим день недели
        Day tmp = year2020.getWeek(15).getDay(3);   //временная переменная дня, в который будем копировать задачу
        year2020.getWeek(15).getDay(3).getTask(1).copyTask(tmp); // копируем запись в другой день
        year2020.getWeek(15).getDay(3).getDayTaskList(); //выводим обновлённый список задач на день
    }
}
