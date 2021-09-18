package a2;

public class MenuItemImpl implements MenuItem {
private String name;
private IngredientPortion[] ingredients;
	
	
	public MenuItemImpl(String name, IngredientPortion[] ingredients) {
		if (name.equals(null)) {
			throw new RuntimeException("There needs to be a name");
		}
		if (ingredients.length <= 0) {
			throw new RuntimeException("fix list length");
		}
		this.name = name;
		this.ingredients = new IngredientPortion[ingredients.length];
		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i].equals(null)) {
				throw new RuntimeException();
			}
			this.ingredients[i] = ingredients[i];
		}
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public IngredientPortion[] getIngredients() {
		return this.ingredients.clone();
	}

	
	// this needs to be an integer program*****
	@Override
	public int getCalories() {
		int holder = 0;
		for (int i = 0; i < ingredients.length; i++) {
			holder += ingredients[i].getCalories();
		}
		return holder;
	}

	@Override
	public double getCost() {
		double holder = 0;
		for (int i = 0; i < ingredients.length; i++) {
			holder += ingredients[i].getCost();
		}
		return holder;
	}

	@Override
	public boolean getIsVegetarian() {
		boolean holder = true;
		for (int i = 0; i < ingredients.length; i++) { 
			if (ingredients[i].getIsVegetarian() == false) {
				holder = false;
			}
		}
		return holder;
	}
}
