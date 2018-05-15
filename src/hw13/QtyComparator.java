package hw13;

import java.util.Comparator;

// компаратор для сортировки содержимого HashTable по встречаемости поссле перевода в ArrayList
public class QtyComparator implements Comparator<Word> {
    public int compare(Word wrd1, Word wrd2) {
        int qty1 = wrd1.getQty();
        int qty2 = wrd2.getQty();

        return Integer.compare(qty2, qty1);
    }
}
