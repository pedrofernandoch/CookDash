package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	private static void initialize() {
		Connection conn = null;
		Statement st = null;
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void showAllTables() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = SQLiteConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT \n" + "    name\n" + "FROM \n" + "    sqlite_master \n" + "WHERE \n"
					+ "    type ='table' AND \n" + "    name NOT LIKE 'sqlite_%';");

			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
