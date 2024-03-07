package post;

import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    private Connection connection;

    private PostRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/erichgammadb",
                "erichgamma",
                "erichgammadb"
        );
    }

    public List<?> getPostList() throws SQLException {
        String sql = "SELECT * FROM posts";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<String> list = new ArrayList<>();
        if(resultSet.next())
            do list.add("ID : " + resultSet.getInt(1) +
                    ", TITLE : " + resultSet.getString(2) +
                    ", CONTENT : " + resultSet.getString(3) +
                    ", WRITER : " + resultSet.getString(4));
            while(resultSet.next());
        else    list.add("NO DATA");
        resultSet.close();
        preparedStatement.close();
        return list;
    }
}
