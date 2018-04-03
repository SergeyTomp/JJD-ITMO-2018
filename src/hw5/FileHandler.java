package hw5;

import java.io.*;

public class FileHandler {

    protected BufferedReader br;
    protected File file;
    protected String pathFileName;
    FileHandler(String pathFileName) {
        this.file = new File(pathFileName);
        this.pathFileName = pathFileName;
    }
    //метод по умолчанию
    void read() throws IOException {                          //идея настаивала добавить про исключение
        try {
            br = new BufferedReader(new FileReader(file));    //идея настаивала добавить про обработку исключения
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (br.readLine() != null){
            System.out.println(br.readLine());
        }
    }
    FileHandler getInstance(){
        if (pathFileName.endsWith (".xml")){
            return new XmlHandler(pathFileName);
        }
        else if (pathFileName.endsWith (".json")){
            return new JsonHandler(pathFileName);
        }
        else {
            System.out.println ("Неопознанный файл");
            return null;
        }
    }
}
