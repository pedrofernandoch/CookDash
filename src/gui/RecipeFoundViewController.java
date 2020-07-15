package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.entities.Recipe;

public class RecipeFoundViewController implements Initializable {
	
	private static Node table;
	
	@FXML
	private Button recipes;
	
	@FXML
	private TableView<Recipe> tableViewRecipe;
	
	@FXML
	private TableColumn<Recipe, String> tableColumnRecipe;
	
	@FXML
    private TableColumn<Recipe, Float> tableColumnMatch;

	@FXML
	private TableColumn<Recipe, Button> tableColumnView;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	public static void loadRecipe() {
		try {
			FXMLLoader loader = new FXMLLoader(RecipeFoundViewController.class.getResource("/gui/RecipeView.fxml"));
			VBox newVBox = loader.load();
			Scene mainScene = SearchRecipeViewController.getRecipeFound();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			Node pane = mainVBox.getChildren().get(0);
			table = mainVBox.getChildren().get(1);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(pane);
			mainVBox.getChildren().addAll(newVBox.getChildren());
		}
		catch (IOException exc) {
			Alerts.showAlert("IO Exception", "Error loading view", exc.getMessage(), AlertType.ERROR);
		}
	}
	
	public void onRecipesAction() {
		Scene mainScene = SearchRecipeViewController.getRecipeFound();
		VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
		Node pane = mainVBox.getChildren().get(0);
		mainVBox.getChildren().clear();
		mainVBox.getChildren().add(pane);
		mainVBox.getChildren().add(table);
	}

	private void initializeNodes() {
		ObservableList<Recipe> obsList = SearchRecipeViewController.getObsList();
		tableViewRecipe.setItems(obsList);
		tableColumnRecipe.setCellValueFactory(new PropertyValueFactory<>("name"));
		tableColumnMatch.setCellValueFactory(new PropertyValueFactory<>("match"));
		tableColumnView.setCellValueFactory(new PropertyValueFactory<>("view"));
	}

}
