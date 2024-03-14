package com.erichgamma.api.auth;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthRepository {
    private static final AuthRepository instance;

    static {
        try {
            instance = new AuthRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection connection;

    private AuthRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/erichgammadb",
                "erichgamma",
                "erichgammadb");
    };

    public static AuthRepository getInstance(){
        return instance;
    }

    public String test(){
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {
        String sql = "select * from board";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<String> list = new ArrayList<>();
        if(resultSet.next())
            do System.out.printf("ID : %d, Title : %s, Writer : %s, Content : %s\n",
                    resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4));
            while(resultSet.next());
        else System.out.println("데이터가 없습니다.");
        resultSet.close();
        preparedStatement.close();
        return list;
    }
}
