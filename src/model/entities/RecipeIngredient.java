package model.entities;

public class RecipeIngredient {
	
	private Ingredient ingredient;
	private float amount;
	private Unit unit;
	
	public RecipeIngredient(Ingredient ingredient, float amount, Unit unit) {
		setIngredient(ingredient);
		setAmount(amount);
		setUnit(unit);
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

}
