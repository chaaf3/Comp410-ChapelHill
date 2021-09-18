package a5;

public class Nigiri implements Sushi {
	
	public enum NigiriType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};
	
	IngredientPortion ing;
	RicePortion ricePortion = new RicePortion(.5);
	
	public Nigiri(NigiriType type) {
		if (type.equals(NigiriType.TUNA)) {
			this.ing = new TunaPortion(.75);
		}
		else if (type.equals(NigiriType.YELLOWTAIL)) {
			this.ing = new YellowtailPortion(.75);
		}
		else if (type.equals(NigiriType.EEL)) {
			this.ing = new EelPortion(.75);
		}
		else if (type.equals(NigiriType.CRAB)) {
			this.ing = new CrabPortion(.75);
		}
		else {
			this.ing = new ShrimpPortion(.75);
		}
	}


	@Override
	public String getName() {
		return ing.getName() + " nigiri";
	}

	@Override
	public IngredientPortion[] getIngredients() {
		IngredientPortion[] ingArr = new IngredientPortion[2];
		ingArr[0] = ing;
		ingArr[1] = ricePortion;
		return ingArr;
	}

	@Override
	public int getCalories() {
		return (int) (ing.getCalories() + ricePortion.getCalories() + .5);
	}

	@Override
	public double getCost() {
		return ing.getCost() + ricePortion.getCost();
	}

	@Override
	public boolean getHasRice() {
		return true;
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
