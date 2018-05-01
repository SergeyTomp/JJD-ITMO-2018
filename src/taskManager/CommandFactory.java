package taskManager;

import java.util.*;
import static taskManager.CommandStrings.*;
import static taskManager.TaskStatus.*;


public class CommandFactory {

    public static Handler getHandler(CommandStrings command) {

        class AllTasks implements Handler {
            @Override
            public boolean make(Staff operator) {
                for (Map.Entry entry : operator.staffList.entrySet()) {
                    System.out.println(entry.getKey());
                    for (Task tsk : operator.staffList.get(entry.getKey()).taskList) {
                        System.out.println(tsk.getContent() + " " + tsk.getStartDate() + " " + tsk.getEndDate() + " " + tsk.getStatus());
//                    System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate().format( DateTimeFormatter.ofPattern ("dd'.'MM'.'yyyy"))
//                                                        + " Complete " + tsk.getEndDate().format( DateTimeFormatter. ofPattern ("dd'.'MM'.'yyyy"));
                    }
                }
                return true;
            }
        }
        class CreateWorker implements Handler {
            @Override
            public boolean make(Staff operator) {
                String pass, user = null;
                AccessLevel access = null;
                boolean checkPassed = false;
                Scanner scan = new Scanner(System.in);
                while (!checkPassed) {
                    System.out.println("Введите имя пользователя");
                    user = scan.nextLine();
                    checkPassed = Validator.nameCheck(user);
                }
                System.out.println("Введите пароль");
                pass = scan.nextLine();
                checkPassed = false;
                while (!checkPassed) {
                    System.out.println("Введите доступ");
                    try {
                        access = AccessLevel.valueOf(scan.nextLine());
                        checkPassed = true;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Некорректный идентификатор доступа!");
                        checkPassed = false;
                    }
                }
                operator.staffList.put(user, new Staff(user, pass, access, operator.staffList, operator.accessTable));
                return true;
            }
        }
        class CreateTask implements Handler {
            @Override
            public boolean make(Staff operator) {
                String user = null, tsk, start = null, end = null;
//            String user = null, tsk;
//            LocalDate start = null, end = null;
                boolean checkPassed = false;
                Scanner scan = new Scanner(System.in);
                while (!checkPassed) {
                    System.out.println("Введите имя пользователя");
                    user = scan.nextLine();
                    checkPassed = Validator.nameCheck(user);
                }
                System.out.println("Введите задачу");
                tsk = scan.nextLine();
                checkPassed = false;
//            String tmp = null;
                while (!checkPassed) {
                    System.out.println("Введите дату начала");
//                tmp  = scan.nextLine();
//                checkPassed = Validator.dateCheck(tmp);
                    start = scan.nextLine();
                    checkPassed = Validator.dateCheck(start);
                }
//            start = LocalDate.parse(tmp, DateTimeFormatter.ofPattern ("dd'.'MM'.'yyyy"));
                checkPassed = false;
                while (!checkPassed) {
                    System.out.println("Введите дату окончания");
//                tmp  = scan.nextLine();
//                checkPassed = Validator.dateCheck(tmp);
                    end = scan.nextLine();
                    checkPassed = Validator.dateCheck(end);
                }
//             end = LocalDate.parse(tmp, DateTimeFormatter.ofPattern ("dd'.'MM'.'yyyy"));
                operator.staffList.get(user).taskList.add(new Task(tsk, start, end, NEW));
                return true;
            }
        }
        class DeleteTask implements Handler {
            @Override
            public boolean make(Staff operator) {
                String user = null, tsk;
                Scanner scan = new Scanner(System.in);
                boolean checkPassed = false;
                while (!checkPassed) {
                    System.out.println("Введите имя пользователя");
                    user = scan.nextLine();
                    if (!(checkPassed = operator.staffList.containsKey(user))) {
                        System.out.println("Пользователь не найден!");
                    }
                }
                checkPassed = false;
                Task task;
                while (!checkPassed) {
                    System.out.println("Введите задачу");
                    tsk = scan.nextLine();
                    Iterator<Task> iter = operator.staffList.get(user).taskList.iterator();
                    while (iter.hasNext()) {
                        task = iter.next();
                        if (task.getContent().equals(tsk)) {
                            iter.remove();
                            checkPassed = true;
                        }
                    }
                    if (!checkPassed) {
                        System.out.println("Задача не найдена!");
                    }
                }
                return true;
            }
        }
        class RemoveWorker implements Handler {
            @Override
            public boolean make(Staff operator) {
                String user = null;
                Scanner scan = new Scanner(System.in);
                boolean checkPassed = false;
                while (!checkPassed) {
                    System.out.println("Введите имя пользователя");
                    user = scan.nextLine();
                    if (!(checkPassed = operator.staffList.containsKey(user))) {
                        System.out.println("Пользователь не найден!");
                    }
                }
                operator.staffList.remove(user);
                return true;
            }
        }
        class ChangeStat implements Handler {
            @Override
            public boolean make(Staff operator) {
                String user = null, tsk;
                Scanner scan = new Scanner(System.in);
                boolean checkPassed = false;
                while (!checkPassed) {
                    System.out.println("Введите имя пользователя");
                    user = scan.nextLine();
                    if (!(checkPassed = operator.staffList.containsKey(user))) {
                        System.out.println("Пользователь не найден!");
                    }
                }
                checkPassed = false;
                Task task = null;
                while (!checkPassed) {
                    System.out.println("Введите задачу");
                    tsk = scan.nextLine();
                    Iterator<Task> iter = operator.staffList.get(user).taskList.iterator();
                    while (iter.hasNext()) {
                        task = iter.next();
                        if (task.getContent().equals(tsk)) {
                            iter.remove();
                            checkPassed = true;
                        }
                    }
                    if (!checkPassed) {
                        System.out.println("Задача не найдена!");
                    }
                }
                checkPassed = false;
                while (!checkPassed) {
                    System.out.println("Введите статус");
                    try {
                        task.setStatus(TaskStatus.valueOf(scan.nextLine()));
                        System.out.println("Успешно");
                        checkPassed = true;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Некорректный идентификатор статуса!");
                    }
                }
                return true;
            }
        }
        class Close implements Handler {
            @Override
            public boolean make(Staff operator) {
                System.exit(0);
                return true;
            }
        }
        class Exit implements Handler {
            @Override
            public boolean make(Staff operator) {
                return false;
            }
        }
        class ComList implements Handler {
            @Override
            public boolean make(Staff operator) {
                for (CommandStrings com : operator.accessTable.get(operator.access)) {
                    System.out.println(com);
                }
                return true;
            }
        }
        class ShowNew implements Handler {
            @Override
            public boolean make(Staff operator) {
                for (Task tsk : operator.taskList) {
                    if (tsk.getStatus().equals(NEW)) {
                        System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate() + " Complete " + tsk.getEndDate());
//                    System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate().format( DateTimeFormatter.ofPattern ("dd'.'MM'.'yyyy"))
//                                                        + " Complete " + tsk.getEndDate().format( DateTimeFormatter. ofPattern ("dd'.'MM'.'yyyy"));
                    }
                }
                return true;
            }
        }
        class ShowDone implements Handler {
            @Override
            public boolean make(Staff operator) {
                for (Task tsk : operator.taskList) {
                    if (tsk.getStatus().equals(DONE)) {
                        System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate() + " Complete " + tsk.getEndDate());
//                    System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate().format( DateTimeFormatter.ofPattern ("dd'.'MM'.'yyyy"))
//                                                        + " Complete " + tsk.getEndDate().format( DateTimeFormatter. ofPattern ("dd'.'MM'.'yyyy"));
                    }
                }
                return true;
            }

        }
        class InWork implements Handler {
            @Override
            public boolean make(Staff operator) {
                for (Task tsk : operator.taskList) {
                    if (tsk.getStatus().equals(IN_WORK)) {
                        System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate() + " Complete " + tsk.getEndDate());
//                    System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate().format( DateTimeFormatter.ofPattern ("dd'.'MM'.'yyyy"))
//                                                        + " Complete " + tsk.getEndDate().format( DateTimeFormatter. ofPattern ("dd'.'MM'.'yyyy"));
                    }
                }
                return true;
            }
        }
        class Checked implements Handler {
            @Override
            public boolean make(Staff operator) {
                for (Task tsk : operator.taskList) {
                    if (tsk.getStatus().equals(CHECKED)) {
                        System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate() + " Complete " + tsk.getEndDate());
//                    System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate().format( DateTimeFormatter.ofPattern ("dd'.'MM'.'yyyy"))
//                                                        + " Complete " + tsk.getEndDate().format( DateTimeFormatter. ofPattern ("dd'.'MM'.'yyyy"));
                    }
                }
                return true;
            }
        }
        class Take implements Handler {
            @Override
            public boolean make(Staff operator) {
                Scanner scaner = new Scanner(System.in);
                System.out.println("Введите задачу");
                String str = scaner.nextLine();
                for (Task tsk : operator.taskList) {
                    if (tsk.getContent().equals(str)) {
                        tsk.setStatus(IN_WORK);
                        System.out.println("Статус: в работе");
                    }
                }
                return true;
            }

        }
        class Complete implements Handler {
            @Override
            public boolean make(Staff operator) {
                Scanner scaner = new Scanner(System.in);
                System.out.println("Введите задачу");
                String str = scaner.nextLine();
                for (Task tsk : operator.taskList) {
                    if (tsk.getContent().equals(str)) {
                        tsk.setStatus(DONE);
                        System.out.println("completed");
                    }
                }
                return true;
            }
        }
        class IllegalCommand implements Handler{
            @Override
            public boolean make(Staff operator) {
                System.out.println("Команда не существует");
                return true;
            }
        }

        switch (command) {
            case MARK_AS_DONE:
                return new Complete();
            case SHOW_COMMANDS:
                return new ComList();
            case SHOW_NEW:
                return new ShowNew();
            case SHOW_DONE:
                return new ShowDone();
            case SHOW_CHECKED:
                return new Checked();
            case SHOW_IN_WORK:
                return new InWork();
            case ADD_WORKER:
                return new CreateWorker();
            case REMOVE_WORKER:
                return new RemoveWorker();
            case SHOW_ALL_TASKS:
                return new AllTasks();
            case CREATE_TASK:
                return new CreateTask();
            case DELETE_TASK:
                return new DeleteTask();
            case CHANGE_STATUS:
                return new ChangeStat();
            case TAKE_TASK:
                return new Take();
            case CLOSE:
                return new Close();
            case EXIT:
                return new Exit();
            default:
                return new IllegalCommand();
        }
    }
}

