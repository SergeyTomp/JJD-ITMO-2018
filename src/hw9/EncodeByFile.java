package hw9;

import java.io.*;
// не работает декодирование
public class EncodeByFile {
    static void encodeDecodeByFile(File source, File encoded, File key)throws IOException {

        try (InputStream is = new BufferedInputStream(new FileInputStream(source));
             InputStream coder = new BufferedInputStream(new FileInputStream(key));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(encoded))){
            long keyLen = key.length();
            coder.mark((int) keyLen);
            int fromSource, fromKey;
            long index = 0;
            while((fromSource = is.read()) > 0){
                if (++ index > keyLen){
                    index = 0;
                    coder.reset();
                }
                fromKey = coder.read();
                os.write(fromSource ^ fromKey);

            }
        }
    }

    public static void main (String[]args) {
        File source = new File("src/hw9/source.txt");
        File destEncoded = new File("src/hw9/encodedByFile.txt");
        File destDecoded = new File("src/hw9/decodedByFile.txt");
        File key = new File("src/hw9/key.txt");
        try {
            encodeDecodeByFile (source, destEncoded,key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            encodeDecodeByFile (destEncoded, destDecoded,key);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
