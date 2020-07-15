package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Category;
import model.entities.Ingredient;
import model.entities.Recipe;
import model.entities.RecipeIngredient;
import model.entities.Unit;

public class SearchRecipeViewController implements Initializable {
	
	private ArrayList<Ingredient> ingredients = new ArrayList<>();
	
	private ArrayList<Category> cats = new ArrayList<>();
	
	private ArrayList<RecipeIngredient> ing = new ArrayList<>();
	
	private ArrayList<Recipe> rec = new ArrayList<>();
	
	private ObservableList<Ingredient> obsListIngredient;
	
	private static ObservableList<Recipe> obsListRecipe;
	
	private static Scene recipeFound;

	@FXML
	private TextField txtIngredient;
	
	@FXML
	private Button btSearch;
	
	@FXML
	private Button btAdd;
	
	@FXML
	public TableView<Ingredient> tableViewIngredients;
	
	@FXML
	public TableColumn<Ingredient, String> tableColumnIngredient;
	
	@FXML
	public void onBtAddAction() {
		ingredients.add(new Ingredient(txtIngredient.getText()));
		obsListIngredient = FXCollections.observableArrayList(ingredients);
		tableViewIngredients.setItems(obsListIngredient);
		txtIngredient.clear();
	}
	
	public void initializeSearch() {
		
		btSearch.setOnAction(new EventHandler<ActionEvent>() {	 
			
			@Override
            public void handle(ActionEvent event) {
				
				cats.add(new Category("Normal"));
				ing.add(new RecipeIngredient(new Ingredient("leite condensado"),1,new Unit("unidade")));
				ing.add(new RecipeIngredient(new Ingredient("nescal"),3,new Unit("colheres")));
				ing.add(new RecipeIngredient(new Ingredient("manteiga"),1,new Unit("colher")));
				String dir = "Coloque os ingredientes em uma leiteira ou panela, mexa sem parar no fogo médio até soltar da panela e pronto";
				float t1 = 15;
				float t2 = 5;
				float match = 100;
				int serv = 5;
				rec.add(new Recipe(new Button("View"),"Brigadeiro",cats,ing,dir,t1,t2,match,serv));
				obsListRecipe = FXCollections.observableArrayList(rec);
 
				ScrollPane scene = null;
				try {
					scene = FXMLLoader.load(RecipeFoundViewController.class.getResource("/gui/RecipesFoundView.fxml"));
					scene.setFitToHeight(true);
					scene.setFitToWidth(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
				 
				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Recipes Found");
				recipeFound = new Scene(scene);
				newWindow.setScene(recipeFound);
				newWindow.show();
            }
        });
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldInteger(txtIngredient);
		Constraints.setTextFieldMaxLength(txtIngredient, 20);
		initializeNodes();
		initializeSearch();
	}

	private void initializeNodes() {
		tableColumnIngredient.setCellValueFactory(new PropertyValueFactory<>("name"));
	}

	public static ObservableList<Recipe> getObsList() {
		return obsListRecipe;
	}
	
	public static Scene getRecipeFound() {
		return recipeFound;
	}

}
