package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class ViewController {
	
	@FXML
	private Button findRecipes;
	@FXML
	public void onFindRecipesAction() {
		Alerts.showAlert("Alert title", "Alert header", "Alert content", AlertType.INFORMATION);
	}

}
