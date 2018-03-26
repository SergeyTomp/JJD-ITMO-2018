package hw2;
//Создать двумерный массив из 5 строк по 8 столбцов в каждой из случайных целых чисел из отрезка [-99;99]....
import java.util.Arrays;

public class Task7 {
    public static void main(String[] args) {
        int lines = 5, cols = 8;
        int rnd_min = -99;
        int rnd_max = 99;
        int arr_max = 0;
        int arr2d [][] = new int[lines][cols];
        for (int i=0; i<arr2d.length; i++){
            for (int j = 0; j<arr2d[i].length; j++){
                arr2d[i][j] = (int)(Math.random()*(rnd_max - rnd_min + 1) + rnd_min);
                if (i==0 && j==0){
                    arr_max = arr2d[i][j];
                }
                else {
                    if (arr2d[i][j] > arr_max){
                        arr_max = arr2d[i][j];
                    }
                }
            }
        // так нагляднее массив на экране
        System.out.println(Arrays.toString(arr2d[i]));
        }
    //просто в строку
    System.out.println(Arrays.deepToString(arr2d));
    System.out.println ("Максимальное значение массива равно " + arr_max);
    }
}
