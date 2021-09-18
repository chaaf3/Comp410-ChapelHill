package a3;

public class IngredientImpl implements Ingredient {
	private String name;
	private double price;
	private int calories;
	private boolean is_vegetarian;

	public IngredientImpl(String name, double price, int calories, boolean is_vegetarian) {
		if (name == null) {
			throw new RuntimeException("There needs to be a name");
		}
		if (price < 0) {
			throw new RuntimeException("price has to be a positive number");
		}
		if (calories < 0) {
			throw new RuntimeException("The number of calories per dish should be positive");
		}
		this.name = name;
		this.price = price;
		this.calories = calories;
		this.is_vegetarian = is_vegetarian;
	}
	public String getName() {
		return name;
	}
	public boolean getIsVegetarian() {
		return is_vegetarian;
	}
	public double getPricePerOunce() {
		return price;
	}
	public int getCaloriesPerOunce() {
		return calories;
	}
	public double getCaloriesPerDollar() {
		return calories/price;
	}

}

/*
6
Rice 0.12 true 37
Seaweed 2.95 true 113
Avocado 0.22 true 45
Salmon 1.77 false 48
Yellowtail 0.53 false 41
Eel 2.18 false 84

Number of vegetarian ingredients: 3
Highest cals/$: Rice
Lowest cals/$: Salmon
*/