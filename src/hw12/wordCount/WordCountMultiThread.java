package hw12.wordCount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Thread.currentThread;
import static java.util.stream.Collectors.toList;

public class WordCountMultiThread {

    private static Map<String, Integer> result = new HashMap<>();
    public static void main(String[] args) throws InterruptedException {

        InputStream in = WordCountMultiThread.class.getClassLoader().getResourceAsStream("wap.txt");
        BufferedReader rdr = new BufferedReader(new InputStreamReader(in));
        List<String> lines = rdr.lines().collect(toList());
        int cpus = Runtime.getRuntime().availableProcessors();
        System.out.println("CPU NUMBER " + cpus);

        List<WordCountThread> workers = new ArrayList<>();
        ValueComparator bvc = new ValueComparator(result);//будем сортировать по значению
        TreeMap<String, Integer> sorted_result = new TreeMap<>(bvc);

        int partition = lines.size()/cpus;
        int rest = lines.size()%cpus;
        WordCountThread wct;
        //разделяем lines на равные части числом cpus
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < cpus; i++) {
            if ((i != (cpus - 1))) {
                wct = new WordCountThread(lines.subList(i * partition, (i + 1) * partition));
            }
            else {
                wct = new WordCountThread(lines.subList(i*partition, (i + 1)*partition + rest));
            }
            workers.add(wct);
        }
        for (WordCountThread worker : workers)
            worker.start();
        for (WordCountThread worker : workers)
            worker.join();

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(currentThread().getName() + " elapsedTime " + elapsedTime);

        // Выбрать топ 10 из result - переливаем в TreeMap с сортировкой по значению.
        sorted_result.putAll(result);
        int i = 0;
        for (Map.Entry entry : sorted_result.entrySet()){
            if (i < 10){
                System.out.println("Слово " + entry.getKey() + " встречается " + entry.getValue() + " раз.");
                i++;
            }
            else break;
        }
    }

    private static class WordCountThread extends Thread {
        private List<String> lines;
        private Map<String, Integer> wordCnt = new HashMap<>();

        WordCountThread(List<String> lines) {
            this.lines = lines;
                    }
        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            // Считаем в wordCnt
            int delWasteSise = 0;
            for (String line : lines) {
                String [] delWaste = line.toLowerCase()
                        .replaceAll("'t"," ")
                        .replaceAll("[\\p{Punct}\\d]+"," ")
                        .trim()
                        .split("\\s+");
                delWasteSise = delWasteSise + delWaste.length;
                for (int i = 0; i < delWaste.length; i++) {
                    if (wordCnt.containsKey(delWaste[i])){
                        wordCnt.put(delWaste[i], wordCnt.get(delWaste[i]) + 1);
                    }
                    else {
                        if (!delWaste[i].equals("")){wordCnt.put(delWaste[i], 1);}
                    }
                }
            }

            // Сливаем в общую Map
            synchronized (WordCountMultiThread.class){
                for (Map.Entry entry : wordCnt.entrySet()){
                    String key = (String) entry.getKey();
                    Integer value = (Integer) entry.getValue();
                    if (result.containsKey(key)){
                        result.put(key, result.get(key) + value);
                    }
                    else {
                        result.put(key, value);
                    }
                }
            }
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(currentThread().getName() + " elapsedTime " + elapsedTime);
        }
    }
}
