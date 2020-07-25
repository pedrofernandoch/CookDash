package gui;

import java.io.IOException;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

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