package model.entities;

public class Ingredient {

	private String name;

	public Ingredient() {
	}

	public Ingredient(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
