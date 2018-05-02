package taskManager;

import java.io.Serializable;
import java.util.*;

public class Staff implements Serializable {

    private String name;
    private String pass;
    protected AccessLevel access;
    protected ArrayList<Task> taskList;
    protected Map <String, Staff> staffList;
    protected Map <AccessLevel, ArrayList<CommandStrings>>accessTable;

    public Staff (String name, String pass, AccessLevel access, Map staffList, Map accessTable){
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
    Enum getAccess (){
        return access;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public void setAccess(AccessLevel access) {
        this.access = access;
    }
}
