package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.entities.Recipe;

public class RecipeCardViewController implements Initializable{

	@FXML
    private Button cardButton;
	
	@FXML
	private ImageView cardImage;
	
	@FXML
    private Label cardMatch;

	@FXML
    private Label cardRecipie;

    @Override
	public void initialize(URL url, ResourceBundle rb) {
    	initializeNodes();
	}
	private void initializeNodes() {
		ObservableList<Recipe> obsList = SearchRecipeViewController.getObsList();
	}
	@FXML 
	public void startCardButton(ActionEvent event) {}

}
