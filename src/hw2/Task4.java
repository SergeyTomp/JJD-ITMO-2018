package hw2;
//Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5]
import java.util.Arrays;
import java.util.Random;

public class Task4 {
    public static void main(String[] args){
        int arr_sz = 5;
        int [] rnd_num_1 = new int[arr_sz];
        int [] rnd_num_2 = new int[arr_sz];
        Random rand_num = new Random();
        int sum_1 = 0;
        int sum_2 = 0;
        for (int i=0; i<arr_sz; i++){
            rnd_num_1[i] = rand_num.nextInt(6);
            rnd_num_2[i] = rand_num.nextInt(6);
            sum_1 = sum_1 + rnd_num_1[i];
            sum_2 = sum_2 + rnd_num_2[i];
        }System.out.println("Массив №1 " + Arrays.toString(rnd_num_1));
        System.out.println("Массив №1 " + Arrays.toString(rnd_num_1));
        System.out.println("Массив №2 " + Arrays.toString(rnd_num_2));
        System.out.print("Средее арифметическое по массиву №1 ");
        //среднее арифметическое при равных размерах массивов можно не высчитывать, достаточно сравнения сумм
        if (sum_1 == sum_2) {
            System.out.println("и rnd_num_2 одинаковое.");
        }
        else { //так меньше литераловв памяти будет

            if (sum_1 > sum_2){
                System.out.print("больше, ");
            }
            else {
                System.out.print("меньше, ");
            }
            System.out.println("чем по массиву №2.");
        }
    }
}