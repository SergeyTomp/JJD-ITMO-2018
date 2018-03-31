package hw2;

import java.util.Arrays;
import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        String str;
        System.out.println("Введите строку");
        Scanner keyb = new Scanner(System.in);
        str = keyb.nextLine();
        str = str.replaceAll("\\D+", " ");// заменяем все нецифровые символы на пробелы,
        str = str.trim();                                 // обрезаем пробелы по краям
        String [] cleanRubbish = str.split(" ");    // разрезаем результат по пробелам, получаем массив строк из чисел
        int [] result = new int[cleanRubbish.length];
        for (int i=0; i<result.length; i++) {
            result[i] = Integer.parseInt(cleanRubbish[i]);
        }
        System.out.println(Arrays.toString(result));
    }
}