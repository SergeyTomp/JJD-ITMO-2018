//package hw8.taskLister;
//
//import java.util.*;
//import static hw8.taskLister.CommandLines.*;
//
//
//public class Admin extends Staff {
//
////    Map <String,Staff> staffList;
////    private String user,tsk;
////    class AllTasks implements Handler{
////        @Override
////        public void make(){
////            for (Map.Entry entry : commands.entrySet()){
////                System.out.println(entry.getKey());
////            }
////            for (Map.Entry entry : staffList.entrySet()){
////                System.out.println(entry.getKey());
////                for (Task tsk :staffList.get(entry.getKey()).taskList){
////                    System.out.println(tsk.getContent() + " " + tsk.getStartDate() + " " + tsk.getEndDate() + " " + tsk.getStatus());
////                }
////            }
////        }
////    }
////    class CreateWorker implements Handler{
////        @Override
////        public void make(){
////            String pass, access;
////            Scanner scan = new Scanner(System.in);
////            System.out.println("Введите имя пользователя");
////            user = scan.nextLine();
////            System.out.println("Введите пароль");
////            pass = scan.nextLine();
////            System.out.println("Введите доступ");
////            access = scan.nextLine();
////            staffList.put(name,new Worker(name,pass,access));
////        }
////    }
////    class CreateTask implements Handler{
////        @Override
////        public void make (){
////            String start, end;
////            Scanner scan = new Scanner(System.in);
////            System.out.println("Введите имя пользователя");
////            user = scan.nextLine();
////            System.out.println("Введите задачу");
////            tsk = scan.nextLine();
////            System.out.println("Введите дату начала");
////            start = scan.nextLine();
////            System.out.println("Введите дату окончания");
////            end = scan.nextLine();
////            staffList.get(name).taskList.add(new Task (tsk, start, end, NEW));
////        }
////    }
////    class DeleteTask implements Handler{
////        @Override
////        public void make (){
////            Scanner scan = new Scanner(System.in);
////            System.out.println("Введите имя пользователя");
////            user = scan.nextLine();
////            System.out.println("Введите задачу");
////            tsk = scan.nextLine();
////            Iterator <Task> iter =  staffList.get(name).taskList.iterator();
////            while (iter.hasNext()){
////                if(iter.next().getContent().equals(tsk)){
////                    iter.remove();
////                }
////            }
////        }
////    }
////    class RemoveWorker implements Handler{
////        @Override
////        public void make (){
////            Scanner scan = new Scanner(System.in);
////            System.out.println("Введите имя пользователя");
////            user = scan.nextLine();
////            staffList.remove(name);
////        }
////    }
////    class ChangeStat implements Handler{
////        @Override
////        public void make (){
////            String stat;
////            Scanner scan = new Scanner(System.in);
////            System.out.println("Введите имя пользователя");
////            user = scan.nextLine();
////            System.out.println("Введите задачу");
////            tsk = scan.nextLine();
////            System.out.println("Введите статус");
////            stat = scan.nextLine();
////            Iterator <Task> iter =  staffList.get(name).taskList.iterator();
////            Task str;
////            while (iter.hasNext()){
////                str = iter.next();
////                if(str.getContent().equals(tsk)){
////                   str.setStatus(stat);
////                }
////            }
////        }
////    }
//    Admin (String name, String pass, String access, Map staffList){
//        super.name = name;
//        super.pass = pass;
//        super.access = access;
//        super.staffList = staffList;
//        commands.put(SHOW_TASKS, new AllTasks());
//        commands.put(ADD_WORKER, new CreateWorker());
//        commands.put(CREATE_TASK, new CreateTask());
//        commands.put(DELETE_TASK, new DeleteTask());
//        commands.put(REMOVE_WORKER, new RemoveWorker());
//        commands.put(CHANGE_STAT, new ChangeStat());
//    }
//}
