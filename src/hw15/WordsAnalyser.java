package hw15;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class WordsAnalyser {
    public static void main(String[] args) throws IOException {
        calcAverage();
        findcMax();
        groupByLength();
    }
    //группировать слова по длине
    private static void groupByLength() throws IOException {
        Path wapPath = prepareFile();
    //        Map<Integer, List<String>> maxLengtthSet =
                Files.lines(wapPath)
                .parallel()
                .map(line -> line.toLowerCase()
                        .replaceAll("'t"," ")
                        .replaceAll("[\\p{Punct}\\d]+"," "))
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .map(String::trim)
                .filter(word -> !("".equals(word) || word.length()== 1))
                .collect(Collectors.groupingBy(word -> word.length(), Collectors.toSet()))
                .forEach((integer, strings) -> {
                    System.out.print(integer + " ");
                    System.out.println(strings);
                });
    }
    // найти самое длинное слово
    private static void findcMax() throws IOException {
        Path wapPath = prepareFile();
        String result = Files.lines(wapPath)
                .parallel()
                .map(line -> line.toLowerCase()
                        .replaceAll("[\\p{Punct}\\d]+"," ")
                        .replaceAll("'t"," "))
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .map(String::trim)
                .filter(word -> !"".equals(word))
                .max(Comparator.comparing(word -> word.length())).get();
        System.out.println(result);
    }
    //найти среднюю длину слов
    private static void calcAverage() throws IOException {
        Path wapPath = prepareFile();
        double result = Files.lines(wapPath)
                    .parallel()
                    .map(line -> line.toLowerCase()
                            .replaceAll("[\\p{Punct}\\d]+"," ")
                            .replaceAll("'t"," "))
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .map(String::trim)
                    .filter(word -> !"".equals(word))
                    .collect(Collectors.averagingInt(word -> word.length()));
        System.out.println(result);

//                        .collect(groupingBy(word->word.length(), counting()));
//
//       int up = result
//               .entrySet()
//               .parallelStream()
//               .reduce(0, (integer, integerLongEntry) -> (int)(integer + integerLongEntry.getKey()*integerLongEntry.getValue()), (i1, i2)-> i1 + i2 );
//        int down = result.values().parallelStream().reduce((k,v)-> k + v).get().intValue();
    }
    private static Path prepareFile() throws IOException {
        InputStream in = WordsAnalyser.class.getClassLoader().getResourceAsStream("wap.txt");

        File tmp = File.createTempFile("wap", "txt");
        tmp.deleteOnExit();
        Path wapPath = tmp.toPath();
        Files.copy(in, wapPath, StandardCopyOption.REPLACE_EXISTING);
        return wapPath;
    }
}
