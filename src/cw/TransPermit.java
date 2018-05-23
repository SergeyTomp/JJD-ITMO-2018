package cw;

public enum TransPermit {
    IDLE ("Свободен"),
    BUISY ("Занят");

    String status;
    TransPermit(String str) {
        status = str;
    }

    public String getStatus() {
        return status;
    }
}
