package hw9;

import java.io.*;
import java.util.LinkedList;

public class EncodeDecode {
    static void encodeDecodeFile(File source, File encoded, String key)throws IOException {

        try (InputStream is = new BufferedInputStream(new FileInputStream(source));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(encoded))){
            byte[] keyBytes = key.getBytes();
            LinkedList<Byte> byteList = new LinkedList();
            for (Byte b : keyBytes){
                byteList.add(b);
            }

            int smth;
            while((smth = is.read()) > 0){
                os.write(smth ^ byteList.getFirst());
                byteList.addLast(byteList.getFirst());
            }
        }
    }
    public static void main (String[]args) {
        File source = new File("src/hw9/source.txt");
        File destEncoded = new File("src/hw9/destEncoded.txt");
        File destDecoded = new File("src/hw9/destDecoded.txt");
        String key = "qwerty";
        try {
            encodeDecodeFile (source, destEncoded,key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            encodeDecodeFile (destEncoded, destDecoded,key);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
