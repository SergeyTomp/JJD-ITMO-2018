package hw9;

import java.io.*;

public class CopyFile {

    static void copyFile(File source, File dest)throws IOException {

        try (InputStream is = new BufferedInputStream(new FileInputStream(source));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(dest))){

            int smth;
            while((smth = is.read()) > 0){
                os.write(smth);
            }
        }
    }
    public static void main (String[]args){
        File source = new File("src/hw9/source.txt");
        File destCopy = new File("src/hw9/dest.txt");
        try {
            copyFile(source, destCopy);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
