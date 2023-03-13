package controller.user;

import connector.Connector;
import model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserControllerImpl implements UserController{

    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String CREATE_USERS = "INSERT INTO user (login_name, login_password, email, " +
            "picture_url, gender, user_name, user_dob, card_id, phone, address) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    @Override
    public Collection<User> showAll() {
        try ( Connection connection = connector.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet rs = preparedStatement.executeQuery();
                int id = rs.getInt("id");
                String login_name = rs.getString("login_name");
                String login_password = rs.getString("login_password");
                String email = rs.getString("email");
                String picture_url = rs.getString("picture_url");
                boolean gender = rs.getBoolean("gender");
                String user_name = rs.getString("user_name");
                String user_dob = rs.getString("user_dob");
                String card_id = rs.getString("card_id");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void create(User user) {
        //function 1
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USERS)) {
            preparedStatement.setString(1, user.getLogin_name());
            preparedStatement.setString(2, user.getLogin_password());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPicture_url());
            preparedStatement.setBoolean(5, user.isGender());
            preparedStatement.setString(6, user.getUser_name());
            preparedStatement.setString(7, user.getUser_dob());
            preparedStatement.setString(8, user.getCard_id());
            preparedStatement.setString(9, user.getPhone());
            preparedStatement.setString(10, user.getAddress());
            preparedStatement.execute();
        } catch (SQLException e){
           e.printStackTrace();
        }
    }

    @Override
    public User showByIndex(int index) {
        return null;
    }


    @Override
    public void update(User user) {
        //function 2
    }

    @Override
    public void delete(int index) {

    }
}
