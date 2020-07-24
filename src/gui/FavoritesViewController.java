package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.entities.PersonalRecipe;

public class FavoritesViewController implements Initializable {

	//private static Node table;
	
	@FXML
	private Button back;
	
    @FXML
    private TableView<PersonalRecipe> tableView;

    @FXML
    private TableColumn<PersonalRecipe, String> tcRecipe;

    @FXML
    private TableColumn<PersonalRecipe, Button> tcView;

    @FXML
    private TableColumn<PersonalRecipe, Button> tcEdit;

    @FXML
    private TableColumn<PersonalRecipe, Button> tcDelet;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		//initializeNodes();
		back.setDisable(true);
	}
	
	/*public static void loadRecipe() {
		try {
			FXMLLoader loader = new FXMLLoader(RecipeFoundViewController.class.getResource("/gui/RecipeView.fxml"));
			VBox newVBox = loader.load();
			//CHAMADA DO BANCO
			Scene mainScene = SearchRecipeViewController.getRecipeFound();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			Node pane = mainVBox.getChildren().get(0);
			Node bt = ((Pane)pane).getChildren().get(1);
			((Button)bt).setDisable(false);
			table = mainVBox.getChildren().get(1);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(pane);
			mainVBox.getChildren().addAll(newVBox.getChildren());
		}
		catch (IOException exc) {
			Alerts.showAlert("IO Exception", "Error loading view", exc.getMessage(), AlertType.ERROR);
		}
	}
	
	public void onBacksAction() {
		//CHAMADA DO BANCO
		Scene mainScene = SearchRecipeViewController.getRecipeFound();
		VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
		Node pane = mainVBox.getChildren().get(0);
		mainVBox.getChildren().clear();
		mainVBox.getChildren().add(pane);
		mainVBox.getChildren().add(table);
		back.setDisable(true);
	}

	private void initializeNodes() {
		//CHAMADA DO BANCO
		ObservableList<PersonalRecipe> obsList;
		//tableView.setItems(obsList);
		tcRecipe.setCellValueFactory(new PropertyValueFactory<>("name"));
		tcEdit.setCellValueFactory(new PropertyValueFactory<>("edit"));	
		tcDelet.setCellValueFactory(new PropertyValueFactory<>("delet"));	
		tcView.setCellValueFactory(new PropertyValueFactory<>("view"));
	}*/
}
