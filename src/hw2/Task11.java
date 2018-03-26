package hw2;
//Требуется все числа, которые встречаются в строке, поместить в отдельный целочисленный
// ужасно тупая реализация, но ничего другого не осилил, увы :-(, на свежую голову вернусь

import java.util.Arrays;
import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        String str1;
        String symb;
        int arr_sz = 0;
//        char tmp_symb;
        System.out.println("Введите строку");
        Scanner keyb = new Scanner(System.in);
        str1 = keyb.nextLine();
        //вычисляем размер массива чисел
        for (int i=0; i<str1.length(); i++){
            if (str1.charAt(i) >= '0' && str1.charAt(i) <= '9') {
                for (; i<str1.length(); i++){
                    if (str1.charAt(i) >= '0' && str1.charAt(i) <= '9') {
                        if (i == str1.length() - 1) {
                            arr_sz += 1;
                        }
                    }
                    else {
                        i-=1;
                        arr_sz += 1;
                        break;
                    }
                }
            }
        }
        //наполняем массив
        int [] nums_arr = new int[arr_sz];
        int nums_arr_indx = 0;
        for (int i=0; i<str1.length(); i++){
            if (str1.charAt(i) >= '0' && str1.charAt(i) <= '9'){
                StringBuffer str_buf = new StringBuffer();
                for (; i<str1.length(); i++){
                    if (str1.charAt(i) >= '0' && str1.charAt(i) <= '9'){
                        str_buf.append(str1.charAt(i));
                        if (i == str1.length() - 1) {
                            nums_arr [nums_arr_indx] = Integer.valueOf(str_buf.toString());
                        }
                    }
                    else {
                        i-=1;
                        nums_arr [nums_arr_indx] = Integer.valueOf(str_buf.toString());
                        nums_arr_indx += 1;
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(nums_arr));
    }
}
