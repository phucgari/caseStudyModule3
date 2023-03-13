package model;

public class Wallet {
    private int id;
    private String name;
    private long balance;
    private User user;

    public Wallet() {
    }

    public Wallet(int id, String name, long balance, User user) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
