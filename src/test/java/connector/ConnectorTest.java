package connector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectorTest {
    String jdbcURL = "jdbc:mysql://localhost:3306/casestudy_demo?";
    String jdbcUsername = "root";
    String jdbcPassword = "123456";
    @Test
    void testConnector(){
        Connector connector=new Connector(jdbcURL,jdbcUsername,jdbcPassword);
        connector.getConnection();
    }

}