package hw5;
import java.io.*;

 class JsonHandler extends FileHandler {

    JsonHandler(String pathFileName){
        super(pathFileName);
    }
    @Override                                               //в общем случае метод может быть переопределён, условно покажем это
    void read() throws IOException {                        //идея настаивала добавить про исключение
        try {
            br = new BufferedReader(new FileReader(file));  //идея настаивала добавить про обработку исключения
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
    }
}