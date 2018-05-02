package taskManager;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.time.LocalDate;

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
    static boolean dateCheck(LocalDate date){
        if (date.isBefore(LocalDate.now())){
            System.out.println("Дата начала не может быть в прошлом");
            return false;
        }
        return true;
    }
    static boolean dateCheck(LocalDate begin, LocalDate end){
        if (end.isBefore(begin)){
            System.out.println("Дата окончания не может быть раньше даты начала");
            return false;
        }
        return true;
    }
    static boolean passCheck(String pass){
        if (pass.length() < 3){
            System.out.println("Пароль не может быть короче 3-х символов");
            return false;
        }
        return true;
    }

//    static boolean dateCheck(String date){
//        String[] splitted = date.trim().split("\\.");
//        if (splitted.length != 3
//            || !isNumeric(splitted[0])
//            || !isNumeric(splitted[1])
//            || !isNumeric(splitted[2])
//            || Integer.parseInt(splitted [0]) <  1
//            || Integer.parseInt(splitted [0]) > 31
//            || Integer.parseInt(splitted [1]) <  1
//            || Integer.parseInt(splitted [1]) > 12
//            || Integer.parseInt(splitted [2]) <  1970
//            || Integer.parseInt(splitted [2]) > 2100) {
//            System.out.println("Некорректный формат даты!");
//            return false;
//        }
//        return true;
//    }

}
