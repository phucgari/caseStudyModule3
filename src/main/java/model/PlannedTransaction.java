package model;

public class PlannedTransaction extends Transaction{
    private int id;
    private long money_amount;
    private String action;
    User user;

    public PlannedTransaction() {
    }

    public PlannedTransaction(int id, long money_amount, String action, User user) {
        this.id = id;
        this.money_amount = money_amount;
        this.action = action;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getMoney_amount() {
        return money_amount;
    }

    public void setMoney_amount(long money_amount) {
        this.money_amount = money_amount;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
