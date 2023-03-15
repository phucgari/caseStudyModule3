package model;

public class Wallet {
    private int id;
    private String name;
    private long balance;
    private User user_id;

    public Wallet(String walletId) {
    }

    public Wallet(int id) {
        this.id = id;
    }

    public Wallet(int id, String name, long balance, User user_id) {
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

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Wallet(String name, long balance, User user_id) {
        this.name = name;
        this.balance = balance;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", user_id=" + user_id +
                '}';
    }
}
