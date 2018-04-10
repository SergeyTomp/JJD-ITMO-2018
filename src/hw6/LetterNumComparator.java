package hw6;

import java.util.Comparator;

// компаратор для сортировки содержимого HashTable по длине слова поссле перевода в ArrayList
public class LetterNumComparator implements Comparator<Word> {
    public int compare(Word wrd1, Word wrd2) {
        int qty1 = wrd1.getLttrNum ();
        int qty2 = wrd2.getLttrNum ();

        if(qty1 > qty2) {
            return -1;
        }
        else if(qty1 < qty2) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
