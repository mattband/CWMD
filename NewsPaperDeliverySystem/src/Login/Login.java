package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    private String username;
    private String password;
    private Connection connection;

    public Login(String username, String password, Connection connection) {
        this.username = username;
        this.password = password;
        this.connection = connection;
    }

    public String authenticate() throws SQLException {
        String query = "SELECT user_type FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("user_type");
                }
            }
        }
        return null; // Authentication failed
    }
}

