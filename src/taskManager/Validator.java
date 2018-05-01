package taskManager;

import java.text.NumberFormat;
import java.text.ParsePosition;

public class Validator {

    public static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }
    static boolean nameCheck (String name){
       String clean = name.replaceAll("[\\p{Punct}\\d]+","");
       if(!(name.length() > 0 && name.length() == clean.length())){
           System.out.println("Некорректное имя пользователя");
           return false;
       }
       return true;
    }
//    static boolean accessCheck (AccessLevel access){
//        try {
//            AccessLevel.valueOf(access);
//        }
//        catch (IllegalArgumentException e) {
//            System.out.println("Некорректный идентификатор доступа!");
//            return false;
//        }
//        return true;
//    }
    static boolean dateCheck(String date){
        String[] splitted = date.trim().split("\\.");
        if (splitted.length != 3
            || !isNumeric(splitted[0])
            || !isNumeric(splitted[1])
            || !isNumeric(splitted[2])
            || Integer.parseInt(splitted [0]) <  1
            || Integer.parseInt(splitted [0]) > 31
            || Integer.parseInt(splitted [1]) <  1
            || Integer.parseInt(splitted [1]) > 12
            || Integer.parseInt(splitted [2]) <  1970
            || Integer.parseInt(splitted [2]) > 2100) {
            System.out.println("Некорректный формат даты!");
            return false;
        }
        return true;
    }
//    static boolean statusCheck(String status){
//        try {
//            CommandStrings.valueOf(status);
//        }
//        catch (IllegalArgumentException e) {
//            System.out.println("Некорректный идентификатор статуса!");
//            return false;
//        }
//        return true;
//    }
}
