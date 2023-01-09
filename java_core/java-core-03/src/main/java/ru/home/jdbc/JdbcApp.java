package ru.home.jdbc;

import java.sql.*;
import java.util.Random;

public class JdbcApp {
    private Connection connection;
    private Statement statement;

    public static void main(String[] args) {
        final JdbcApp jdbcApp = new JdbcApp();
        jdbcApp.run();
    }

    private void run() {
        try {
            connect();
            dropTheTable();
            createTable();
//            System.out.println(Arrays.toString(jdbcApp.batchInsert()));
            insert("Tom", 90);
            insert("John", 80);
            insert("Steve", 70);
            insert("Billy", 60);
            insert("Bob", 50);
            showAll();
//            jdbcApp.selectByName("Tom' union select 1, sql, 1 from sqlite_master --"); // sql injection
            selectByName("Tom");
            update(1, "Frank", 100);
            selectById(1);
            deleteById(1);
//            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
//            try {
//                connection.rollback();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
        } finally {
            disconnect();
        }
    }

    private int[] batchInsert() throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement("insert into students (name, score) values (?, ?)")) {
            for (int i = 0; i < 10; i++) {
                ps.setString(1, "Bob");
                ps.setInt(2, new Random().nextInt(100));
                ps.addBatch();
            }
            return ps.executeBatch();
        }
    }

    private void createTable() throws SQLException {
        statement.executeUpdate("create table if not exists `students` (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "score INTEGER" +
                ")");
    }

    private void dropTheTable() throws SQLException {
        statement.execute("drop table if exists students");
//        PreparedStatement ps = connection.prepareStatement("drop table if exists ?");
//        ps.setString(1, name);
//        ps.executeQuery();
    }

    private void showAll() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from students");
        while (rs.next()) {
            System.out.printf("id: %d | name: %s | score: %d%n", rs.getInt(1), rs.getString(2), rs.getInt(3));
        }
//        PreparedStatement ps = connection.prepareStatement("select * from ?");
//        ps.setString(1, name);
//        ps.executeQuery();
    }

    private void insert(String name, Integer score) throws SQLException {
        try (final PreparedStatement ps = connection.prepareStatement("insert into students(name, score) values(?, ?)")) {
            ps.setString(1, name);
            ps.setInt(2, score);
            ps.executeUpdate();
//            connection.commit();
//        } catch (Exception e) {
//            connection.rollback();
//            throw e;
        }
//        statement.executeUpdate(String.format("insert into students (name, score) values ('%s', %s)", name, score));
    }

    private void update(Integer id, String name, Integer score) throws SQLException {
        try (final PreparedStatement ps = connection.prepareStatement("update students set name = ?, score = ? where id = ?")) {
            ps.setString(1, name);
            ps.setInt(2, score);
            ps.setInt(3, id);
            ps.executeUpdate();
        }
    }

    private void selectById(Integer id) throws SQLException {
        try (final PreparedStatement ps = connection.prepareStatement("select * from students where id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                System.out.printf("id: %d | name: %s | score: %d%n", rs.getInt(1), rs.getString(2), rs.getInt(3));
        }
//        final ResultSet rs = statement.executeQuery("select * from students where id = " + id);
//        if (rs.next()) {
//            System.out.printf("id: %d - name: %s - score: %d%n", rs.getInt(1), rs.getString(2), rs.getInt(3));
//        }
    }

    private void selectByName(String name) throws SQLException {
        try (final PreparedStatement ps = connection.prepareStatement("select * from students where name = ?")) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                System.out.printf("id: %d | name: %s | score: %d%n", rs.getInt(1), rs.getString(2), rs.getInt(3));
        }
//        final ResultSet rs = statement.executeQuery("select * from students where name = '" + name + "'");
//        while (rs.next())
//            System.out.printf("id: %d - name: %s - score: %d%n", rs.getInt(1), rs.getString(2), rs.getInt(3));
    }

    private void deleteById(Integer id) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement("delete from students where id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private void disconnect() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:javadb.db");
        connection.setAutoCommit(true);
        statement = connection.createStatement();
    }
}
