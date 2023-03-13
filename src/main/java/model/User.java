package model;

import java.time.LocalDate;
import java.util.Date;

public class User {
    private int id;
    private String login_name;
    private String login_password;
    private String email;
    private String picture_url;
    private boolean gender;
    private String user_name;
    private String user_dob;
    private String card_id;
    private String phone;
    private String address;


    public User() {
    }

    public User(int id, String login_name, String login_password, String email, String picture_url, boolean gender, String user_name, String user_dob, String card_id, String phone, String address) {
        this.id = id;
        this.login_name = login_name;
        this.login_password = login_password;
        this.email = email;
        this.picture_url = picture_url;
        this.gender = gender;
        this.user_name = user_name;
        this.user_dob = user_dob;
        this.card_id = card_id;
        this.phone = phone;
        this.address = address;
    }

    public User(String login_name, String login_password) {
        this.login_name = login_name;
        this.login_password = login_password;
    }

    public User(String login_name, String login_password, String email, String picture_url, boolean gender, String user_name, String user_dob, String card_id, String phone, String address) {
        this.login_name = login_name;
        this.login_password = login_password;
        this.email = email;
        this.picture_url = picture_url;
        this.gender = gender;
        this.user_name = user_name;
        this.user_dob = user_dob;
        this.card_id = card_id;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
