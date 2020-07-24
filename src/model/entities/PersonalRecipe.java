package model.entities;

import javafx.scene.control.Button;

public class PersonalRecipe extends Recipe {
	
	public Button view;
	public Button edit;
	public Button delet;

	public PersonalRecipe(Recipe recipe, Button view, Button edit, Button delet) {
		super(recipe.getView(),recipe.getName(), recipe.getCategories(), recipe.getIngredients(), recipe.getDirections(), recipe.getPreparationTime(), recipe.getMatch(),recipe.getServings(), recipe.getIndex());
		setView(view);
		setEdit(edit);
		setDelet(delet);
		view.setOnAction(e ->{
			//RecipeViewController.setIndex(index);
			//RecipeFoundViewController.loadRecipe();
		});


		edit.setOnAction(e ->{
			//RecipeViewController.setIndex(index);
			//RecipeFoundViewController.loadRecipe();
			//addIngredient();
			//removeIngredient();
			//addCategory();
			//removeCategory();	
			//editDirections();
		});


		delet.setOnAction(e ->{
			//RecipeViewController.setIndex(index);
			//RecipeFoundViewController.loadRecipe();
		});
	}
	
	public Button getView() {
		return view;
	}

	public void setView(Button view) {
		this.view = view;
	}

	public Button getEdit() {
		return edit;
	}

	public void setEdit(Button edit) {
		this.edit = edit;
	}

	public Button getDelet() {
		return delet;
	}

	public void setDelet(Button delet) {
		this.delet = delet;
	}

	public void addIngredient(Ingredient ingredient, float amount, Unit unit) {
		getIngredients().add(new RecipeIngredient(ingredient, amount, unit));
	}

	public void removeIngredient(String name) {
		getIngredients().removeIf(i -> (i.getIngredient().getName().equals(name)));
	}

	public void addCategory(String category) {
		getCategories().add(new Category(category));
	}

	public void removeCategory(String category) {
		getCategories().removeIf(c  -> (c.getName().equals(category)));
	}
	
	public void editDirections(String directions) {
		setDirections(directions);
	}

}
