package model;

import java.time.LocalDate;

public class Transaction {
    private int id;
    private String name;
    private LocalDate time;
    private int money_Amount;
    private String action;
    private Wallet wallet_id;

    public Transaction() {
    }

    public Transaction(int id, String name, LocalDate time, int money_Amount, String action, Wallet wallet_id) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.money_Amount = money_Amount;
        this.action = action;
        this.wallet_id = wallet_id;
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

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public int getMoney_Amount() {
        return money_Amount;
    }

    public void setMoney_Amount(int money_Amount) {
        this.money_Amount = money_Amount;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Wallet getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(Wallet wallet_id) {
        this.wallet_id = wallet_id;
    }
}
