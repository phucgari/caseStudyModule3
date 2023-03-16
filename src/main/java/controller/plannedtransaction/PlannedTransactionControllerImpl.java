package controller.plannedtransaction;

import model.PlannedTransaction;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class PlannedTransactionControllerImpl implements PlannedTransactionController{
    private static final String DELETE_PLANNED_TRANSACTION = " DELETE FROM planned_transaction WHERE id=?";
    private final String PLANNED_TRANSACTION_ON_DEMAND=
            "select planned_transaction.* " +
            "from planned_transaction " +
            "inner join user on user.id=planned_transaction.user_id "+
            "where user_id= ? and money_amount between ? and ? ";
    private final String CREATE_PLANNED_TRANSACTION="insert into planned_transaction (action,money_amount,user_id) " +
            "values (?,?,?)";
    private final String UPDATE_PLANNED_TRANSACTION="update planned_transaction set action=?,money_amount=? where id=?";
    private final String FIND_PLANNED_TRANSACTION_BY_ID="select * from planned_transaction where id=?";
    @Override
    public Collection<PlannedTransaction> showAll() {
        return null;
    }
    public ArrayList<PlannedTransaction> showPlannedTransactionOnDemand(int user_id, long moneyStart,long moneyEnd){
        //function 19
        ArrayList<PlannedTransaction> result=new ArrayList<>();
        try(Connection connection=connector.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(PLANNED_TRANSACTION_ON_DEMAND)) {
            preparedStatement.setInt(1,user_id);
            preparedStatement.setLong(2,moneyStart);
            preparedStatement.setLong(3,moneyEnd);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                PlannedTransaction plannedTransaction = generatePlannedTransaction(resultSet);
                result.add(plannedTransaction);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private static PlannedTransaction generatePlannedTransaction(ResultSet resultSet) throws SQLException {
        int id= resultSet.getInt("id");
        long money_amount= resultSet.getLong("money_amount");
        String action= resultSet.getString("action");
        User user=new User(resultSet.getInt("user_id"));
        PlannedTransaction plannedTransaction=new PlannedTransaction(id,action,money_amount,user);
        return plannedTransaction;
    }

    @Override
    public void create(PlannedTransaction object) {
        //function 20
        try(Connection connection=connector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(CREATE_PLANNED_TRANSACTION)) {
            preparedStatement.setString(1,object.getAction());
            preparedStatement.setLong(2,object.getMoney_Amount());
            preparedStatement.setInt(3,object.getUser_id().getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PlannedTransaction showByIndex(int index) {
        try(Connection connection=connector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(FIND_PLANNED_TRANSACTION_BY_ID)) {
            preparedStatement.setInt(1,index);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt("id");
            String action = resultSet.getString("action");
            long moneyAmount = resultSet.getLong("money_amount");
            User userId = new User(resultSet.getInt("user_id"));
            return new PlannedTransaction(id, action, moneyAmount, userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(PlannedTransaction object) {
        //function 21
        try(Connection connection=connector.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(UPDATE_PLANNED_TRANSACTION)) {
            preparedStatement.setString(1,object.getAction());
            preparedStatement.setLong(2,object.getMoney_Amount());
            preparedStatement.setInt(3,object.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int index) {
        try(Connection connection=connector.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(DELETE_PLANNED_TRANSACTION)) {
            preparedStatement.setInt(1,index);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //function 18
    }
}
