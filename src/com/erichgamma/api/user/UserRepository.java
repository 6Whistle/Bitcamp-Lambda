package com.erichgamma.api.user;

import com.erichgamma.api.enums.Messenger;
import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    @Getter
    private static final UserRepository instance;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private UserRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/erichgammadb",
                "erichgamma",
                "erichgammadb");
        pstmt = null;
        rs = null;
    }

    public List<User> findAll(){
        String sql = "SELECT * FROM users";
        List<User> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next())
                do list.add(User.builder()
                        .username(rs.getString(2))
                        .password(rs.getString(3))
                        .name(rs.getString(4))
                        .phone(rs.getString(5))
                        .job(rs.getString(6))
                        .height(Double.parseDouble(rs.getString(7)))
                        .weight(Double.parseDouble(rs.getString(8)))
                        .build());
                while (rs.next());
            else System.out.println("No Data");;
        } catch (SQLException e){
            System.out.println("SQL Exception Occurred");
        }
        return list;
    }

    public Boolean checkUsersTable(){
        String sql = "SHOW TABLES LIKE 'users'";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred in checkUserTable");
            return false;
        }
    }

    public Messenger makeTable(){
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "                       id INT AUTO_INCREMENT PRIMARY KEY," +
                "                       username VARCHAR(20) NOT NULL," +
                "                       password VARCHAR(20) NOT NULL," +
                "                       name VARCHAR(20)," +
                "                       phone VARCHAR(20)," +
                "                       job VARCHAR(20)," +
                "                       height VARCHAR(20)," +
                "                       weight VARCHAR(20)" +
                "   )";
        try {
            pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e) {
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }

    public Messenger removeTable(){
        String sql = "DROP TABLE IF EXISTS users";
        try {
            pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e) {
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }


    public Messenger userExistsByUsername(String username) {
        String sql = "SELECT username FROM users WHERE username=?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            return rs.next() ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }

    public Messenger save(User user) {
        String sql = "INSERT INTO users(username, password, name, phone, job, height, weight) " +
                     "VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getPhone());
            pstmt.setString(5, user.getJob());
            pstmt.setString(6, String.valueOf(user.getHeight()));
            pstmt.setString(7, String.valueOf(user.getWeight()));

            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }

    public Messenger login(User user) {
        String sql = "SELECT username FROM users WHERE username=? AND password=?";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            rs = pstmt.executeQuery();
            return rs.next() ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }


}
