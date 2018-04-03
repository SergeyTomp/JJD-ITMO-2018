package hw5;

import java.io.IOException;

public class ConfigRead {
    public static void main (String [] args) throws IOException {

        String pathFileName = "foo.xml";
        FileHandler handler = new FileHandler(pathFileName);
        handler.getInstance().read();
    }
}
