package hw2;

import java.util.Arrays;
import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        String str;
        String symb;
        int arr_sz = 0;
        System.out.println("Введите строку");
        Scanner keyb = new Scanner(System.in);
        str = keyb.nextLine();
        String [] cleanRubbish = str.replaceAll("\\D+", " ").trim().split(" ");
        int [] result = new int[cleanRubbish.length];
        for (int i=0; i<result.length; i++) {
            result[i] = Integer.parseInt(cleanRubbish[i]);
        }
        System.out.println(Arrays.toString(result));
    }
}