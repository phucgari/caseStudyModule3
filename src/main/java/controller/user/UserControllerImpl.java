package controller.user;
import model.User;
import java.sql.*;
import java.util.Collection;


public class UserControllerImpl implements UserController{

    private static final String SELECT_USER_BY_ID = "select * from user where user.id =?";
    private static final String CREATE_USERS = "INSERT INTO user (user.login_name, user.login_password, user.email, " +
            "user.picture_url, user.gender, user.user_name, user.user_dob, user.card_id, user.phone, user.address) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_USERS_SQL = "update user set user.login_name = ?, user.login_password = ?, user.email = ?," +
            "user.picture_url = ?, user.gender = ?, user.user_name = ?, user.user_dob = ?, user.card_id = ?, user.phone = ?, user.address where user.id = ?;";
    private static final String DELETE_USERS_SQL = "update user set user.disable=1 WHERE user.id=?;";
    private static final String SELECT_USER = "select * from user where user.login_name = ? and user.login_password = ? ";


    public UserControllerImpl() {
    }

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

            if (user.getEmail() !="" ){
                preparedStatement.setString(3, user.getEmail());
            } else {
                preparedStatement.setString(3, null);
            }

            if (user.getPicture_url() != "" ){
                preparedStatement.setString(4, user.getPicture_url());
            } else {
                preparedStatement.setString(4, null);
            }

            preparedStatement.setBoolean(5, user.isGender());
            preparedStatement.setString(6, user.getUser_name());
            preparedStatement.setString(7, user.getUser_dob());

            if (user.getCard_id() != "" ){
                preparedStatement.setString(8, user.getCard_id());
            } else {
                preparedStatement.setString(8, null);
            }

            preparedStatement.setString(9, user.getPhone());

            if (user.getAddress() != "" ){
                preparedStatement.setString(10, user.getAddress());
            } else {
                preparedStatement.setString(10, null);
            }
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
                user = new User(index, login_name, login_password, email, picture_url, gender, user_name,
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

            if (user.getEmail() !="" ){
                preparedStatement.setString(3, user.getEmail());
            } else {
                preparedStatement.setString(3, null);
            }

            if (user.getPicture_url() != "" ){
                preparedStatement.setString(4, user.getPicture_url());
            } else {
                preparedStatement.setString(4, null);
            }

            preparedStatement.setBoolean(5, user.isGender());
            preparedStatement.setString(6, user.getUser_name());
            preparedStatement.setString(7, user.getUser_dob());

            if (user.getCard_id() != "" ){
                preparedStatement.setString(8, user.getCard_id());
            } else {
                preparedStatement.setString(8, null);
            }

            preparedStatement.setString(9, user.getPhone());

            if (user.getAddress() != "" ){
                preparedStatement.setString(10, user.getAddress());
            } else {
                preparedStatement.setString(10, null);
            }
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
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User login(String login_name, String login_password) {
        try ( Connection connection = connector.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER);) {
            preparedStatement.setString(1, login_name);
            preparedStatement.setString(2, login_password);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
