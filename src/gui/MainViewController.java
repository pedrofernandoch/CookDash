package gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import db.SQLiteConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem createNewRecipe;
	
	@FXML
	private MenuItem searchRecipe;
	
	@FXML
	private MenuItem myRecipes;
	
	@FXML
	private MenuItem favorites;
	
	@FXML
	public void onCreateNewRecipeAction() {
		System.out.println("onCreateNewRecipeAction");
	}
	
	@FXML
	public void onSearchRecipeAction() {
		System.out.println("onSearchRecipeAction");
	}
	
	@FXML
	public void onMyRecipesAction() {
		System.out.println("onMyRecipesAction");
	}
	
	@FXML
	public void onFavoritesAction() {
		System.out.println("onFavoritesAction");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}

}
//Alerts.showAlert("Alert title", "Alert header", "Alert content",
	// AlertType.INFORMATION);

	//COLOCAR NA MAIN OU NO CONNECTOR DO DB
	/*public void createDB() {
		Connection conn = null;
		Statement st = null;
		try {
			conn = SQLiteConnection.getConnection();
			st = conn.createStatement();
			st.executeUpdate("CREATE TABLE IF NOT EXISTS Recipes (\n" + "	id integer PRIMARY KEY,\n"
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

	@FXML
	private Button showAllTables;

	@FXML
	public void onshowAllTablesAction() {
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
	}*/
