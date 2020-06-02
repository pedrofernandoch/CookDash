package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {

	private static final String conn = "jdbc:sqlite:CookDash.sqlite";

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

}
