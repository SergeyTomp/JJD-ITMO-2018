package hw14;

import java.util.Comparator;
import java.util.Map;

// компаратор для сортировки содержимого HashTable по встречаемости поссле перевода в ArrayList
public class QtyComparator implements Comparator<Map.Entry<String, Integer>> {

    public int compare(Map.Entry<String, Integer> wrd1, Map.Entry<String, Integer> wrd2) {
        int qty1 = wrd1.getValue();
        int qty2 = wrd2.getValue();

        return Integer.compare(qty2, qty1);
    }
}
