package model;

public class PlannedTransaction{
    private int id;
    private String action;
    private long money_Amount;
    private User user_id;

    public PlannedTransaction() {
    }

    public PlannedTransaction(String action, long money_Amount, User user_id) {
        this.action = action;
        this.money_Amount = money_Amount;
        this.user_id = user_id;
    }

    public PlannedTransaction(int id, String action, long money_Amount, User user_id) {
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

    public long getMoney_Amount() {
        return money_Amount;
    }

    public void setMoney_Amount(long money_Amount) {
        this.money_Amount = money_Amount;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "PlannedTransaction{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", money_Amount=" + money_Amount +
                ", user_id=" + user_id +
                '}';
    }
}
