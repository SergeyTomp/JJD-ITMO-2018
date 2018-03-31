package hw2;

import java.util.Random;

//Создайте массив из 15 случайных целых чисел из отрезка [0;9]......
public class Task3 {
    public static void main(String[] args){
        int [] rnd_num = new int[15];
        Random rand_num = new Random();
        int cntr=0;
        for (int i=0; i<rnd_num.length; i++){
            rnd_num[i] = rand_num.nextInt(9);
            System.out.print(rnd_num[i] + " ");
            if (rnd_num[i]%2 == 0){cntr++;}//считаем нуль чётным
        }
        System.out.println("\n" + cntr);
    }
}
