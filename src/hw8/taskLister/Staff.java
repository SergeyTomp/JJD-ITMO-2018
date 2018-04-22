package hw8.taskLister;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Staff {

    protected String name;
    protected String pass;
    protected String access;
    protected Map<CommandStrings, Handler> commands;
    protected ArrayList<Task> taskList;
    Map <String,Staff> staffList;

    class AllTasks implements Handler{
        @Override
        public boolean make(){
             for (Map.Entry entry : staffList.entrySet()){
                System.out.println(entry.getKey());
                for (Task tsk :staffList.get(entry.getKey()).taskList){
                    System.out.println(tsk.getContent() + " " + tsk.getStartDate() + " " + tsk.getEndDate() + " " + tsk.getStatus());
                }
            }
            return true;
        }
    }
    class CreateWorker implements Handler{
        @Override
        public boolean make(){
            String pass, access = null, user = null;
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
                access = scan.nextLine();
                checkPassed = Validator.accessCheck(access);
            }
            staffList.put(user, new UserFactory(user,pass,access,staffList));
            return true;
        }
    }
    class CreateTask implements Handler{
        @Override
        public boolean make (){
            String user = null, tsk, start = null, end = null;
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
            while (!checkPassed){
                System.out.println("Введите дату начала");
                start = scan.nextLine();
                checkPassed = Validator.dateCheck(start);
            }
            checkPassed = false;
            while (!checkPassed){
                System.out.println("Введите дату окончания");
                end = scan.nextLine();
                checkPassed = Validator.dateCheck(end);
            }
            staffList.get(user).taskList.add(new Task (tsk, start, end, CommandStrings.NEW.s));
            return true;
        }
    }
    class DeleteTask implements Handler{
        @Override
        public boolean make (){
            String user, tsk;
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите имя пользователя");
            user = scan.nextLine();
            System.out.println("Введите задачу");
            tsk = scan.nextLine();
            Iterator<Task> iter =  staffList.get(user).taskList.iterator();
            while (iter.hasNext()){
                if(iter.next().getContent().equals(tsk)){
                    iter.remove();
                }
            }
            return true;
        }
    }
    class RemoveWorker implements Handler{
        @Override
        public boolean make (){
            String user;
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите имя пользователя");
            user = scan.nextLine();
            staffList.remove(user);
            return true;
        }
    }
    class ChangeStat implements Handler{
        @Override
        public boolean make (){
            String user, tsk, stat;
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите имя пользователя");
            user = scan.nextLine();
            System.out.println("Введите задачу");
            tsk = scan.nextLine();
            System.out.println("Введите статус");
            stat = scan.nextLine();
            Iterator <Task> iter =  staffList.get(user).taskList.iterator();
            Task str;
            while (iter.hasNext()){
                str = iter.next();
                if(str.getContent().equals(tsk)){
                    str.setStatus(stat);
                }
            }
            return true;
        }
    }
    class Close implements Handler{
        @Override
        public boolean make (){
            System.exit(0);
            return true;
        }
    }
    class Exit implements Handler{
        @Override
        public boolean make(){
            return false;
        }
    }
    class ComList implements Handler{
        @Override
        public boolean make(){
            for (Map.Entry entry : commands.entrySet()){
                System.out.println(entry.getKey());
            }
            return true;
        }
    }
    class ShowNew implements Handler{
        @Override
        public boolean make () {
            for (Task tsk : taskList){
                if(tsk.getStatus().equals(CommandStrings.NEW.s)){
                    System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate() + " Complete " + tsk.getEndDate());
                }
            }
            return true;
        }
    }
    class ShowDone implements Handler{
        @Override
        public boolean make (){
            for (Task tsk : taskList){
                if(tsk.getStatus().equals(CommandStrings.DONE.s)){
                    System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate() + " Complete " + tsk.getEndDate());
                }
            }
            return true;
        }

    }
    class InWork implements Handler{
        @Override
        public boolean make (){
            for (Task tsk : taskList){
                if(tsk.getStatus().equals(CommandStrings.IN_WORK.s)){
                    System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate() + " Complete " + tsk.getEndDate());
                }
            }
            return true;
        }
    }
    class Checked implements Handler{
        @Override
        public boolean make (){
            for (Task tsk : taskList){
                if(tsk.getStatus().equals(CommandStrings.SHOW_CHECKED.s)){
                    System.out.println(tsk.getContent() + " Begin " + tsk.getStartDate() + " Complete " + tsk.getEndDate());
                }
            }
            return true;
        }
    }
    class Take implements Handler{
        @Override
        public boolean make (){
            Scanner scaner = new Scanner(System.in);
            System.out.println("Введите задачу");
            String str = scaner.nextLine();
            for (Task tsk : taskList){
                if(tsk.getContent().equals(str)){
                    tsk.setStatus(CommandStrings.IN_WORK.s);
                    System.out.println("Статус: в работе");
                }
            }
            return true;
        }

    }
    class Complete implements Handler{
        @Override
        public boolean make (){
            Scanner scaner = new Scanner(System.in);
            System.out.println("Введите задачу");
            String str = scaner.nextLine();
            for (Task tsk : taskList){
                if(tsk.getContent().equals(str)){
                    tsk.setStatus(CommandStrings.DONE.s);
                    System.out.println("completed");
                }
            }
            return true;
        }
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
