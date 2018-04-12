package hw6;
//тестируем на урезанном файле wpcut
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class WarAndPiece {
    public static void main (String [] args) throws IOException {
        File txt = new File("src/hw6/wpcut.txt");
        List<String> lines = Files.readAllLines(txt.toPath());

        List<String> wordsLst = new ArrayList<>();	                    //массив для сырого набора слов
        List<String> lttrsLst = new ArrayList<>();	                    //массив для сырого набора букв
        Hashtable<String, Integer> uniqWordsLst = new Hashtable<>();	// HashTable слово - частота повторения
        Hashtable<String, Integer> letters = new Hashtable<>();	        // HashTable буква - частота повторения
        List<Word> sortedLst = new ArrayList<>();	                    //ArrayList для сортировки HashTable по значению


//переводим в нижний регистр, обрезаем пробелы по концам, удаляем знаки препинания, режем на слова и в массив

        for (String str : lines){
            String [] cleanRubbish = str.toLowerCase().replaceAll("\\p{Punct}"," ").trim().split("\\s+");
            for (int i = 0; i < cleanRubbish.length; i++){
                wordsLst.add(cleanRubbish[i]);
            }
        }

        //набиваем Hashtable словами с количеством
        for (String str : wordsLst){
            if (uniqWordsLst.containsKey(str)){
                uniqWordsLst.put(str, uniqWordsLst.get(str) + 1);
            }
            else {
                uniqWordsLst.put(str, 1);
            }
        }

        //перегоняем HashTable в ArrayList<Word> для последующей сортировки
        // пришлось познать Map и Map.Entry, иначе совсем неукдюже выходило
        for (Map.Entry entry: uniqWordsLst.entrySet()) {
            String key = (String) entry.getKey();
            Integer value = (Integer) entry.getValue();
            sortedLst.add(new Word (key, value));
        }

        //сортируем ArrayList по частоте встречаемости слов
        // в какую сторону сортировка зависит от настройки компаратора
        Collections.sort(sortedLst, new QtyComparator());

        // выводим первые 10 элементов массива, там наиболлее часто встечающиеся слова
        System.out.println();
        Iterator<Word> iter = sortedLst.iterator();
        int i = 0;
        Word nextElem;
        while (i < 10){
            nextElem = iter.next();
            System.out.println("Слово " + nextElem.getWord() + " встречается " + nextElem.getQty() + " раз.");
            i++;
        }

        //сортируем ArrayList по длине слова
        Collections.sort(sortedLst, new LetterNumComparator());

        int maxWordLngth = sortedLst.get(0).getLttrNum();                       //определяем максимальную длину слова, она определит размер массива ArrayList-ов
        ArrayList<String> [] wordsByLength = new ArrayList [maxWordLngth + 1];	//индексированный массив для объектов типа ArrayList <String>
        // набиваем массив пустыми ArrayList-ми
        for (i = 0; i < wordsByLength.length; i++){
            wordsByLength [i] = new ArrayList();
        }
        // набиваем ArrayList-ы по индексам массива, соответствующим размеру слова
        for (Word elem : sortedLst){
            wordsByLength[elem.getLttrNum()].add(elem.getWord());
        }
        //выводим все массивы со словами
        System.out.println();
        int j = 0;
        for (ArrayList arr : wordsByLength) {
            System.out.println("Слова с количеством букв - " + j + " " + arr);
            j++;
        }

        //удаляем ненужные слова
        String []except = {"at","on","in","the","a","an","of","if","onto","into","under",
                "up","over","by","to","if","for","is","was","were","will","no","yes"}; //и так далее
        ArrayList<String> specWords = new ArrayList<>();
        Collections.addAll(specWords, except);
        for (Word elem : sortedLst){
            wordsByLength[elem.getLttrNum()].removeAll(specWords);
        }

        System.out.println();
        j = 0;
        for (ArrayList arrexc : wordsByLength) {
            System.out.println("Слова с количеством букв - " + j + " " + arrexc);
            j++;
        }

        //повторяем то же самое, только теперь непрерывные цепочки букв
        for (String lttrs : lines){
            String [] lttrsOnly = lttrs.toLowerCase().replaceAll("\\p{Punct}","")
                    .replaceAll("\\s+","").replaceAll("\\d+","")
                    .trim().split("");
            for (i = 0; i < lttrsOnly.length; i++){
                lttrsLst.add(lttrsOnly[i]);
            }
        }

        //набиваем Hashtable буквами с количеством, сортировку в каком-либо порядке не успел сделать.
        for (String lttr : lttrsLst){
            if (letters.containsKey(lttr)){
                letters.put(lttr, letters.get(lttr) + 1);
            }
            else {
                letters.put(lttr, 1);
            }
        }

        Enumeration<String> enumer = letters.keys();
        int lettersQty = 0;
        while (enumer.hasMoreElements()){
            lettersQty = lettersQty + letters.get(enumer.nextElement());
        }
        System.out.println("Всего букв " + lettersQty);

        System.out.println();
        Enumeration<String> enumer2 = letters.keys();
        String key;
        float percent;
        while (enumer2.hasMoreElements()){
            key = enumer2.nextElement();
            percent = 100 * (float)letters.get(key) / (float)lettersQty;
            System.out.println("Буква " + key + " встречается " + letters.get(key) + " раз, " + percent + "%");

        }
    }
}
