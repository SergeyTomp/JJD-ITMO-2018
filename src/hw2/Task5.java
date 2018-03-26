package hw2;
//Создайте массив из 4 случайных целых чисел из отрезка [10;99].....
import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        int arr_sz = 4;
        int rnd_min = 10;
        int rnd_max = 99;
        int[] rnd_num = new int[arr_sz];
        boolean go_up = true;
        for (int i = 0; i < arr_sz; i++) {
            rnd_num[i] = (int) (Math.random() * (rnd_max - rnd_min + 1) + rnd_min);
            if (i>0 && go_up == true) {
                if (rnd_num[i] < rnd_num[i - 1]) {
                    go_up = false;
                }
            }
        }
        System.out.println("Массив " + Arrays.toString(rnd_num) + (!go_up ? " не " : "") + "является возрастающей последовательностью");
    }
}
