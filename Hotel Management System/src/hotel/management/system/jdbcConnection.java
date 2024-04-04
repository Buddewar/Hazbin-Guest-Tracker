package hotel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcConnection{

    Connection connection;
    Statement statement;

    public jdbcConnection()
    {
        try
        {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root","86579");
            statement= connection.createStatement();
        }catch (Exception E)
        {
            E.printStackTrace();
        }

    }
}