package taskManager;

public class Task{

    private String taskText;
    private String startDate;
//    private LocalDate startDate;
    private String deadLine;
//    private LocalDate deadLine;
    private TaskStatus status;
//    Task (String taskText, LocalDate startDate, LocalDate deadLine, String status){
    Task (String taskText, String startDate, String deadLine, TaskStatus status){
        this.taskText = taskText;
        this.startDate = startDate;
        this.deadLine = deadLine;
        this.status = status;
    }
    String getContent (){
        return taskText;
    }
    //    LocalDate getStartDate (){
    String getStartDate (){
        return startDate;
    }
//    LocalDate getEndDate (){
    String getEndDate (){
        return deadLine;
    }
    TaskStatus getStatus (){
        return status;
    }
    boolean setStatus (TaskStatus stat){
        status = stat;
        return true;
    }
//    boolean setEndDate (LocalDate date){
    boolean setEndDate (String date){
        deadLine = date;
        return true;
    }
}
