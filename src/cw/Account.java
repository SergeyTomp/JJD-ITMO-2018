package cw;

public class Account {
    int amount;
    User client;

    public Account(int amount, User client) {
        this.amount = amount;
        this.client = client;
    }
}
