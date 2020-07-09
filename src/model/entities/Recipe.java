package model.entities;

import java.util.ArrayList;

public class Recipe {

	private String name;
	private ArrayList<Category> categories;
	private ArrayList<RecipeIngredient> ingredients;
	private String directions;
	private float preparationTime;
	private float cookTime;
	private int servings;

	public Recipe(String name, ArrayList<Category> categories, ArrayList<RecipeIngredient> ingredients, String directions, float preparationTime, float cookTime,
			int servings) {
		setName(name);
		setCategories(categories);
		setIngredients(ingredients);
		setDirections(directions);
		setPreparationTime(preparationTime);
		setCookTime(cookTime);
		setServings(servings);
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

	public float getCookTime() {
		return cookTime;
	}

	public void setCookTime(float cookTime) {
		this.cookTime = cookTime;
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
				+ ", preparationTime=" + preparationTime + ", cookTime=" + cookTime + ", servings=" + servings + "]";
	}

}
