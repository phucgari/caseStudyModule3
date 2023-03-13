package model;

import java.time.LocalDate;

public class PlannedTransaction{
    private int id;
    private String action;
    private int money_Amount;
    private User user_id;

    public PlannedTransaction() {
    }

    public PlannedTransaction(int id, String action, int money_Amount, User user_id) {
        this.id = id;
        this.action = action;
        this.money_Amount = money_Amount;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getMoney_Amount() {
        return money_Amount;
    }

    public void setMoney_Amount(int money_Amount) {
        this.money_Amount = money_Amount;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
}
