package hw6_Improve;

import java.util.*;

public class WordProcessor {
    private List<String> wordsLst;
    private Hashtable<String, Integer> uniqWordsLst;
    private List<Word> sortedLst;
    private ArrayList<String> [] wordsByLength;

    WordProcessor (List<String> lines){

        wordsLst = new ArrayList<>();	                    // массив для сырого набора слов
        uniqWordsLst = new Hashtable<>();	                // HashTable слово - частота повторения
        sortedLst = new ArrayList<>();	                    // ArrayList для сортировки HashTable по значению

        //переводим в нижний регистр, обрезаем пробелы по концам, удаляем знаки препинания, режем на слова и в массив
        for (String str : lines){
            String [] cleanRubbish = str.toLowerCase()
                    .replaceAll("'t"," ")
                    .replaceAll("[\\p{Punct}\\d]+"," ")
                    .trim()
                    .split("\\s+");
            for (int i = 0; i < cleanRubbish.length; i++){
                wordsLst.add(cleanRubbish[i]);
            }
        }

        // набиваем Hashtable словами с количеством
        for (String str : wordsLst){
            if (uniqWordsLst.containsKey(str)){
                uniqWordsLst.put(str, uniqWordsLst.get(str) + 1);
            }
            else {
                if (str != ""){uniqWordsLst.put(str, 1);}
            }
        }

        //перегоняем HashTable в ArrayList<Word> для последующей сортировки
        for (Map.Entry entry: uniqWordsLst.entrySet()) {
            String key = (String) entry.getKey();
            Integer value = (Integer) entry.getValue();
            sortedLst.add(new Word(key, value));
        }
    }

    void showFrequentWords (int n){
        System.out.println();
        System.out.println("Частота встречаемости слов");
        //сортируем ArrayList по частоте встречаемости слов
        // в какую сторону сортировка зависит от настройки компаратора
        Collections.sort(sortedLst, new QtyComparator());

        // выводим первые 10 элементов массива, там наиболлее часто встечающиеся слова
        Iterator<Word> iter = sortedLst.iterator();
        int i = 0;
        Word nextElem;
        while (i < n){
            nextElem = iter.next();
            System.out.println("Слово " + nextElem.getWord() + " встречается " + nextElem.getQty() + " раз.");
            i++;
        }
    }

    protected void groupsPrepare(){
        //сортируем ArrayList по длине слова
        Collections.sort(sortedLst, new LetterNumComparator());
        int maxWordLngth = sortedLst.get(0).getLttrNum();   //определяем максимальную длину слова, она определит размер массива ArrayList-ов
        wordsByLength = new ArrayList [maxWordLngth + 1];	//индексированный массив для объектов типа ArrayList <String>
        // набиваем массив пустыми ArrayList-ми
        for (int i = 0; i < wordsByLength.length; i++){
            wordsByLength [i] = new ArrayList();
        }
        // набиваем ArrayList-ы по индексам массива, соответствующим размеру слова
        for (Word elem : sortedLst){
            wordsByLength[elem.getLttrNum()].add(elem.getWord());
        }
    }

    void showWordGroups (){
        groupsPrepare();
        System.out.println();
        System.out.println("Группировка слов по количеству букв");
        //выводим все массивы со словами
        int j = 0;
        for (ArrayList arr : wordsByLength) {
            if (j != 0){System.out.println("Слова с количеством букв - " + j + " " + arr);}
            j++;
        }
    }

    void showWordGroupsExclude (String [] except){
        System.out.println();
        System.out.println("Группировка слов по количеству букв за вычетом слов, заданных в перечне исключений");
        groupsPrepare();
        ArrayList<String> specWords = new ArrayList<>();
        Collections.addAll(specWords, except);
        for (Word elem : sortedLst){
            wordsByLength[elem.getLttrNum()].removeAll(specWords);
        }
        int j = 0;
        for (ArrayList arrexc : wordsByLength) {
            if (j != 0){System.out.println("Слова с количеством букв - " + j + " " + arrexc);}
            j++;
        }
    }
}
