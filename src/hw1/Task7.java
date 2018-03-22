package hw1;

// Выведите на экран первые 11 членов последовательности Фибоначчи.
// Первый и второй члены последовательности равны единицам, а каждый следующий — сумме двух предыдущих.
public class Task7 {
    public static void main(String[] args) {
        int a = 1, b = 1, c = 0;
        System.out.print(a + " " + b + " ");
        for (int i = 3; i <= 11; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(c + " ");
        }
    }
}
