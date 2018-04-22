package hw8.taskLister;

import java.util.HashMap;
import java.util.Map;

public class Company {

    Map<String, Staff> staffList;
    Company () {
        staffList = new HashMap<>();
        Staff admin_1 = new UserFactory("admin", "123", "ADMIN", staffList);
        staffList.put ("admin", admin_1);
    }
}
