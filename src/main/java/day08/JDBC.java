
package day08;





import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// JDBC - Java DataBase Connectivity
public class JDBC {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306";
    private static final String User = "root";
    private static final String PASSWORD = "123";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. Driver
//        new Driver();
        Class.forName("com.mysql.jdbc.Driver");
        // 2. Connection
        Connection connection = DriverManager.getConnection(URL, User, PASSWORD);
        // 3. PreparedStatement
        String sql = "insert into db_test.user value (null, ?, md5(?))";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "Tom");
        preparedStatement.setString(2, "123");
        // 4.1 p.executeUpdate(); // DML
        preparedStatement.executeUpdate();
        // 4.2 p.executeQuery(); // DQL
        // 5. *.close();
        preparedStatement.close();
        connection.close();
        System.out.println("done.");
    }
}