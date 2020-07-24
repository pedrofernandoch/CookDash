package model.entities;

import java.util.ArrayList;

import gui.RecipeFoundViewController;
import gui.RecipeViewController;
import javafx.scene.control.Button;

public class Recipe {

	private String name;
	private ArrayList<Category> categories;
	private ArrayList<RecipeIngredient> ingredients;
	private String directions;
	private float preparationTime, match;
	private int servings,index;
	
	public Button view;

	public Recipe(Button view, String name, ArrayList<Category> categories, ArrayList<RecipeIngredient> ingredients, String directions, float preparationTime, float match,
			int servings, int index) {
		setName(name);
		setCategories(categories);
		setIngredients(ingredients);
		setDirections(directions);
		setPreparationTime(preparationTime);
		setMatch(match);
		setServings(servings);
		setView(view);
		setIndex(index);
		
		view.setOnAction(e ->{
			RecipeViewController.setIndex(index);
			RecipeFoundViewController.loadRecipe();
		});
	}

	public Button getView() {
		return view;
	}

	public void setView(Button view) {
		this.view = view;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}
	
	public ArrayList<RecipeIngredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<RecipeIngredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public float getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(float preparationTime) {
		this.preparationTime = preparationTime;
	}
	
	public float getMatch() {
		return match;
	}

	public void setMatch(float match) {
		this.match = match;
	}


	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	@Override
	public String toString() {
		return "Recipe [name=" + name + ", categories=" + categories + ", directions=" + directions
				+ ", preparationTime=" + preparationTime + ", servings=" + servings + "]";
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
