package taskManager;

import java.util.*;

public class Staff {

    protected String name;
    protected String pass;
    protected String access;
    protected ArrayList<Task> taskList;
    protected Map <String, Staff> staffList;
    protected Map <AccessLevel, ArrayList<CommandStrings>>accessTable;

    public Staff (String name, String pass, String access, Map staffList, Map accessTable){
        this.access = access;
        if (pass.isEmpty()){
            throw new DataException(DataErrors.PASSWORD_BAD.getMessage());
        }
        this.pass = pass;
        if (name.isEmpty()){
            throw new DataException(DataErrors.NAME_ERROR.getMessage());
        }
        this.name = name;
        this.taskList = new ArrayList<>();
        this.accessTable = accessTable;
        this.staffList = staffList;
    }
    String getName (){
        return name;
    }
    String getPass(){
        return pass;
    }
    String getAccess (){
        return access;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public void setAccess(String access) {
        this.access = access;
    }
}
