package hw2;
//Требуется удалить из строки повторяющиеся символы и все пробелы
import java.util.Scanner;
import java.lang.StringBuffer;
public class Task10 {
    public static void main(String[] args) {
        String str1;
        String symb;
        System.out.println("Введите строку");
        Scanner keyb = new Scanner(System.in);
        str1 = keyb.nextLine();
        str1 = str1.replace(" ","");
        StringBuffer str_buf = new StringBuffer(str1);
        for (int i=0; i<str_buf.length(); i++){
            symb = str_buf.substring(i,i + 1);
            for (int j=i+1; j<str_buf.length(); j++){
                int indx = str_buf.indexOf(symb, j);
                if (indx >= 0){
                    str_buf.deleteCharAt(indx);
                    j = indx - 1;
                }
            }
        }
        System.out.println(str_buf);
    }
}

