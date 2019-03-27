package day08;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
GUI

    create database ...;
    create table ...;
    insert into ...;
    update ...;
    delete ...;
    select ...;
    drop table ...;
    drop database ...;
 */
public class MySqlCommandLine {

    private static final String URL = "jdbc:mysql:///?user=root&password=system&useSSL=false";
    private static Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private static Scanner scanner;
    private static SimpleDateFormat simpleDateFormat;

    public MySqlCommandLine() {
        scanner = new Scanner(System.in);
        getConnection();
        simpleDateFormat = new SimpleDateFormat("[YYYY-MM-dd HH:mm:ss] ");
    }

    public Connection getConnection() { // singleton 单例模式
        if (connection == null) {
            try {
                new Driver();
                connection = DriverManager.getConnection(URL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * DDL: create alter drop truncate
     * DML: insert update delete
     *
     * @param sql statement
     */
    public void update(String sql) {
        try {
            long start = System.currentTimeMillis();
            preparedStatement = connection.prepareStatement(sql);
            int rowAffected = preparedStatement.executeUpdate();
            long end = System.currentTimeMillis();

            System.out.print(simpleDateFormat.format(new Date(end)));
            System.out.println(rowAffected + " row affected in " + (end - start) + " ms");
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    /**
     * DQL: select
     *
     * @param sql statement
     */
    public void query(String sql) {
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData(); // 元数据
            System.out.println(resultSetMetaData.getColumnCount());            // 3
            System.out.println(resultSetMetaData.getColumnClassName(1));       // java.lang.Integer
            System.out.println(resultSetMetaData.getColumnDisplaySize(1));     // 11
            System.out.println(resultSetMetaData.getColumnLabel(1));           // id
            System.out.println(resultSetMetaData.getColumnName(1));            // id
            System.out.println(resultSetMetaData.getColumnType(1));            // 4
            System.out.println(resultSetMetaData.getColumnTypeName(1));        // INT
            while (resultSet.next()) {
                // TODO: 2019/3/27
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dispatch(String sql) {
        if (sql.toLowerCase().trim().startsWith("select")) {
            query(sql);
        } else {
            update(sql);
        }
    }

    public String getSQL() {
        System.out.print("mysql> ");
        String sql = scanner.nextLine();
        // TODO: 2019/3/27 sql.endsWith(";");
        return sql;
    }

    public static void main(String[] args) throws SQLException {
        MySqlCommandLine mySqlCommandLine = new MySqlCommandLine();
        String sql = mySqlCommandLine.getSQL();
        while (!sql.equalsIgnoreCase("quit")) {
            mySqlCommandLine.dispatch(sql);
            sql = mySqlCommandLine.getSQL();
        }


    }
}
