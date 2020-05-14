package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewController {
	
	@FXML
	private Button findRecipes;
	@FXML
	public void onFindRecipesAction() {
		System.out.println("Hello World");
	}

}
