package connector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectorTest {
    String jdbcURL = "jdbc:mysql://localhost:3306/casestudy_demo?";
    String jdbcUsername = "root";
    String jdbcPassword = "123456";
    Connector connector=new Connector(jdbcURL,jdbcUsername,jdbcPassword);
    @Test
    void testConnector(){
        connector.getConnection();
    }
    @Test
    void testFlush(){
        connector.flush();
    }

}