package hw2;
//Найти в строке указанную подстроку и заменить ее на новую.
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        String str1;
        String str2;
        String str3;
        System.out.println("Введите строку");
        Scanner keyb = new Scanner(System.in);
        str1 = keyb.nextLine();
        System.out.println("Что нужно заменить?");
        str2 = keyb.nextLine();
        System.out.println("На что будем менять?");
        str3 = keyb.nextLine();
        str1 = str1.replace(str2, str3);
        System.out.println(str1);
    }
}
