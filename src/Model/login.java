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

    public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



    public UserType getUserType() {
        return userType;
    }
}
