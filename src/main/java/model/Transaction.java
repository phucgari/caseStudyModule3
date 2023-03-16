package model;

import java.sql.Date;
import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private LocalDateTime time;
    private Long money_Amount;
    private String action;
    private Wallet wallet_id;

    public Transaction() {
    }

    public Transaction(int id, LocalDateTime time, Long money_Amount, String action, Wallet wallet_id) {
        this.id = id;
        this.time = time;
        this.money_Amount = money_Amount;
        this.action = action;
        this.wallet_id = wallet_id;
    }

    public Transaction(LocalDateTime time, Long money_Amount, String action, Wallet wallet_id) {
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Long getMoney_Amount() {
        return money_Amount;
    }

    public void setMoney_Amount(Long money_Amount) {
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
