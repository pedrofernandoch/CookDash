package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entities.Ingredient;

public class SearchRecipeViewController implements Initializable {
	
	private ArrayList<Ingredient> ingredients = new ArrayList<>();
	
	private ObservableList<Ingredient> obsList;
	
	@FXML
	private TextField txtIngredient;
	
	@FXML
	private Button btSeacrh;
	
	@FXML
	private Button btAdd;
	
	@FXML
	private TableView<Ingredient> tableViewIngredients;
	
	@FXML
	private TableColumn<Ingredient, String> tableColumnIngredient;
	
	@FXML
	public void onBtAddAction() {
		ingredients.add(new Ingredient(txtIngredient.getText()));
		obsList = FXCollections.observableArrayList(ingredients);
		tableViewIngredients.setItems(obsList);
		txtIngredient.clear();
	}
	
	@FXML
	public void onBtSearchAction() {
		
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldInteger(txtIngredient);
		Constraints.setTextFieldMaxLength(txtIngredient, 20);
		initializeNodes();
	}

	private void initializeNodes() {
		tableColumnIngredient.setCellValueFactory(new PropertyValueFactory<>("name"));
	}
}
