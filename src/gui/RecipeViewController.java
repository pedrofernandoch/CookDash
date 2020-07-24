package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import model.entities.Recipe;
import model.entities.RecipeIngredient;

public class RecipeViewController implements Initializable {
	
	private static int index;
	
	@FXML
    private Label labelRecipe;

    @FXML
    private Label labelPrepTime;

    @FXML
    private Label labelServings;

    @FXML
    private Label labelCategory;
    
    @FXML
    private TextArea txtAreaIng;

    @FXML
    private TextArea txtAreaDir;
    
    @Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeLabels();
	}
    
    private void initializeLabels() {
    	ObservableList<Recipe> obsList = SearchRecipeViewController.getObsList();
    	labelRecipe.setText(obsList.get(SearchRecipeViewController.getIndexes().get(index)).getName());
    	labelPrepTime.setText(String.valueOf(obsList.get(SearchRecipeViewController.getIndexes().get(index)).getPreparationTime()));
    	labelServings.setText(String.valueOf(obsList.get(SearchRecipeViewController.getIndexes().get(index)).getServings()));
    	for(RecipeIngredient ing : obsList.get(SearchRecipeViewController.getIndexes().get(index)).getIngredients()) {
    		txtAreaIng.appendText(ing.toString()+"\n");
    	}
    	labelCategory.setText(obsList.get(SearchRecipeViewController.getIndexes().get(index)).getCategories().get(SearchRecipeViewController.getIndexes().get(index)).getName());
    	txtAreaDir.appendText(obsList.get(SearchRecipeViewController.getIndexes().get(index)).getDirections());
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		RecipeViewController.index = index;
	}

}
