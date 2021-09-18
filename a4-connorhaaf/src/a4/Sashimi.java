package a4;

public class Sashimi implements Sushi {

	public enum SashimiType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};

	private IngredientPortion ing;
	
	public Sashimi(SashimiType type) {
		if (type.equals(SashimiType.TUNA)) {
			ing = new TunaPortion(.75);
		}
		else if (type.equals(SashimiType.YELLOWTAIL)) {
			ing = new YellowtailPortion(.75);
		}
		else if (type.equals(SashimiType.EEL)) {
			ing = new EelPortion(.75);
		}
		else if (type.equals(SashimiType.CRAB)) {
			ing = new CrabPortion(.75);
		}
		else {
			ing = new ShrimpPortion(.75);
		}
	}

	@Override
	public String getName() {
		return ing.getName() + " sashimi";
	}

	@Override
	public IngredientPortion[] getIngredients() {
		IngredientPortion[] ingArr = new IngredientPortion[1];
		ingArr[0] = ing;
		return ingArr;
	}

	@Override
	public int getCalories() {
		return (int) (ing.getCalories() + .5);
	}

	@Override
	public double getCost() {
		return ing.getCost();
	}

	@Override
	public boolean getHasRice() {
		return ing.getIsRice();
	}

	@Override
	public boolean getHasShellfish() {
		return ing.getIsShellfish();
	}

	@Override
	public boolean getIsVegetarian() {
		return ing.getIsVegetarian();
	}

}
