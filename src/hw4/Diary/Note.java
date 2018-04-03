package hw4.Diary;

public class Note {

    private String task;

    Note (String task){
        this.task = task;
    }

    void setTask (String task){
        this.task  = task;
    }

    String getTask(){
        return task;
    }

    void printTask(){
        System.out.println(task);
    }

    void copyTask(Day day){
        day.setDayTask(new Note(task));
    }
}
