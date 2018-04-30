package hw10.EncryptionDecorator;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;



public class CryptedOutputStream extends FilterOutputStream{
    LinkedList<Byte> password;
    public CryptedOutputStream(OutputStream out, String pass) {
        super(out);
        byte[] passBytes = pass.getBytes();
        password = new LinkedList();
        for (Byte b : passBytes){
            password.add(b);
        }
    }

    @Override
    public void write(int b) throws IOException {
        int res = b ^ password.getFirst();
        password.addLast(password.getFirst());
        super.write(res);
    }
}
