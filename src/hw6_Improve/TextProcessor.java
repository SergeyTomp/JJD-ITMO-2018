package hw6_Improve;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class TextProcessor {
    public static void main (String [] args) throws IOException {
        File txt = new File("src/hw6/wpcut.txt");
        List<String> lines = Files.readAllLines(txt.toPath());
        String []except = {"at","on","in","the","a","an","of","if","onto","into","under",
                "up","over","by","to","if","for","is","was","were","will","no","yes","a"}; //и так далее

        WordProcessor procW = new WordProcessor(lines);
        procW.showFrequentWords(10);
        procW.showWordGroups();
        procW.showWordGroupsExclude(except);

        LetterProcessor procL = new LetterProcessor(lines);
        procL.countLetters();
        procL.lettersPercents();
    }
}
