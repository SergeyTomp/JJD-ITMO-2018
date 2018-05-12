package hw12;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Thread.currentThread;
import static java.util.stream.Collectors.toList;

public class WordCountOneThread {

    public static void main(String[] args){
        InputStream in = WordCountMultiThread.class.getClassLoader().getResourceAsStream("wap.txt");
        BufferedReader rdr = new BufferedReader(new InputStreamReader(in));
        List<String> lines = rdr.lines().collect(toList());
        Map<String, Integer> wordCnt = new HashMap<>();
        ValueComparator bvc = new ValueComparator(wordCnt);//будем сортировать по значению
        TreeMap<String, Integer> sorted_result = new TreeMap<>(bvc);
        long startTime = System.currentTimeMillis();

        for (String line : lines) {
            if (!line.isEmpty()){ // пришлось добавить эту проверку - при числе пустых строк подряд > 3 почему-то считает пробелы словами
                String[] delWaste = line.toLowerCase()
                        .replaceAll("'t"," ")
                        .replaceAll("[\\p{Punct}\\d]+"," ")
                        .trim()
                        .split("\\s+");
                for (int i = 0; i < delWaste.length; i++) {
                    if (wordCnt.containsKey(delWaste[i])){
                        wordCnt.put(delWaste[i], wordCnt.get(delWaste[i]) + 1);
                    }
                    else {
                        if (delWaste[i] != ""){wordCnt.put(delWaste[i], 1);}
                    }
                }
            }
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(currentThread().getName() + " elapsedTime " + elapsedTime);

        // Выбрать топ 10 из result
        sorted_result.putAll(wordCnt);
        int i = 0;
        for (Map.Entry entry : sorted_result.entrySet()){
            if (i < 10){
                System.out.println("Слово " + entry.getKey() + " встречается " + entry.getValue() + " раз.");
                i++;
            }
            else break;
        }
    }
}
