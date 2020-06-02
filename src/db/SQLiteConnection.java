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
			initialize();
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
			st = conn.createStatement();
			st.executeUpdate("CREATE TABLE IF NOT EXISTS Recipes (\n" + "	id integer PRIMARY KEY,\n"
					+ "	name text NOT NULL,\n" + "	directions text NOT NULL,\n" + "	preparationTime real,\n"
					+ "	servings integer\n" + ");");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS MyRecipes (\n" + "	id integer PRIMARY KEY,\n"
					+ "	name text NOT NULL,\n" + "	directions text NOT NULL,\n" + "	preparationTime real,\n"
					+ "	servings integer\n" + ");");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS Categories (\n" + "	id integer PRIMARY KEY,\n"
					+ "	name text NOT NULL\n" + ");");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS Recipe_Categories (\n" + "	id integer PRIMARY KEY,\n"
					+ "	FOREIGN KEY (id)\n" + " REFERENCES Recipes (recipe_id),\n" + "	FOREIGN KEY (id)\n"
					+ " REFERENCES Categories (category_id)\n" + ");");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS Ingredients (\n" + "	id integer PRIMARY KEY,\n"
					+ "	name text NOT NULL\n" + ");");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS Units (\n" + "	id integer PRIMARY KEY,\n"
					+ "	name text NOT NULL\n" + ");");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS Recipe_Ingredients (\n" + "	id integer PRIMARY KEY,\n"
					+ "	FOREIGN KEY (id)\n" + " REFERENCES Recipes (recipe_id),\n" + "	FOREIGN KEY (id)\n"
					+ " REFERENCES Ingredients (ingredient_id)\n" + ");");
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
