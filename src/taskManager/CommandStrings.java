package taskManager;

public enum CommandStrings {
    SHOW_COMMANDS("SHOW_COMMANDS"),
    EXIT ("EXIT"),
    CLOSE ("CLOSE"),
    SHOW_ALL_TASKS ("SHOW_ALL_TASKS"),
    CREATE_TASK ("CREATE_TASK"),
    DELETE_TASK ("DELETE_TASK"),
    ADD_WORKER ("ADD_WORKER"),
    REMOVE_WORKER ("REMOVE_WORKER"),
    SHOW_DONE ("SHOW_DONE"),
    SHOW_NEW ("SHOW_NEW"),
    SHOW_IN_WORK ("SHOW_IN_WORK"),
    SHOW_CHECKED ("SHOW_CHECKED"),
    TAKE_TASK ("TAKE_TASK"),
    MARK_AS_DONE ("MARK_AS_DONE"),
    CHANGE_STATUS ("CHANGE_STATUS");

    String s;
    CommandStrings(String s) {
        this.s = s;
    }
    String getComTxt (){
        return s;
    }

 }
