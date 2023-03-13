package model;

import java.time.LocalDate;

public class PlannedTransaction extends Transaction{
    private int id;
    private String action;
    private int money_Amount;
    private User user_id;

    public PlannedTransaction(int id, String action, int money_Amount, User user_id) {
        this.id = id;
        this.action = action;
        this.money_Amount = money_Amount;
        this.user_id = user_id;
    }

    public PlannedTransaction(int id, String name, LocalDate time, int money_Amount, String action, Wallet wallet_id, int id1, String action1, int money_Amount1, User user_id) {
        super(id, name, time, money_Amount, action, wallet_id);
        this.id = id1;
        this.action = action1;
        this.money_Amount = money_Amount1;
        this.user_id = user_id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getAction() {
        return action;
    }

    @Override
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public int getMoney_Amount() {
        return money_Amount;
    }

    @Override
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
