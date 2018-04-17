package hw8.goodList;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Map;


public class Journal {

    Map<String, Buyer> journal;

    public static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }
    Journal() {
        journal = new HashMap<>();
    }

    int addTransact(String data) {
        String[] arr = data.split(" ");
        if (arr.length != 3 || arr[2].isEmpty() || !isNumeric(arr[2])){
            return -1;
        }
        String name = arr[0];
        String tov = arr[1];
        int num = Integer.parseInt(arr[2]);
        if (!journal.containsKey(name)) {
            journal.put(name, new Buyer(name));
        }
        journal.get(name).addGood(tov, num);
        return 0;
    }

    void showJournal() {
        for (Map.Entry entry : journal.entrySet()) {
            System.out.println(entry.getKey() + ":");
            Buyer buyer = journal.get(entry.getKey());
            for (Map.Entry en : buyer.good.entrySet()) {
                System.out.println(en.getKey() + " - " + en.getValue());
            }
        }
    }
}
