package taskManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import static taskManager.TaskStatus.*;


public class CommandFactory {

    public static Handler getHandler(CommandStrings command) {

        class AllTasks implements Handler {
            @Override
            public int make(Staff operator) {
                for (Map.Entry entry : operator.staffList.entrySet()) {
                    if (!operator.staffList.get(entry.getKey()).taskList.isEmpty()){
                        System.out.println(entry.getKey());
                        for (Task tsk : operator.staffList.get(entry.getKey()).taskList) {
//                        System.out.println(tsk.getContent() + " " + tsk.getStartDate() + " " + tsk.getEndDate() + " " + tsk.getStatus());
                            System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate().format( DateTimeFormatter.ofPattern ("dd'.'MM'.'yyyy"))
                                    + " Complete " + tsk.getEndDate().format( DateTimeFormatter. ofPattern ("dd'.'MM'.'yyyy")));
                        }
                    }
                }
                return 1;
            }
        }
        class CreateWorker implements Handler {
            @Override
            public int make(Staff operator) {
                String pass = null, user = null;
                AccessLevel access = null;
                boolean checkPassed = false;
                Scanner scan = new Scanner(System.in);
                while (!checkPassed) {
                    System.out.println("Введите имя пользователя (разрешены только буквы)");
//                    user = scan.nextLine();
                    checkPassed = Validator.nameCheck(user = scan.nextLine());
                }
                checkPassed = false;
                while (!checkPassed){
                    System.out.println("Введите пароль (не менее 3-х символов)");
                    checkPassed = Validator.passCheck(pass = scan.nextLine());
                }
                checkPassed = false;
                while (!checkPassed) {
                    System.out.println("Введите доступ");
                    System.out.println ("ADMIN, SUPER, MIDDLE, JUNIOR, COMBINED");
                    try {
                        access = AccessLevel.valueOf(pass = scan.nextLine());
                        checkPassed = true;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Некорректный идентификатор доступа!");
                        checkPassed = false;
                    }
                }
                operator.staffList.put(user, new Staff(user, pass, access, operator.staffList, operator.accessTable));
                return 1;
            }
        }
        class CreateTask implements Handler {
            @Override
            public int make(Staff operator) {
//                String user = null, tsk, start = null, end = null;
            String user = null, tsk;
            LocalDate start = null, end = null;
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
                while (!checkPassed) {
                    System.out.println("Введите дату начала (dd.mm.yyyy)");
//                    start = scan.nextLine();
//                    checkPassed = Validator.dateCheck(start);
                try {
                        start = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern ("dd'.'MM'.'yyyy"));
                        checkPassed = Validator.dateCheck(start);
                    }
                catch (DateTimeParseException e){
                        System.out.println("Некорректный формат даты!");
                    }
                }

                checkPassed = false;
                while (!checkPassed) {
                    System.out.println("Введите дату окончания (dd.mm.yyyy");
//                    end = scan.nextLine();
//                    checkPassed = Validator.dateCheck(end);
                try {
                    end = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern ("dd'.'MM'.'yyyy"));
                    checkPassed = Validator.dateCheck(start, end);
                }
                catch (DateTimeParseException e){
                    System.out.println("Некорректный формат даты!");
                }
                }
                operator.staffList.get(user).taskList.add(new Task(tsk, start, end, NEW));
                return 1;
            }
        }
        class DeleteTask implements Handler {
            @Override
            public int make(Staff operator) {
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
                return 1;
            }
        }
        class RemoveWorker implements Handler {
            @Override
            public int make(Staff operator) {
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
                return 1;
            }
        }
        class ChangeStat implements Handler {
            @Override
            public int make(Staff operator) {
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
                return 1;
            }
        }
        class Close implements Handler {
            @Override
            public int make(Staff operator) {

//                System.exit(0);
                return -1;
            }
        }
        class Exit implements Handler {
            @Override
            public int make(Staff operator) {
                return 0;
            }
        }
        class ComList implements Handler {
            @Override
            public int make(Staff operator) {
                for (CommandStrings com : operator.accessTable.get(operator.access)) {
                    System.out.println(com);
                }
                return 1;
            }
        }
        class ShowNew implements Handler {
            @Override
            public int make(Staff operator) {
                for (Task tsk : operator.taskList) {
                    if (tsk.getStatus().equals(NEW)) {
//                        System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate() + " Complete " + tsk.getEndDate());
                    System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate().format( DateTimeFormatter.ofPattern ("dd'.'MM'.'yyyy"))
                                                        + " Complete " + tsk.getEndDate().format( DateTimeFormatter. ofPattern ("dd'.'MM'.'yyyy")));
                    }
                }
                return 1;
            }
        }
        class ShowDone implements Handler {
            @Override
            public int make(Staff operator) {
                for (Task tsk : operator.taskList) {
                    if (tsk.getStatus().equals(DONE)) {
//                        System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate() + " Complete " + tsk.getEndDate());
                    System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate().format( DateTimeFormatter.ofPattern ("dd'.'MM'.'yyyy"))
                                                        + " Complete " + tsk.getEndDate().format( DateTimeFormatter. ofPattern ("dd'.'MM'.'yyyy")));
                    }
                }
                return 1;
            }

        }
        class InWork implements Handler {
            @Override
            public int make(Staff operator) {
                for (Task tsk : operator.taskList) {
                    if (tsk.getStatus().equals(IN_WORK)) {
//                        System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate() + " Complete " + tsk.getEndDate());
                    System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate().format( DateTimeFormatter.ofPattern ("dd'.'MM'.'yyyy"))
                                                        + " Complete " + tsk.getEndDate().format( DateTimeFormatter. ofPattern ("dd'.'MM'.'yyyy")));
                    }
                }
                return 1;
            }
        }
        class Checked implements Handler {
            @Override
            public int make(Staff operator) {
                for (Task tsk : operator.taskList) {
                    if (tsk.getStatus().equals(CHECKED)) {
//                        System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate() + " Complete " + tsk.getEndDate());
                    System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate().format( DateTimeFormatter.ofPattern ("dd'.'MM'.'yyyy"))
                                                        + " Complete " + tsk.getEndDate().format( DateTimeFormatter. ofPattern ("dd'.'MM'.'yyyy")));
                    }
                }
                return 1;
            }
        }
        class Take implements Handler {
            @Override
            public int make(Staff operator) {
                Scanner scaner = new Scanner(System.in);
                System.out.println("Введите задачу");
                String str = scaner.nextLine();
                for (Task tsk : operator.taskList) {
                    if (tsk.getContent().equals(str)) {
                        tsk.setStatus(IN_WORK);
                        System.out.println("Статус: в работе");
                    }
                }
                return 1;
            }

        }
        class Complete implements Handler {
            @Override
            public int make(Staff operator) {
                Scanner scaner = new Scanner(System.in);
                System.out.println("Введите задачу");
                String str = scaner.nextLine();
                for (Task tsk : operator.taskList) {
                    if (tsk.getContent().equals(str)) {
                        tsk.setStatus(DONE);
                        System.out.println("completed");
                    }
                }
                return 1;
            }
        }
        class IllegalCommand implements Handler{
            @Override
            public int make(Staff operator) {
                System.out.println("Команда не существует");
                return 1;
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

