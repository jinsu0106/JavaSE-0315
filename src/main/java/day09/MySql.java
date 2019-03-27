
package day09;

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
public class MySql {

    private static final String URL = "jdbc:mysql:///?user=root&password=123&useSSL=false";
    private static Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private static Scanner scanner;
    private static SimpleDateFormat simpleDateFormat;

    public MySql() {
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
            System.out.println("SQL Error: " + e.getMessage());
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
            int columnCount = resultSetMetaData.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                System.out.print(resultSetMetaData.getColumnLabel(i + 1) + " ");
            }
            System.out.println("\n----------------------");
            while (resultSet.next()) {
                for (int i = 0; i < columnCount; i++) {
                    System.out.print(resultSet.getString(i + 1) + " ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
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
        String line = scanner.nextLine();
        StringBuilder sql = new StringBuilder(line);
        while (!line.endsWith(";")) {
            System.out.print("    -> ");
            line = scanner.nextLine();
            sql.append(line);
        }
        return sql.toString();
    }

    public static void main(String[] args) throws SQLException {
        MySql mySqlCommandLine = new MySql();
        String sql = mySqlCommandLine.getSQL();
        System.out.println(sql);
        while (!sql.equalsIgnoreCase("quit")) {
            mySqlCommandLine.dispatch(sql);
            sql = mySqlCommandLine.getSQL();
        }

        /*
        mySqlCommandLine.getConnection();
        // 用户在登录表单填写的值
        String username = "' or 'a'='a";   // SQL Injection 注入
        String password = "' or 'a'='a";
        String sql1 = "select * from db_test.user where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet1 = preparedStatement.executeQuery();
        System.out.println(resultSet1.next()); // true 用户可以登录
        String sql2 = "select * from db_test.user where username = '" + username + "' and password = '" + password + "'";
        System.out.println(sql2);
        Statement statement = connection.createStatement();
        ResultSet resultSet2 = statement.executeQuery(sql2);
        System.out.println(resultSet2.next());
        */
    }
}
