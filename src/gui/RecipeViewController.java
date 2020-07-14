package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.entities.Recipe;

public class RecipeViewController implements Initializable {
	
	@FXML
    private Label labelRecipe;

    @FXML
    private Label labelPrepTime;

    @FXML
    private Label labelServings;

    @FXML
    private Label labelIngredients;

    @FXML
    private Label labelCategory;

    @FXML
    private Label labelDirections;
    
    @Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeLabels();
	}
    
    private void initializeLabels() {
    	ObservableList<Recipe> obsList = SearchRecipeViewController.getObsList();
    	labelRecipe.setText(obsList.get(0).getName());
    	labelPrepTime.setText(String.valueOf(obsList.get(0).getPreparationTime()));
    	labelServings.setText(String.valueOf(obsList.get(0).getServings()));
    	labelIngredients.setText(obsList.get(0).getIngredients().toString());
    	labelCategory.setText(obsList.get(0).getCategories().get(0).getName());
    	labelDirections.setText(obsList.get(0).getDirections());
	}

}
