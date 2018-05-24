package cw;

public class Main {
    public static void main(String[] args) {
        Bank newBank = new Bank();
        for (int t = 0; t < 10; t++ ) {
            newBank.accList.add(new Account(1000000,
                    new User(
                    1000000 + t * 10,
                    "Клиент #" + (100000 + t * 10)),
                    78000 + t));
        }
        for (int t = 0; t < 10; t++){
            newBank.getQueue().add(new Transaction(
                    5000000 + t*10,
                    newBank.accList.get(t),
                    newBank.accList.get(9 - t),
                    t%2 ==0 ? 100*t+100 : 500*t, newBank));
        }
        int cpus = Runtime.getRuntime().availableProcessors();
        for (int t = 0; t < cpus; t++) {
            new Thread(new Processor(newBank)).start();
        }
    }
}
