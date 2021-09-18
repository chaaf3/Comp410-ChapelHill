package a2;

public class IngredientPortionImpl implements IngredientPortion {
	
	private double ammount;
	private Ingredient ing;
	
	
	public IngredientPortionImpl(Ingredient ing, double ammount) {
		if (ing.equals(null)) {
			throw new RuntimeException("There needs to be a name");
		}
		if (ammount <= 0) {
			throw new RuntimeException("price has to be a positive number");
		}
		this.ammount = ammount;
		this.ing = ing;
	}

	@Override
	public Ingredient getIngredient() {
		return ing;
	}

	@Override
	public double getAmount() {
		return ammount;
	}

	@Override
	public String getName() {
		return ing.getName();
	}

	@Override
	public boolean getIsVegetarian() {
		return ing.getIsVegetarian();
	}

	@Override
	public double getCalories() {
		return (ammount * ing.getCaloriesPerOunce());
	}

	@Override
	public double getCost() {
		return (ammount * ing.getPricePerOunce());
	}

	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (!other.getName().equals(this.getName()) || other == null) {
			throw new RuntimeException ("use the same kind of food");
		}
		IngredientPortion sum = new IngredientPortionImpl(ing, (other.getAmount() + this.getAmount()));
		return sum;
		
	}

}
