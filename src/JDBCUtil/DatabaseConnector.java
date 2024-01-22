package JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	private static String url = "jdbc:mysql://localhost/coffemanager";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, "viet", "123456789");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
		return connection;
    }
}
