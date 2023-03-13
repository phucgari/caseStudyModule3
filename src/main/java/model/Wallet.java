package model;

public class Wallet {
    private int id;
    private String name;
    private int balance;
    private User user_id;

    public Wallet() {
    }

    public Wallet(int id, String name, int balance, User user_id) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.user_id = user_id;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
}
