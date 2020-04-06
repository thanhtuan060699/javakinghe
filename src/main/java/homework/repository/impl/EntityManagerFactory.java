package homework.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class EntityManagerFactory {
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	public static Connection getConnection() {
		try {
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			return null;
		}
	}
}
