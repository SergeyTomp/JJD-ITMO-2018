package hw8.palindrom;

// не понял, что в данной задаче можно считать некорректными данными, поэтому проверку не делал

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Palindrom {

    public static boolean isPalindrome(String str) {
        String reverse = "";
        for(int i = 0; i < str.length(); i++) {
            reverse += str.charAt(str.length() - i - 1);
        }
        return reverse.equals(str);
    }
    public static void main (String[]args){
        System.out.println("enter line");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(str);
        Map<String, Integer> set = new HashMap<>();
        String [] simb = str.trim().split(" ");
        for (String poly : simb) {
            if (isPalindrome(poly)) {
                if (set.get(poly) != null) {
                    set.put(poly, set.get(poly) + 1);
                } else {
                    set.put(poly, 1);
                }
            }
        }
        for (Map.Entry entry : set.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
