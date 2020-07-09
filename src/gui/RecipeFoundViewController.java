package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entities.Recipe;

public class RecipeFoundViewController implements Initializable {
	
	@FXML
	private TableView<Recipe> tableViewIngredients;
	
	@FXML
	private TableColumn<Recipe, String> tableColumnIngredient0;
	
	@FXML
	private TableColumn<Recipe, Button> tableColumnIngredient1;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		ObservableList<Recipe> obsList = SearchRecipeViewController.getObsList();
		tableViewIngredients.setItems(obsList);
		tableColumnIngredient0.setCellValueFactory(new PropertyValueFactory<>("name"));
	}

}
