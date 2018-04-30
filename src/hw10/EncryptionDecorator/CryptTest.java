package hw10.EncryptionDecorator;

import java.io.*;

public class CryptTest {
    public static void main(String[] args) throws IOException{
        File source = new File("src/hw10/EncryptionDecorator/source.txt");
        File encoded = new File("src/hw10/EncryptionDecorator/encoded.txt");
        File decoded = new File("src/hw10/EncryptionDecorator/decoded.txt");
        String pass = "qwerty";
        try (InputStream is = new CryptedInputStream(new FileInputStream(source),pass);
             OutputStream os = new FileOutputStream(encoded)) {
            int smth;
            while((smth = is.read()) != -1){
                os.write(smth);
            }
        }
        try (InputStream is = (new FileInputStream(encoded));
             OutputStream os = new CryptedOutputStream(new FileOutputStream(decoded),pass)) {
            int smth;
            while((smth = is.read()) != -1) {
                os.write(smth);
            }
        }
    }
}
