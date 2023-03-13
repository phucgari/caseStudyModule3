package controller.user;
import model.User;
import java.sql.*;
import java.util.Collection;


public class UserControllerImpl implements UserController{

    private static final String SELECT_USER_BY_ID = "select id,login_name, login_password, email, \" +\n" +
            "            \"picture_url, gender, user_name, user_dob, card_id, phone, address from users where id =?";
    private static final String CREATE_USERS = "INSERT INTO user (login_name, login_password, email, " +
            "picture_url, gender, user_name, user_dob, card_id, phone, address) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_USERS_SQL = "update user set login_name = ?, login_password = ?, email = ?," +
            "picture_url = ?, gender = ?, user_name = ?, user_dob = ?, card_id = ?, phone = ?, address where id = ?;";
    private static final String DELETE_USERS_SQL = "delete from user where id = ?;";
    @Override
    public Collection<User> showAll() {
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
        User user = null;
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, index);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
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
                user = new User(login_name, login_password, email, picture_url, gender, user_name,
                        user_dob, card_id, phone, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public void update(User user) {
        //function 2
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);) {
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
            preparedStatement.setInt(11, user.getId());
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int index) {
        try ( Connection connection = connector.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);) {
            preparedStatement.setInt(1, index);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
