package hw9;

import java.io.*;

public class SplitMergeFile {
    static void splitFile(File source, File dest1, File dest2,int partition)throws IOException {

        try (InputStream is = new BufferedInputStream(new FileInputStream(source));
             OutputStream os1 = new BufferedOutputStream(new FileOutputStream(dest1));
             OutputStream os2 = new BufferedOutputStream(new FileOutputStream(dest2))){
            long read = 0;
            long length = source.length();
            long part1Length = length / partition;
            int smth;
            while((smth = is.read()) > 0){
                if(++ read <= part1Length)
                    os1.write(smth);
                else
                    os2.write(smth);
            }
        }
    }

    static void mergeFile (File part1, File part2, File merged)throws IOException{
        try (InputStream is1 = new BufferedInputStream(new FileInputStream(part1));
             InputStream is2 = new BufferedInputStream(new FileInputStream(part2));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(merged, true))){
            int smth;
            while((smth = is1.read()) > 0){
                os.write(smth);
            }
            while((smth = is2.read()) > 0){
                os.write(smth);
            }
        }
    }

    public static void main (String[]args){
        File source = new File("src/hw9/source.txt");
        File destSplit1 = new File("src/hw9/destSplit1.txt");
        File destSplit2 = new File("src/hw9/destSplit2.txt");
        File merge = new File("src/hw9/destMerge.txt");
        try {
            splitFile(source,destSplit1,destSplit2,3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            mergeFile(destSplit1, destSplit2, merge);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
