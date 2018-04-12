package hw6_Improve;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Lesson9task {
//для каждой строки
//перервести внижний регистр
//убрать пробеля в начале и конце
// поместить в коллекцию непустые слова
   public static void main(String[] args) throws IOException {
       File txt = new File("src/hw6/wpcut.txt");
       List<String> lines = Files.readAllLines(txt.toPath());
       ArrayList<String> strings = new ArrayList<>();

       for (String str : lines) {
           String[] cleanRubbish = str.toLowerCase()
                   .replaceAll("'t"," ")
                   .replaceAll("[\\p{Punct}\\d]+"," ")
                   .trim()
                   .split("\\s+");
           for (int i = 0; i < cleanRubbish.length; i++) {
               strings.add(cleanRubbish[i]);
           }
       }
       System.out.println(strings);
   }
}
