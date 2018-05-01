package taskManager;

public enum DataErrors {DAY_ERROR ("Invalid data format"),
                        NAME_ERROR("Invalid name format"),
                        ACCESS_ERROR("Illegal access identifier"),
                        PASSWORD_BAD("Bad password");
    String message;
    DataErrors(String str) {
        message = str;
    }

    public String getMessage() {
        return message;
    }
}
