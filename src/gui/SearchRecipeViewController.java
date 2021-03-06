package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import db.SQLiteConnection;
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
import javafx.scene.control.CheckBox;
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
    private CheckBox cbVegano;

    @FXML
    private CheckBox cbDiabeitco;

	@FXML
	private TextField txtIngredient;
	
	@FXML
	private Button btSearch;
	
	@FXML
	private Button btAdd;
	
	@FXML
	private Button btClear;
	
	@FXML
	public TableView<Ingredient> tableViewIngredients;
	
	@FXML
	public TableColumn<Ingredient, String> tableColumnIngredient;
	
	//Ao clicar no bot�o adiciona o ingrediente na caixa de texto para um array de ingredientes e mostra na tabela
	@FXML
	public void onBtAddAction() {
		if(txtIngredient.getText().length() != 0) ingredients.add(new Ingredient(txtIngredient.getText()));
		obsListIngredient = FXCollections.observableArrayList(ingredients);
		tableViewIngredients.setItems(obsListIngredient);
		txtIngredient.clear();
	}
	
	//Limpa os ingredientes da tabela e do array
	@FXML
	public void onBtClearAction() {
		ingredients.clear();
		obsListIngredient = FXCollections.observableArrayList(ingredients);
		tableViewIngredients.setItems(obsListIngredient);
	}
	
	//Fun��o que realiza a busca de receitas usando os ingredientes da tabela e a checkbox 
	public void initializeSearch() {
		
		btSearch.setOnAction(new EventHandler<ActionEvent>() {	 
			
			@Override
            public void handle(ActionEvent event) {
				String ingredientsString = "";
				
				for (int i=0;i<ingredients.size(); i++) {
					if (i == 0) ingredientsString = ingredientsString + "UPPER('" +  ingredients.get(i).getName() + "')";
					else ingredientsString = ingredientsString + ", " + "UPPER('" +  ingredients.get(i).getName() + "')";
				}
				
				//Getting recipes from DB
				Connection conn = null;
				Statement st = null;
				ResultSet resultSet=null;
				ResultSet resultSet2=null;
				
				cats.add(new Category("Normal"));
				float prepTime = 0;
				int id = 0;
				String name = "";
				String directions = "";
				float match = 0;
				int serv = 0;
				
				rec.clear();
				
				try {
					conn = SQLiteConnection.getConnection();
					st = conn.createStatement(); // Sem filtro
					resultSet = st.executeQuery("SELECT DISTINCT Recipes.* FROM  Recipes, Recipe_Ingredients, Ingredients"
			                + "	WHERE Recipe_Ingredients.recipe_id = Recipes.id\n"
			                + "	AND Recipe_Ingredients.ingredient_id = Ingredients.id"
			                + "	AND UPPER(Ingredients.name) in (" + ingredientsString + ")\n"
			                + ";");
					if (cbVegano.isSelected() && cbDiabeitco.isSelected()) { //Com ambos os filtros
						resultSet = st.executeQuery("SELECT DISTINCT Recipes.* FROM  Recipes, Recipe_Ingredients, Ingredients, Recipe_Categories"
				                + "	WHERE Recipe_Ingredients.recipe_id = Recipes.id\n"
				                + "	AND Recipe_Ingredients.ingredient_id = Ingredients.id"
				                + "	AND Recipe_Categories.recipe_id = Recipes.id"
				                + "	AND Recipe_Categories.category_id in (1, 2)"
				                + "	AND UPPER(Ingredients.name) in (" + ingredientsString + ")\n"
				                + ";");
					}
					else if (cbVegano.isSelected()) { //Com filtro vegano 
						resultSet = st.executeQuery("SELECT DISTINCT Recipes.* FROM  Recipes, Recipe_Ingredients, Ingredients, Recipe_Categories"
				                + "	WHERE Recipe_Ingredients.recipe_id = Recipes.id\n"
				                + "	AND Recipe_Ingredients.ingredient_id = Ingredients.id"
				                + "	AND Recipe_Categories.recipe_id = Recipes.id"
				                + "	AND Recipe_Categories.category_id = 1"
				                + "	AND UPPER(Ingredients.name) in (" + ingredientsString + ")\n"
				                + ";");
					}
					else if (cbDiabeitco.isSelected()) { //Com filtro diabetico
						resultSet = st.executeQuery("SELECT DISTINCT Recipes.* FROM  Recipes, Recipe_Ingredients, Ingredients, Recipe_Categories"
				                + "	WHERE Recipe_Ingredients.recipe_id = Recipes.id\n"
				                + "	AND Recipe_Ingredients.ingredient_id = Ingredients.id"
				                + "	AND Recipe_Categories.recipe_id = Recipes.id"
				                + "	AND Recipe_Categories.category_id = 2"
				                + "	AND UPPER(Ingredients.name) in (" + ingredientsString + ")\n"
				                + ";");
					}
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
				int index=0;
				try { //Pega os resultados e coloca em um array de receitas
					while (resultSet.next()) {
						id = resultSet.getInt(1);
						name = resultSet.getString(2);
						directions = resultSet.getString(3);
						prepTime = resultSet.getFloat(4);
						serv = resultSet.getInt(5);
						
						Statement st2 = conn.createStatement();
						
						resultSet2 = st2.executeQuery("SELECT Ingredients.name FROM  Ingredients, Recipe_Ingredients"
				                + "	WHERE Recipe_Ingredients.recipe_id =" + String.valueOf(id) + "\n"
				                + "	AND Recipe_Ingredients.ingredient_id = Ingredients.id"
				                + ";");
						while (resultSet2.next()) {
							ing.add(new RecipeIngredient(new Ingredient(resultSet2.getString(1)),1,new Unit("unidade")));
						}
						
						int counter=0;
						//Faz a porcentagem de match 
						for (RecipeIngredient ingRecipe : ing) {							
							for (Ingredient ingTable : ingredients) {								
					            if(ingRecipe.getIngredient().getName().toLowerCase().equals(ingTable.getName().toLowerCase()))
					            	counter++;
					        }							
				        }
						
						match = ((float)counter/ing.size()) * 100;
						
						rec.add(new Recipe(new Button("View"),name,new ArrayList<Category>(cats),new ArrayList<RecipeIngredient>(ing),directions,prepTime,match,serv,index));
						index++;
						ing.clear();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//Cria uma obslit com o array de receitas para poder mostrar na tabela
				obsListRecipe = FXCollections.observableArrayList(new ArrayList<Recipe>(rec));
				rec.clear();
				cats.clear();
 
				//Carrega uma nova janela com uma tabela contendo as receitas
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
				newWindow.setResizable(false);
				newWindow.setTitle("Recipes Found");
				recipeFound = new Scene(scene);
				newWindow.setScene(recipeFound);
				newWindow.show();
            }
        });
	}
	
	// Inicializa os componentes necess�rios e as restri��es para os nomes de ingredientes
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldInteger(txtIngredient);
		Constraints.setTextFieldMaxLength(txtIngredient, 100);
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
