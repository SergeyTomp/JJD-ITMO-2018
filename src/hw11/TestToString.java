package hw11;

import static hw11.reflectToString.objToString;

public class TestToString {
    public static void main(String[] args){
        try{
            System.out.println(objToString(new TstClass(1, "one")));
        }
        catch (IllegalAccessException e){
            System.out.println("Access denied!");
        }
    }
}
