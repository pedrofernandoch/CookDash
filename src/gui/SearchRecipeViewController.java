package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SearchRecipeViewController implements Initializable {
	
	ArrayList<String> ingredients = new ArrayList<>();
	
	@FXML
	private TextField txtIngredient;
	
	@FXML
	private Button btSeacrh;
	
	@FXML
	private Button btAdd;
	
	@FXML
	public void onBtSearchAction() {
		ingredients.add(txtIngredient.getText());
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldInteger(txtIngredient);
		Constraints.setTextFieldMaxLength(txtIngredient, 20);
	}
}
