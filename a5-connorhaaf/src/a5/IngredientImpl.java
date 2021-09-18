package a5;

public class IngredientImpl implements Ingredient {
	private String name;
	private int caloriesPerOunce;
	private double pricePerOunce;
	private boolean isVegetarian;
	private boolean isRice;
	private boolean isShellfish;

	public IngredientImpl(String name, int caloriesPerOunce, double pricePerOunce, boolean isVegetarian, boolean isRice, boolean isShellfish) {
		this.name = name;
		this.pricePerOunce = pricePerOunce;
		this.caloriesPerOunce = caloriesPerOunce;
		this.isVegetarian = isVegetarian;
		this.isRice = isRice;
		this.isShellfish = isShellfish;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getCaloriesPerDollar() {
		return caloriesPerOunce / pricePerOunce;
	}

	@Override
	public int getCaloriesPerOunce() {
		return caloriesPerOunce;
	}

	@Override
	public double getPricePerOunce() {
		return pricePerOunce;
	}

	@Override
	public boolean equals(Ingredient other) {
		if (this.getName().contentEquals(other.getName())) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean getIsVegetarian() {
		return  isVegetarian;
	}

	@Override
	public boolean getIsRice() {
		return  isRice;
	}

	@Override
	public boolean getIsShellfish() {
		return isShellfish;
	}

}
