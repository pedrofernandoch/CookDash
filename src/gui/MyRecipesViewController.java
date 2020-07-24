package gui;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MyRecipesViewController {
	
	@FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> tcRecipe;

    @FXML
    private TableColumn<?, ?> tcView;

    @FXML
    private TableColumn<?, ?> tcEdit;

    @FXML
    private TableColumn<?, ?> tcDelet;
	
}
