package hw2;
//Требуется удалить из строки повторяющиеся символы и все пробелы
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.lang.StringBuffer;

public class Task10 {
    public static void main(String[] args) {
        String str;
        String symb;
        System.out.println("Введите строку");
        Scanner keyb = new Scanner(System.in);
        str = keyb.nextLine();
        str = str.replace(" ", "");

        //дальше решаем двумя способами
        // Способ №1: чуть-чуть из Java, остальное как обычно
        StringBuffer str_buf = new StringBuffer(str);
        for (int i = 0; i < str_buf.length(); i++) {
            symb = str_buf.substring(i, i + 1);
            for (int j = i + 1; j < str_buf.length(); j++) {
                int indx = str_buf.indexOf(symb, j);
                if (indx >= 0) {
                    str_buf.deleteCharAt(indx);
                    j = indx - 1;
                }
            }
        }
        System.out.println(str_buf);

        // Способ №2: целиком на Java
        // свойство LinkedHashSet - можно добавить только неповторяющийся элемент, при этом сохранаятся порядок добавления
        LinkedHashSet<Character> repeatIgnore = new LinkedHashSet<>();
        str_buf = new StringBuffer();
        char[] strToArr = str.toCharArray();
        for (char tmp : strToArr) {
            //из объекта LinkedHashSet строка выводится криво, типа как Arrays.toString, поэтому клеим строку отдельно в stringBuffer
            // если LinkedHashSet принимает символ, добавляем его же в stringBuffer, если нет, это повтор, в корзину его
            if (repeatIgnore.add(tmp)) {
                str_buf.append(tmp);
            }
        }
        System.out.println(str_buf);
    }
}

