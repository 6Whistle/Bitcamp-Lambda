package com.erichgamma.api.user;

import com.erichgamma.api.enums.Messenger;
import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    private UserRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/erichgammadb",
                "erichgamma",
                "erichgammadb");
    }

    public List<User> findAll(){
        String sql = "SELECT * FROM users";
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
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
            pstmt.close();
            rs.close();
        } catch (SQLException e){
            System.out.println("SQL Exception Occurred");
        }
        return list;
    }

    public Messenger makeTable(){
        String sql = "CREATE TABLE users (" +
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
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
            return Messenger.SUCCESS;
        } catch (SQLException e) {
            return Messenger.FAIL;
        }
    }

    public Messenger removeTable(){
        String sql = "DROP TABLE users";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.execute();
            pstmt.close();
            return Messenger.SUCCESS;
        } catch (SQLException e) {
            return Messenger.FAIL;
        }
    }


    public Messenger userExistsByUsername(String username) {
        String sql = "SELECT username FROM users WHERE username=?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            Messenger msg = rs.next() ? Messenger.SUCCESS : Messenger.FAIL;
            rs.close();
            pstmt.close();
            return msg;
        } catch (SQLException e){
            System.out.println("SQL Exception Occurred In userexistsByUsername()");
            return Messenger.SQL_ERROR;
        }
    }

    public Messenger save(User user) {
        String sql = "INSERT INTO users(username, password, name, phone, job, height, weight) " +
                     "VALUES(?, ?, ?, ?, ?, ?, ?)";
        Messenger msg;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getPhone());
            pstmt.setString(5, user.getJob());
            pstmt.setString(6, String.valueOf(user.getHeight()));
            pstmt.setString(7, String.valueOf(user.getWeight()));
            pstmt.executeUpdate();
            pstmt.close();
            return Messenger.SUCCESS;
        } catch (SQLException e){
            return Messenger.SQL_ERROR;
        }
    }

    public Messenger login(User user) {
        String sql = "SELECT username FROM users WHERE username=? AND password=?";
        Messenger msg;
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            ResultSet rs = pstmt.executeQuery();
            msg = rs.next() ? Messenger.SUCCESS : Messenger.FAIL;
            rs.close();
            pstmt.close();
        } catch (SQLException e){
            msg = Messenger.SQL_ERROR;
        }
        return msg;
    }
}
