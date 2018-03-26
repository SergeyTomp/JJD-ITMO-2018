package hw2;
//Пользователь должен указать с клавиатуры чётное положительное число, а программа.....
import java.util.Arrays;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        int arr_sz, leftSum = 0, rghtSum = 0;
        int rnd_min = -5;
        int rnd_max = 5;
        Scanner keyb = new Scanner(System.in);
        System.out.println("Введите чётное положительное и не равное нулю число - размер массива.");
        if (keyb.hasNextInt()){
            do {
               arr_sz = keyb.nextInt();
               if (arr_sz%2 != 0 || arr_sz < 2){
                    System.out.println("Вы ошиблись, введите чётное положительное и не равное нулю число!");
               }
            }
            while (arr_sz%2 != 0 || arr_sz < 2);

            int [] arr = new int[arr_sz];
            for (int i = 0; i < arr_sz; i++){
                arr[i] = (int) (Math.random() * (rnd_max - rnd_min + 1) + rnd_min);
                if (i <= (arr_sz/2 - 1)){
                    leftSum += Math.abs(arr[i]);
                }
                else {
                    rghtSum += Math.abs(arr[i]);
                }
            }
            System.out.println ("Массив " + Arrays.toString(arr));
            System.out.println("Сумма модулей членов левой части массива " + ((leftSum > rghtSum) ? " больше " : " меньше ") + "cуммы модулей членов левой части массива.");
        }
        else System.out.println("Введено не число!");
    }
}
