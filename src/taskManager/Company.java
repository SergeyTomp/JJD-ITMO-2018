package taskManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static taskManager.AccessLevel.*;
import static taskManager.CommandStrings.*;

public class Company {

    public Map<String, Staff> staffList;
    public Map <AccessLevel, ArrayList<CommandStrings>> accessTable;

    Company() {
        staffList = new HashMap<>();
        accessTable = new HashMap<>();
        Staff admin_1 = new Staff("admin", "123", "ADMIN", staffList, accessTable);
        staffList.put ("admin", admin_1);

        accessTable.put(ADMIN, new ArrayList<>());
        accessTable.put(SUPER, new ArrayList<>());
        accessTable.put(MIDDLE, new ArrayList<>());
        accessTable.put(JUNIOR, new ArrayList<>());
        accessTable.put(COMBINED, new ArrayList<>());

        accessTable.get(ADMIN).add(SHOW_COMMANDS);
        accessTable.get(ADMIN).add(EXIT);
        accessTable.get(ADMIN).add(CLOSE);
        accessTable.get(ADMIN).add(SHOW_ALL_TASKS);
        accessTable.get(ADMIN).add(CREATE_TASK);
        accessTable.get(ADMIN).add(DELETE_TASK);
        accessTable.get(ADMIN).add(ADD_WORKER);
        accessTable.get(ADMIN).add(REMOVE_WORKER);
        accessTable.get(ADMIN).add(SHOW_ALL_TASKS);
        accessTable.get(ADMIN).add(CREATE_TASK);

        accessTable.get(SUPER).add(SHOW_COMMANDS);
        accessTable.get(SUPER).add(EXIT);
        accessTable.get(SUPER).add(CLOSE);
        accessTable.get(SUPER).add(SHOW_DONE);
        accessTable.get(SUPER).add(SHOW_NEW);
        accessTable.get(SUPER).add(SHOW_IN_WORK);
        accessTable.get(SUPER).add(SHOW_CHECKED);
        accessTable.get(SUPER).add(TAKE_TASK);
        accessTable.get(SUPER).add(MARK_AS_DONE);

        // пока все юзеры равноправны
        for (CommandStrings cs : accessTable.get(SUPER)) {
            accessTable.get(MIDDLE).add(cs);
            accessTable.get(JUNIOR).add(cs);
            accessTable.get(COMBINED).add(cs);
        }
    }
}
