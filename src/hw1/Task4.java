package hw1;

//перестановка трёх цифр для получения возрастающей последовательности
public class Task4 {
    public static void main(String[] args) {
        int a = -3;
        int b = 3;
        int c = -1;
        int tmp;
        while ((a > b) || (a > c) || (b > c)) {
            if (a > b) {
                tmp = a;
                a = b;
                b = tmp;
            }
            if (b > c) {
                tmp = b;
                b = c;
                c = tmp;
            }
        }
        System.out.println(a + " " + b + " " + c);
    }
}
