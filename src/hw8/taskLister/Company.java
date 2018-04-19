package hw8.taskLister;

import java.util.HashMap;
import java.util.Map;

public class Company {

    protected Map<String, Staff> staffList;
    Company () {
        staffList = new HashMap<>();
        Admin admin_1 = new Admin("admin", "123", "admin", staffList);
        staffList.put ("admin", admin_1);
    }
}
