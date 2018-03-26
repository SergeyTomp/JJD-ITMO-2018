package hw2;

import java.util.Arrays;
import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        String str1;
        String symb;
        int arr_sz = 0;
        char tmp_symb;
        System.out.println("Введите строку");
        Scanner keyb = new Scanner(System.in);
        str1 = keyb.nextLine();
        //вычисляем размер массива чисел
        for (int i=0; i<str1.length(); i++){
            tmp_symb = str1.charAt(i);
            if (tmp_symb >= '0' && tmp_symb <= '9') {
                for (i+=1; i<str1.length(); i++){
                    tmp_symb = str1.charAt(i);
                    if (tmp_symb >= '0' && tmp_symb <= '9'){;}
                    else {
                        i-=1;
                        arr_sz += 1;
                        break;
                    }
                }
            }
        }
        System.out.println(arr_sz);
        //наполняем массив
        int [] nums_arr = new int[arr_sz];
        int nums_arr_indx = 0;
        for (int i=0; i<str1.length(); i++){
            tmp_symb = str1.charAt(i);
            if (tmp_symb >= '0' && tmp_symb <= '9'){
                StringBuffer str_buf = new StringBuffer();
                str_buf.append(tmp_symb);
                for (i+=1; i<str1.length(); i++){
                    tmp_symb = str1.charAt(i);
                    if (tmp_symb >= '0' && tmp_symb <= '9'){
                        str_buf.append(tmp_symb);
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
