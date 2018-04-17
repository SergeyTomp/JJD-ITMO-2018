package hw8.taskLister;

import java.util.HashMap;
import java.util.Map;

public class Company {

    private Map<String, Staff> staffList;
    Company () {
        staffList = new HashMap<>();
        Admin admin_1 = new Admin("admin", "123", "admin");
        staffList.put ("admin", admin_1);
    }
}
