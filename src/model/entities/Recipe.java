package model.entities;

import java.sql.Time;
import java.util.ArrayList;

public class Recipe {

	private String name;
	private ArrayList<Category> categories;
	private String directions;
	private Time preparationTime;
	private Time cookTime;
	private int servings;

	public Recipe(String name, ArrayList<Category> categories, String directions, Time preparationTime, Time cookTime,
			int servings) {
		this.name = name;
		this.categories = categories;
		this.directions = directions;
		this.preparationTime = preparationTime;
		this.cookTime = cookTime;
		this.servings = servings;
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

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public Time getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(Time preparationTime) {
		this.preparationTime = preparationTime;
	}

	public Time getCookTime() {
		return cookTime;
	}

	public void setCookTime(Time cookTime) {
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
