package hw1;

// счастливый билет
public class Task8 {
    public static void main(String[] args) {
        int dig1, dig2, dig3, dig4, dig5, dig6, cntr = 0;
        for (int i = 1001; i < 1000000; i++) {
            dig1 = i / 100000 % 10;
            dig2 = i / 10000 % 10;
            dig3 = i / 1000 % 10;
            dig4 = i / 100 % 10;
            dig5 = i / 10 % 10;
            dig6 = i % 10;
            if ((dig1 + dig2 + dig3) == (dig4 + dig5 + dig6)) {
                cntr++;
            }
        }
        System.out.print("Нужно " + cntr + " сувениров");
    }
}
