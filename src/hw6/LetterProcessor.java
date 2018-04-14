package hw6;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class LetterProcessor {

    List<String> lttrsLst;                 //массив для сырого набора букв
    Hashtable<String, Integer> letters;	   // HashTable буква - частота повторения
    int lettersQty;                        // общее количество букв в тексте

    LetterProcessor (List<String> lines){

        lttrsLst = new ArrayList<>();
        letters = new Hashtable<>();
        lettersQty = 0;

        for (String lttrs : lines){
            String [] lttrsOnly = lttrs.toLowerCase()
                    .replaceAll("[\\p{Punct}\\s\\d]+","")
                    .trim()
                    .split("");
            for (int i = 0; i < lttrsOnly.length; i++){
                lttrsLst.add(lttrsOnly[i]);
            }
        }

        //набиваем Hashtable буквами с количеством
        for (String lttr : lttrsLst){
            if (letters.containsKey(lttr)){
                letters.put(lttr, letters.get(lttr) + 1);
                lettersQty += 1;
            }
            else {
                letters.put(lttr, 1);
                lettersQty += 1;
            }
        }
    }

    void countLetters (){
        System.out.println();
        System.out.println("Всего букв " + lettersQty);
    }

    void lettersPercents (){
        System.out.println();
        System.out.println("Частота встречаемости букв");
        Enumeration<String> enumer = letters.keys();
        String key;
        float percent;
        while (enumer.hasMoreElements()){
            key = enumer.nextElement();
            percent = 100 * (float)letters.get(key) / (float)lettersQty;
            System.out.println("Буква " + key + " встречается " + letters.get(key) + " раз, " + percent + "%");
        }
    }
}
