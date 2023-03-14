package model;

public class User {
    private int id;
    private String name;
    private String login_name;
    private String login_password;
    private String email;
    private String picture_url;
    private boolean gender;
    private String user_dob;
    private String card_id;
    private String phone;

    public User() {
    }

    public User(int id, String name, String login_name, String login_password, String email, String picture_url, boolean gender, String user_dob, String card_id, String phone) {
        this.id = id;
        this.name = name;
        this.login_name = login_name;
        this.login_password = login_password;
        this.email = email;
        this.picture_url = picture_url;
        this.gender = gender;
        this.user_dob = user_dob;
        this.card_id = card_id;
        this.phone = phone;
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

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getLogin_password() {
        return login_password;
    }

    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getUser_dob() {
        return user_dob;
    }

    public void setUser_dob(String user_dob) {
        this.user_dob = user_dob;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
