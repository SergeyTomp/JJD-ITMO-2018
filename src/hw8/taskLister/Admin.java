package hw8.taskLister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import static hw8.taskLister.CommandLines.*;


public class Admin extends Staff {

    Map <String,Staff> staffList;
    class AllTasks implements Handler{
        @Override
        public void make(){
            for (Map.Entry entry : commands.entrySet()){
                System.out.println(entry.getKey());
            }
            for (Map.Entry entry : staffList.entrySet()){
                System.out.println(entry.getKey());
                for (Task tsk :staffList.get(entry.getKey()).taskList){
                    System.out.println(tsk.getContent() + " " + tsk.getStartDate() + " " + tsk.getEndDate() + " " + tsk.getStatus());
                }
            }
        }
    }
    class CreateWorker implements Handler{
        @Override
        public void make(){}
        public void make(String name, String pass, String access){
            staffList.put(name,new Worker(name,pass,access));
        }
    }
    class CreateTask implements Handler{
        @Override
        public void make (){}
        public void make (String name, String tsk, String start, String end){
            staffList.get(name).taskList.add(new Task (tsk, start, end, NEW));
        }
    }
    class DeleteTask implements Handler{
        @Override
        public void make (){}
        public boolean make (String name, String tsk){
            Iterator <Task> iter =  staffList.get(name).taskList.iterator();
            while (iter.hasNext()){
                if(iter.next().getContent().equals(tsk)){
                    iter.remove();
                    return true;
                }
            }
            return false;
        }
    }
    class RemoveWorker implements Handler{
        @Override
        public void make (){}
        public boolean make (String name, String tsk){
            return (staffList.remove(name) != null);
        }
    }
    class ChangeStat implements Handler{
        @Override
        public void make(){}
        public boolean make (String name, String tsk, String stat){
            Iterator <Task> iter =  staffList.get(name).taskList.iterator();
            Task str;
            while (iter.hasNext()){
                str = iter.next();
                if(str.getContent().equals(tsk)){
                   str.setStatus(stat);
                    return true;
                }
            }
            return false;
        }
    }

    Admin (String name, String pass, String access, Map staffList){
        super.taskList = new ArrayList<>();
        super.commands = new HashMap<>();
        super.name = name;
        super.pass = pass;
        super.access = access;
        this.staffList = staffList;
        commands.put(SHOW_TASKS, new AllTasks());
        commands.put(ADD_WORKER, new CreateWorker());
        commands.put(CREATE_TASK, new CreateTask());
        commands.put(DELETE_TASK, new DeleteTask());
        commands.put(REMOVE_WORKER, new RemoveWorker());
        commands.put(CHANGE_STAT, new ChangeStat());
    }
}
