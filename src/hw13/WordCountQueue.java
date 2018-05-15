package hw13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static java.lang.Thread.currentThread;
import static java.util.stream.Collectors.toList;

public class WordCountQueue {
    private static final String STOP = new String();

    // Задача №2
    // Результаты сложить в другую очередь для main,
    // а main сольет их вместе.

    public static void main(String[] args) throws InterruptedException {
        InputStream in = WordCountQueue.class.getClassLoader().getResourceAsStream("wap.txt");
        BufferedReader rdr = new BufferedReader(new InputStreamReader(in));
        List<String> lines = rdr.lines().collect(toList());
        int cpus = Runtime.getRuntime().availableProcessors();
        List<WordCountThread> workers = new ArrayList<>();
        BlockingQueue<String> linesQueue = new LinkedBlockingQueue<>();
        BlockingQueue<HashMap<String, Integer>> mapQueue = new ArrayBlockingQueue<>(cpus);
        Map<String, Integer> rawResult = new HashMap();
        ValueComparator bvc = new ValueComparator(rawResult);//будем сортировать по значению
        TreeMap<String, Integer> sorted_result = new TreeMap<>(bvc);
        List <Word> sortedList = new ArrayList<>();

        linesQueue.addAll(lines);
        linesQueue.add(STOP);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < cpus; i++) {
            WordCountThread wct = new WordCountThread(linesQueue, mapQueue);
            workers.add(wct);
            wct.start();
        }

        // вариант выкачивать данные по ходу работы потоков
        int j = cpus;
        while (j != 0){
            for (Map.Entry entry : mapQueue.take().entrySet()){
                String key = (String) entry.getKey();
                Integer value = (Integer) entry.getValue();
                if (rawResult.containsKey(key)){
                    rawResult.put(key, rawResult.get(key) + value);
                }
                else {
                    rawResult.put(key, value);
                }
            }
            j--;
        }

//        // вариант дождаться окончания работы потоков
//        for (WordCountThread worker : workers)
//            worker.join();
//        for (HashMap<String, Integer> hm: mapQueue) {
//            for (Map.Entry entry : hm.entrySet()){
//                String key = (String) entry.getKey();
//                Integer value = (Integer) entry.getValue();
//                if (rawResult.containsKey(key)){
//                    rawResult.put(key, rawResult.get(key) + value);
//                }
//                else {
//                    rawResult.put(key, value);
//                }
//            }
//        }
        //оба варианта не отличаются по времени

        // вариант сортировки через HashMap -> ArrayList -> Collections.sort дольше на ~ 10% чем HashMap -> TreeMap(comparator) ниже
//        for (Map.Entry entry: rawResult.entrySet()) {
//            String key = (String) entry.getKey();
//            Integer value = (Integer) entry.getValue();
//            sortedList.add(new Word(key, value));
//        }
//        Collections.sort(sortedList, new QtyComparator());
//        Iterator<Word> iter = sortedList.iterator();
//        int i = 0;
//        Word nextElem;
//        while (i < 10){
//            nextElem = iter.next();
//            System.out.println("Слово " + nextElem.getWord() + " встречается " + nextElem.getQty() + " раз.");
//            i++;
//        }

        // вариант сортировки через HashMap -> TreeMap(comparator) быстрее HashMap -> ArrayList -> Collections.sort на ~ 10%
        sorted_result.putAll(rawResult);        // Выбрать топ 10 из result
        int i = 0;
        for (Map.Entry entry : sorted_result.entrySet()){
            if (i < 10){
                System.out.println("Слово " + entry.getKey() + " встречается " + entry.getValue() + " раз.");
                i++;
            }
            else break;
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(currentThread().getName() + " elapsedTime " + elapsedTime);
    }

    private static class WordCountThread extends Thread {
        private final BlockingQueue<String> linesQueue;
        private HashMap<String, Integer> wordCnt = new HashMap<>();
        BlockingQueue<HashMap<String, Integer>> mapQueue;
        String line;

        WordCountThread(BlockingQueue<String> linesQueue, BlockingQueue<HashMap<String, Integer>> mapQueue) {
            this.linesQueue = linesQueue;
            this.mapQueue = mapQueue;
        }

        @Override
        public void run() {
            // Считаем в wordCnt
            while (!isInterrupted()) {
                try {
                    line = linesQueue.take();
                    if (line == STOP){
                        linesQueue.add(STOP);
                        break;
                    }
                } catch (InterruptedException e) {
                    return;
                }
                String [] delWaste = line.toLowerCase()
                            .replaceAll("'t"," ")
                            .replaceAll("[\\p{Punct}\\d]+"," ")
                            .trim()
                            .split("\\s+");
                for (String delwaste : delWaste) {
                    if (wordCnt.containsKey(delwaste)) {
                        wordCnt.put(delwaste, wordCnt.get(delwaste) + 1);
                    } else {
                        if (!delwaste.equals("")) {
                            wordCnt.put(delwaste, 1);
                        }
                    }
                }
            }
            // Сливаем в общую Map
            mapQueue.add(wordCnt);
        }
    }
}
