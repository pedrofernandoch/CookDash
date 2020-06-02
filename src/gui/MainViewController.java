package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainViewController {
	
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
		loadView("/gui/CreateNewRecipeView.fxml");
	}
	
	@FXML
	public void onSearchRecipeAction() {
		loadView("/gui/SearchRecipeView.fxml");
	}
	
	@FXML
	public void onMyRecipesAction() {
		loadView("/gui/MyRecipesView.fxml");
	}
	
	@FXML
	public void onFavoritesAction() {
		loadView("/gui/FavoritesView.fxml");
	}
	
	private synchronized void loadView(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			Scene mainScene = SplashViewController.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node logo = mainVBox.getChildren().get(0);
			Node mainMenu = mainVBox.getChildren().get(1);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(logo);
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
		}
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
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
