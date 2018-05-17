package hw14;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.BiFunction;

import static java.lang.Thread.currentThread;
import static java.util.stream.Collectors.toList;

public class WordCountPool {
    private static final String STOP = new String(); //ссылка на фиктивную строку - сигнал окончания массива строк

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        InputStream in = WordCountPool.class.getClassLoader().getResourceAsStream("wap.txt");
        BufferedReader rdr = new BufferedReader(new InputStreamReader(in));
        List<String> lines = rdr.lines().collect(toList());
        BlockingQueue<String> linesQueue = new LinkedBlockingQueue<>();     //отсюда потоки будут брать строки
        Map<String, Integer> rawResult = new HashMap<>();                   //сюда соберём черновые результатыт работы потоков
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>();    //сюда соберём rawResult.entryset и отсортируем
        int cpus = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(cpus);          // Создаём пул потоков
//        ExecutorService pool = new ThreadPoolExecutor (1,cpus,2,TimeUnit.MINUTES, new LinkedBlockingQueue<>());
        List<Future<Map<String, Integer>>> futs = new ArrayList<>();        // Сюда сложим futures, возвращаемые pool.submit

        linesQueue.addAll(lines);
        linesQueue.add(STOP);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < cpus; i++) {
            // собираем потоки в пул и складываем futures, возвращаемые pool.submit в futs
            futs.add(pool.submit(new WordCountTask(linesQueue)));
        }

        for (Future<Map<String, Integer>> fut : futs) {
            // собираем результаты работы потоков в итоговый Мар, складывая values через merge
            for (Map.Entry<String, Integer> entry : fut.get().entrySet()) {
                rawResult.merge(entry.getKey(), entry.getValue(), new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) {
                        return integer + integer2;
                    }
                });
            }
        }

        pool.shutdown();
        sortedList.addAll(rawResult.entrySet());
        sortedList.sort(new QtyComparator());
        Iterator<Map.Entry<String, Integer>> iter = sortedList.iterator();
        int i = 0;
        Map.Entry<String, Integer> nextElem;
        while (i < 10) {
            nextElem = iter.next();
            System.out.println("Слово " + nextElem.getKey() + " встречается " + nextElem.getValue() + " раз.");
            i++;
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(currentThread().getName() + " elapsedTime " + elapsedTime);
    }

    private static class WordCountTask implements Callable<Map<String, Integer>> {

        private final BlockingQueue<String> linesQueue;
        private HashMap<String, Integer> wordCnt = new HashMap<>();
        String line;

        WordCountTask(BlockingQueue<String> linesQueue) {
            this.linesQueue = linesQueue;
        }

        @Override
        public Map<String, Integer> call(){
            Map<String, Integer> wordCnt = new HashMap<>();
            while ((!Thread.currentThread().isInterrupted())) {
                try {
                    line = linesQueue.take();
                    if (line == STOP) { //именно через ==, а не через equals, т.к. нам нужно сравнить ссылки, а не текст
                        linesQueue.add(STOP);
                        break;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " is interrupted");
                }
                String[] delWaste = line.toLowerCase()
                        .replaceAll("'t", " ")
                        .replaceAll("[\\p{Punct}\\d]+", " ")
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
            System.out.println(Thread.currentThread().getName() + "is terminated");
            return wordCnt;
        }
    }
}
