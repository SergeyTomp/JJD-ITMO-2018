package taskManager;

public enum TaskStatus {
    NEW ("NEW"),
    IN_WORK ("Статус: в работе"),
    CHECKED ("CHECKED"),
    DONE ("DONE"),;

    String s;
    TaskStatus(String s) {
        this.s = s;
    }

    public String getStatus() {
        return s;
    }
}
