package controller.wallet;


import model.User;
import model.Wallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WalletControllerImpl implements WalletController{
    private static final String GET_ALL_WALLET=
            "select wallet.id,wallet.name,wallet.balance,wallet.user_id,user.login_name,user.login_password " +
            "from wallet " +
            "left join user on wallet.user_id=user.id where wallet.disable=0";
    private static final String GET_ALL_WALLET_BY_ID=
            "select wallet.id,wallet.name,wallet.balance,wallet.user_id,user.login_name,user.login_password " +
            "from wallet " +
            "left join user on wallet.user_id=user.id where wallet.disable=0 and wallet.user_id=?";
    private static final String CREATE_A_WALLET="insert into wallet(name,balance,user_id) values (?,?,?)";
    private static final String UPDATE_A_WALLET="update wallet set name=?,balance=? where id=?";
    private static final String DELETE_A_WALLET="update wallet set disable=1 WHERE id=?";
    private static final String FIND_A_WALLET_BY_ID="select * from wallet where id=?";

    @Override
    public ArrayList<Wallet> showAll() {
        // function 10+11
        ArrayList<Wallet> result=new ArrayList<>();
        try(Connection connection=connector.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(GET_ALL_WALLET)) {
            ResultSet resultset=preparedStatement.executeQuery();
            while (resultset.next()){
                Wallet wallet = getWallet(resultset);
                result.add(wallet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public ArrayList<Wallet> showAllWalletById(int id){
        ArrayList<Wallet> result=new ArrayList<>();
        try(Connection connection=connector.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(GET_ALL_WALLET_BY_ID)) {
            preparedStatement.setInt(1,id);
            ResultSet resultset=preparedStatement.executeQuery();
            while (resultset.next()){
                Wallet wallet = getWallet(resultset);
                result.add(wallet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private Wallet getWallet(ResultSet resultset) throws SQLException {
        int id= resultset.getInt("id");
        String name = resultset.getString("name");
        long balance= resultset.getLong("balance");
        User user=generateUser(resultset);
        Wallet wallet=new Wallet(id,name,balance,user);
        return wallet;
    }

    private User generateUser(ResultSet resultset) {
        try {
            int id=resultset.getInt("user_id");
            String login_name=resultset.getString("login_name");
            String login_password=resultset.getString("login_password");
            return new User(id,login_name,login_password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void create(Wallet object) {
        // function 24
        try(Connection connection=connector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(CREATE_A_WALLET)) {
            preparedStatement.setString(1,object.getName());
            preparedStatement.setLong(2,object.getBalance());
            preparedStatement.setInt(3,object.getUser_id().getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Wallet showByIndex(int index) {
        Wallet result;
        try(Connection connection=connector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(FIND_A_WALLET_BY_ID)) {
            preparedStatement.setInt(1,index);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            long balance = resultSet.getLong("balance");
            User userId = new User(resultSet.getInt("user_id"));
            result=new Wallet(id, name, balance, userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void update(Wallet object) {
        //function 22
        try(Connection connection=connector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_A_WALLET)){
            preparedStatement.setString(1,object.getName());
            preparedStatement.setLong(2,object.getBalance());
            preparedStatement.setInt(3,object.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int index) {
        //function 23
        try(Connection connection=connector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(DELETE_A_WALLET)){
            preparedStatement.setInt(1,index);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
