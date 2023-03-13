package model;

public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private String picture_url;
    private boolean gender;
    private String user_dob_date;
    private String CCCD;
    private String phone;

    public User() {
    }

    public User(int id, String name, String password, String email, String picture_url, boolean gender, String user_dob_date, String CCCD, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.picture_url = picture_url;
        this.gender = gender;
        this.user_dob_date = user_dob_date;
        this.CCCD = CCCD;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getUser_dob_date() {
        return user_dob_date;
    }

    public void setUser_dob_date(String user_dob_date) {
        this.user_dob_date = user_dob_date;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
