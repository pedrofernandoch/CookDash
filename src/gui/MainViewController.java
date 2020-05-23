package gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import db.SQLiteConnection;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class MainViewController implements Initializable{

	@FXML
	private Button findRecipes;

	@FXML
	public void onFindRecipesAction() {
		Alerts.showAlert("Alert title", "Alert header", "Alert content", AlertType.INFORMATION);
	}

	@FXML
	private Button showRecipes;

	@FXML
	public void onShowRecipesAction() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = SQLiteConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM recipes");

			while (rs.next()) {
				System.out.println(rs.getString("name") + ", " + rs.getString("directions"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void createDB() {
		Connection conn = null;
		Statement st = null;
		try {
			conn = SQLiteConnection.getConnection();
			st = conn.createStatement();
			st.executeUpdate("CREATE TABLE IF NOT EXISTS Recipes (\n"
	                + "	id integer PRIMARY KEY,\n"
	                + "	name text NOT NULL,\n"
	                + "	directions text NOT NULL,\n"
	                + "	preparationTime real,\n"
	                + "	servings integer\n"
	                + ");");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS Categories (\n"
	                + "	id integer PRIMARY KEY,\n"
	                + "	name text NOT NULL\n"
	                + ");");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS Recipe_Categories (\n"
	                + "	id integer PRIMARY KEY,\n"
	                + "	FOREIGN KEY (id)\n" 
	                + " REFERENCES Recipes (recipe_id),\n"
	                + "	FOREIGN KEY (id)\n" 
	                + " REFERENCES Categories (category_id)\n"
	                + ");");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS Ingredients (\n"
	                + "	id integer PRIMARY KEY,\n"
	                + "	name text NOT NULL\n"
	                + ");");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS Units (\n"
	                + "	id integer PRIMARY KEY,\n"
	                + "	name text NOT NULL\n"
	                + ");");
			st.executeUpdate("CREATE TABLE IF NOT EXISTS Recipe_Ingredients (\n"
	                + "	id integer PRIMARY KEY,\n"
	                + "	FOREIGN KEY (id)\n" 
	                + " REFERENCES Recipes (recipe_id),\n"
	                + "	FOREIGN KEY (id)\n" 
	                + " REFERENCES Ingredients (ingredient_id)\n"
	                + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void showAllTables() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = SQLiteConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT \n" + 
					"    name\n" + 
					"FROM \n" + 
					"    sqlite_master \n" + 
					"WHERE \n" + 
					"    type ='table' AND \n" + 
					"    name NOT LIKE 'sqlite_%';");

			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}

}
