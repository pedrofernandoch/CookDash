package model.entities;

import java.sql.Time;
import java.util.ArrayList;

public class PersonalRecipe extends Recipe{

	public PersonalRecipe(String name, ArrayList<Category> categories, String directions, Time preparationTime,
			Time cookTime, int servings) {
		super(name, categories, directions, preparationTime, cookTime, servings);
	}

}
