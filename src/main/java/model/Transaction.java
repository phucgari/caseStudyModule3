package model;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {
    private int id;
    private LocalDate time;
    private long money_amount;
    private String action;
    private Wallet wallet;

    public Transaction() {
    }

    public Transaction(int id, LocalDate time, long money_amount, String action, Wallet wallet) {
        this.id = id;
        this.time = time;
        this.money_amount = money_amount;
        this.action = action;
        this.wallet = wallet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
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

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
