package hw2;
//Создайте массив из всех чётных чисел от 2 до 20 ........
public class Task1 {
    public static void main(String[] args) {
        int arr_sz = 0;
        int i = 2;
        for (; i<=20; i+=2) {
            arr_sz++;
        }
        int[] even_num = new int[arr_sz];
        for (i = 0; i < arr_sz; i++) {
            even_num[i] = (i * 2) + 2;
            System.out.print(even_num[i] + " ");
        }
        System.out.println();
        for (i = 0; i < arr_sz; i++) {
            System.out.println(even_num[i]);
        }
    }
}
