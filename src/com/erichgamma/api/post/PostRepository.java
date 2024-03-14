package com.erichgamma.api.post;

import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostRepository {
    @Getter
    private static PostRepository instance;

    static {
        try {
            instance = new PostRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final Connection conn;

    private PostRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/erichgammadb",
                "erichgamma",
                "erichgammadb");
    }

    public List<Post> findAll(){
        try {
            String sql = "SELECT * FROM posts";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<Post> list = new ArrayList<>();

            if(rs.next())
                do list.add(Post.builder()
                        .id((long) rs.getInt(1))
                        .title(rs.getString(2))
                        .content(rs.getString(3))
                        .writer(rs.getString(4))
                        .registerDate(rs.getString(5))
                        .build());
                while(rs.next());
            else    list.add(Post.builder().build());
            rs.close();
            pstmt.close();
            return list;
        } catch (SQLException e) {
            System.err.println("Error Occurred");
            return new ArrayList<Post>();
        }
    }
}
