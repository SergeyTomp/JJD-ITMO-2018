package hw10.EncryptionDecorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

public class CryptedInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    LinkedList <Byte> password;
    public CryptedInputStream(InputStream in, String pass) {
        super(in);
        byte[] passBytes = pass.getBytes();
        password = new LinkedList();
        for (Byte b : passBytes){
            password.add(b);
        }
    }
    @Override
    public int read() throws IOException {
        int res;
        if((res = super.read())!= -1){
            res = res ^ password.getFirst();
            password.addLast(password.getFirst());
            return res;
        }
        return -1;
    }

    @Override
    public int read(byte[] arr) throws IOException {
        int tmp = super.read(arr);
        for (int i = 0; i < arr.length; i++){
            arr[i] = (byte) (arr[i] ^ password.getFirst());
            password.addLast(password.getFirst());
        }
        return tmp;

    }

    @Override
    public int read(byte[] arr, int off, int len) throws IOException {
        int tmp = super.read(arr, off, len);
        for (int i = off; i < arr.length; i++){
            arr[i] = (byte) (arr[i] ^ password.getFirst());
            password.addLast(password.getFirst());
        }
        return tmp;
    }
}

