package taskManager;

public enum TaskStatus {
    NEW ("Статус: NEW"),
    IN_WORK ("Статус: IN_WORK"),
    CHECKED ("Статус: CHECKED"),
    DONE ("Статус: DONE"),;

    String s;
    TaskStatus(String s) {
        this.s = s;
    }

    public String getStatus() {
        return s;
    }
}
