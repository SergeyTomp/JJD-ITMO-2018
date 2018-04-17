package hw8.duplicate;

// не понял, что в данной задаче можно считать некорректными данными, поэтому проверку не делал

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Duplicate {
    public static void main (String[]args){
        System.out.println("enter line");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(str);
        Map<String, Integer> set = new HashMap<>();
        String [] simb = str.trim().split(" ");
        for (String smb : simb){
            if (!smb.isEmpty()){
                if (set.get(smb) != null){
                    set.put(smb, set.get(smb) + 1);
                }
                else {
                    set.put(smb, 1);
                }
            }
        }
        for (Map.Entry entry : set.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}