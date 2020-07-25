package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CreateNewRecipeViewController {
	
	@FXML
    private TextField txtName;

    @FXML
    private TextField txtPrep;

    @FXML
    private TextField txtServ;

    @FXML
    private TextArea txtDir;

    @FXML
    private TextField txtIng;

    @FXML
    private Button btAddIng;

    @FXML
    private TextField txtCat;

    @FXML
    private Button btAddCat;

    @FXML
    private TextField txtUnit;

    @FXML
    private TextField txtN;

    @FXML
    private Button btCreate;
    
    public void onbtCreateAction() {
    	Alerts.showAlert("ALERTA PROFESSOR E MONITOR","Não deu tempo de fazer professor, sorry!","Mas o que vale é a intenção", AlertType.INFORMATION);
    }
    
    public void onbtAdd() {
    	Alerts.showAlert("ALERTA PROFESSOR E MONITOR","Adicionou na minha imaginação", "Mas o que vale é a intenção", AlertType.INFORMATION);
    }

}
