package hw8.taskLister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static hw8.taskLister.CommandLines.*;

public class Worker extends Staff {

    private Map<String, Handler> commands;
    private ArrayList <Task> taskList;

    class ComList implements Handler{
        @Override
        public void make(){
            for (Map.Entry entry : commands.entrySet()){
                System.out.println(entry.getKey());
            }
        }
    }
    class ShowNew implements Handler{
        @Override
        public void make () {
            for (Task tsk : taskList){
                if(tsk.getStatus().equals(NEW)){
                    System.out.println(tsk.getStatus());
                }
            }
        }
    }
    class ShowDone implements Handler{
        @Override
        public void make (){
            for (Task tsk : taskList){
                if(tsk.getStatus().equals(DONE)){
                    System.out.println(tsk.getStatus());
                }
            }
        }

    }
    class InWork implements Handler{
        @Override
        public void make (){
            for (Task tsk : taskList){
                if(tsk.getStatus().equals(SHOW_IN_WORK)){
                    System.out.println(tsk.getStatus());
                }
            }
        }
    }
    class Checked implements Handler{
        @Override
        public void make (){
            for (Task tsk : taskList){
                if(tsk.getStatus().equals(SHOW_CHECKED)){
                    System.out.println(tsk.getStatus());
                }
            }
        }
    }
    class Take implements Handler{
        @Override
        public void make (){}
        public void make (String str){
            for (Task tsk : taskList){
                if(tsk.getContent().equals(str)){
                    tsk.setStatus(IN_WORK);
                    System.out.println("in work now");
                }
            }
        }

    }
    class Complete implements Handler{
        @Override
        public void make (){}
        public void make (String str){
            for (Task tsk : taskList){
                if(tsk.getContent().equals(str)){
                    tsk.setStatus(DONE);
                    System.out.println("completed");
                }
            }
        }
    }
    class Close implements Handler{
        @Override
        public void make (){
            System.exit(0);
        }
    }
    class Exit implements Handler{
        @Override
        public void make(){

        }
    }

    Worker (String name, String pass, String access){
        super.name = name;
        super.pass = pass;
        super.access = access;
        taskList = new ArrayList<>();
        commands = new HashMap<>();
        commands.put(COMMANDS,new ComList());
        commands.put(EXIT, new Exit());
        commands.put(CLOSE, new Close());
        commands.put(TAKE, new Take());
        commands.put(COMPLETE, new Complete());
        commands.put(SHOW_NEW, new ShowNew());
        commands.put(SHOW_IN_WORK, new InWork());
        commands.put(SHOW_CHECKED, new Checked());
        commands.put(SHOW_DONE, new ShowDone());
    }
    void addTask (Task tsk){
        taskList.add(tsk);
    }
}
