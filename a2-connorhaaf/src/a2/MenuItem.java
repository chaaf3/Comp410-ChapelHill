package a2;

public interface MenuItem {

	String getName();
	IngredientPortion[] getIngredients();
	int getCalories();
	double getCost();
	boolean getIsVegetarian();
}
