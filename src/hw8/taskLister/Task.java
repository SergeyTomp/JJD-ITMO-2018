package hw8.taskLister;

public class Task {

    private String taskText;
    private String startDate;
    private String deadLine;
    private String status;
    Task (String taskText, String startDate, String deadLine, String status){
        this.taskText = taskText;
        this.startDate = startDate;
        this.deadLine = deadLine;
        this.status = status;
    }
    String getContent (){
        return taskText;
    }
    String getStartDate (){
        return startDate;
    }
    String getEndDate (){
        return deadLine;
    }
    String getStatus (){
        return status;
    }
    boolean setStatus (String stat){
        status = stat;
        return true;
    }
    boolean setDeadLine (String date){
        deadLine = date;
        return true;
    }
}
