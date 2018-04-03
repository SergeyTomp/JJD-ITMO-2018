package hw5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class XmlHandler extends FileHandler {

    XmlHandler(String pathFileName){
        super(pathFileName);
    }
    @Override                                               //в общем случае метод может быть переопределён, условно покажем это
    void read() throws IOException {                        //идея настаивала добавить про исключение
        try {
            br = new BufferedReader(new FileReader(file));  //идея настаивала добавить про обработку исключения
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (br.readLine() != null){
            System.out.println(br.readLine());
        }
    }
}
