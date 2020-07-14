package model.entities;

public class PersonalRecipe extends Recipe {

	public PersonalRecipe(Recipe recipe) {
		super(recipe.getView(),recipe.getName(), recipe.getCategories(), recipe.getIngredients(), recipe.getDirections(), recipe.getPreparationTime(),
				recipe.getCookTime(), recipe.getMatch(),recipe.getServings());
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
