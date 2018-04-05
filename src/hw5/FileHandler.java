package hw5;
import java.io.*;

class FileHandler {

    protected BufferedReader br;
    protected File file;
    private String pathFileName;

    FileHandler(String pathFileName) {
        this.pathFileName = pathFileName;
        this.file = new File(pathFileName);
    }
    //метод по умолчанию
    void read()throws IOException {}

    FileHandler getInstance(){
        if (pathFileName.endsWith (".xml")){
            return new XmlHandler(pathFileName);
        }
        else if (pathFileName.endsWith (".json")){
            return new JsonHandler(pathFileName);
        }
        else if (pathFileName.endsWith (".txt")){
            return new TxtHandler(pathFileName);
        }
        else {
            return new ErrorHandler(pathFileName);
       }
    }
}
