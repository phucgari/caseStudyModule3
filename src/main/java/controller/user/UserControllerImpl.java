package controller.user;

import model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserControllerImpl implements UserController {
    private static final String CREATE_SQL = "insert into users (login_name, login_password, email, picture_url, gender, user_name, user_dob, card_id, phone, address) values(?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_USER_BY_ID = "select id,login_name, login_password, email, picture_url, gender, user_name, user_dob, card_id, phone, address form users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set login_name = ?, login_password = ?, email = ?, picture_url = ?, gender = ?, user_name = ?, user_dob = ?, card_id = ?, phone = ?, address = ? where id = ?;";

    public UserControllerImpl() {
    }

    @Override
    public List<User> showAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String login_name = resultSet.getString("login_name");
                String login_password = resultSet.getString("login_password");
                String email = resultSet.getString("email");
                String picture_url = resultSet.getString("picture_url");
                boolean gender = resultSet.getBoolean("gender");
                String user_name = resultSet.getString("user_name");
                LocalDate user_dob = resultSet.getDate("user_dob").toLocalDate();
                String card_id = resultSet.getString("card_id");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                users.add(new User(id, login_name, login_password, email, picture_url, gender, user_name, user_dob, card_id, phone, address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public void create(User user) {
        //function 1
        System.out.println(CREATE_SQL);
        try (Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SQL)) {
            preparedStatement.setString(1, user.getLogin_name());
            preparedStatement.setString(2, user.getLogin_password());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPicture_url());
            preparedStatement.setBoolean(5, user.isGender());
            preparedStatement.setString(6, user.getUser_name());
            preparedStatement.setDate(7, Date.valueOf(user.getUser_dob()));
            preparedStatement.setString(8, user.getCard_id());
            preparedStatement.setLong(9, Long.parseLong(user.getPhone()));
            preparedStatement.setString(10, user.getAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    @Override
    public User showByIndex(int index) {
        User user = null ;
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);){
            preparedStatement.setInt(1,index);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String login_name = resultSet.getString("login_name");
                String login_password = resultSet.getString("login_password");
                String email = resultSet.getString("email");
                String picture_url = resultSet.getString("picture_url");
                boolean gender = resultSet.getBoolean("gender");
                String user_name = resultSet.getString("user_name");
                LocalDate user_dob = resultSet.getDate("user_dob").toLocalDate();
                String card_id = resultSet.getString("card_id");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                user = new User(id, login_name, login_password, email, picture_url, gender, user_name, user_dob, card_id, phone, address);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }
    @Override
    public void update(User user) {
        //function 2
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);){
                preparedStatement.setString(1, user.getLogin_name());
                preparedStatement.setString(2, user.getLogin_password());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPicture_url());
                preparedStatement.setBoolean(5, user.isGender());
                preparedStatement.setString(6, user.getUser_name());
                preparedStatement.setDate(7, Date.valueOf(user.getUser_dob()));
                preparedStatement.setString(8, user.getCard_id());
                preparedStatement.setLong(9, Long.parseLong(user.getPhone()));
                preparedStatement.setString(10, user.getAddress());
                preparedStatement.setInt(11,user.getId());
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public void delete(int index) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);) {
            preparedStatement.setInt(1, index);
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
