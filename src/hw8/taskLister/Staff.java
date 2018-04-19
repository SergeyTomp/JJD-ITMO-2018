package hw8.taskLister;

import java.util.ArrayList;
import java.util.Map;

public class Staff {

    protected String name;
    protected String pass;
    protected String access;
    protected Map<String, Handler> commands;
    protected ArrayList<Task> taskList;

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
    class ComList implements Handler{
        @Override
        public void make(){
            for (Map.Entry entry : commands.entrySet()){
                System.out.println(entry.getKey());
            }
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
}
