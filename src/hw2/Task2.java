package hw2;
//Создайте массив из всех нечётных чисел от 1 до 99 .......
public class Task2 {
    public static void main(String[] args) {
        int arr_sz = 0;
        int i = 1;
        for (; i<=99; i+=2) {
            arr_sz++;
        }
        int[] odd_num = new int[arr_sz];
        for (i = 0; i < arr_sz; i++) {
            odd_num[i] = (i * 2) + 1;
            System.out.print(odd_num[i] + " ");
        }
        System.out.println();
        for (i = (arr_sz - 1); i >= 0; i--) {
            System.out.print(odd_num[i] + " ");
        }
    }
}
