package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBCUtil.DatabaseConnector;

public class login {
    private String username;
    private String password;
    private UserType userType;

    public enum UserType {
        ADMIN,
        EMPLOYEE
    }

    public login(String username, String password, UserType userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public boolean authenticate(String enteredUsername, String enteredPassword) {
        // Kết nối đến MySQL và kiểm tra xác thực
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM loginadmin WHERE username = ? AND password = ? AND user_type = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, enteredUsername);
                preparedStatement.setString(2, enteredPassword);
                preparedStatement.setString(3, userType.name());

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // Trả về true nếu có bản ghi khớp
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public UserType getUserType() {
        return userType;
    }
}
