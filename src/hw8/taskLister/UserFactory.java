package hw8.taskLister;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static hw8.taskLister.CommandStrings.*;


public class UserFactory extends Staff{

    UserFactory (String name, String pass, String access, Map staffList) {
        super.access = access;
        super.pass = pass;
        super.name = name;
        super.taskList = new ArrayList<>();
        super.commands = new HashMap<>();
        super.staffList = staffList;
        commands.put(SHOW_COMMANDS, new CommandMaker(SHOW_COMMANDS).getHandler());
        commands.put(EXIT, new CommandMaker(EXIT).getHandler());
        commands.put(CLOSE, new CommandMaker(CLOSE).getHandler());
        switch (AccessLevel.valueOf(access)) {
            case ADMIN:
                commands.put(SHOW_ALL_TASKS, new CommandMaker(SHOW_ALL_TASKS).getHandler());
                commands.put(ADD_WORKER, new CommandMaker(ADD_WORKER).getHandler());
                commands.put(CREATE_TASK, new CommandMaker(CREATE_TASK).getHandler());
                commands.put(DELETE_TASK, new CommandMaker(DELETE_TASK).getHandler());
                commands.put(REMOVE_WORKER, new CommandMaker(REMOVE_WORKER).getHandler());
                commands.put(CHANGE_STATUS, new CommandMaker(CHANGE_STATUS).getHandler());
                break;
            case SUPER:
            case MIDDLE:
            case JUNIOR:
            case COMBINED:
                commands.put(TAKE_TASK, new CommandMaker(TAKE_TASK).getHandler());
                commands.put(MARK_AS_DONE, new CommandMaker(MARK_AS_DONE).getHandler());
                commands.put(SHOW_NEW, new CommandMaker(SHOW_NEW).getHandler());
                commands.put(SHOW_IN_WORK, new CommandMaker(SHOW_IN_WORK).getHandler());
                commands.put(SHOW_CHECKED, new CommandMaker(SHOW_CHECKED).getHandler());
                commands.put(SHOW_DONE, new CommandMaker(SHOW_DONE).getHandler());
                break;
        }
    }
    private class CommandMaker {
        private Handler handler;
        public CommandMaker(CommandStrings command) {
            switch (command) {
                case MARK_AS_DONE:
                    this.handler = new Complete();
                    break;
                case SHOW_COMMANDS:
                    this.handler = new ComList();
                    break;
                case SHOW_NEW:
                    this.handler = new ShowNew();
                    break;
                case SHOW_DONE:
                    this.handler = new ShowDone();
                    break;
                case SHOW_CHECKED:
                    this.handler = new Checked();
                    break;
                case SHOW_IN_WORK:
                    this.handler = new InWork();
                    break;
                case ADD_WORKER:
                    this.handler = new CreateWorker();
                    break;
                case REMOVE_WORKER:
                    this.handler = new RemoveWorker();
                    break;
                case SHOW_ALL_TASKS:
                    this.handler = new AllTasks();
                    break;
                case CREATE_TASK:
                    this.handler = new CreateTask();
                    break;
                case DELETE_TASK:
                    this.handler = new DeleteTask();
                    break;
                case CHANGE_STATUS:
                    this.handler = new ChangeStat();
                    break;
                case TAKE_TASK:
                    this.handler = new Take();
                    break;
                case CLOSE:
                    this.handler = new Close();
                    break;
                case EXIT:
                    this.handler = new Exit();
                    break;
            }
        }

        public Handler getHandler() {
            return handler;
        }
    }
}

