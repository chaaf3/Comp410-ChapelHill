package a4;
import java.util.ArrayList;

public class Roll implements Sushi {
	
	IngredientPortion[] cop;
	String name;

	public Roll(String name, IngredientPortion[] roll_ingredients) {
		this.name = name;
		if (roll_ingredients.equals(null)) {
			throw new RuntimeException();
		}
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i].equals(null)) {
				throw new RuntimeException();
			}
		}
		ArrayList<IngredientPortion> arrayList = new  ArrayList<IngredientPortion>();
		for (int i = 0; i < roll_ingredients.length; i++) {
			arrayList.add(roll_ingredients[i]);
		}
		for (int i = 0; i < arrayList.size(); i++) {
			for (int j = i + 1; j < arrayList.size(); j++) {
				if (arrayList.get(i).getName().equals(arrayList.get(j).getName())) {
					arrayList.set(i, arrayList.get(i).combine(arrayList.get(j)));
					arrayList.remove(j);
					j--;
				}
			}
		}
		
		int holder = 0;
		boolean exists = false;
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getName().equals("seaweed")) {
				holder = i;
				exists = true;
			}
		}
		if (exists && arrayList.get(holder).getAmount() <= .1) {
			arrayList.set(holder, new SeaweedPortion(.1));
		}
		if (exists == false) {
			arrayList.add(new SeaweedPortion(.1));
		}
		IngredientPortion[] start = new IngredientPortion[arrayList.size()];
		for (int i = 0; i < start.length; i++) {
			start[i] = arrayList.get(i);
		}
		cop = start.clone();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public IngredientPortion[] getIngredients() {
		return cop.clone();
	}

	@Override
	public int getCalories() {
		double calories = 0;
		for (int i = 0; i < cop.length; i++) {
			calories += cop[i].getCalories();
		}
		return (int) (calories + .5);
	}

	@Override
	public double getCost() {
		double cost = 0;
		for (int i = 0; i < cop.length; i++) {
			cost += cop[i].getCost();
		}
		cost *= 100;
		cost = Math.round(cost);
		cost /= 100;
		return cost;
	}

	@Override
	public boolean getHasRice() {
		boolean hasRice = false;
		for (int i = 0; i < cop.length; i++) {
			if (cop[i].getIsRice()) {
				hasRice = true;
			}
		}
		return hasRice;
	}

	@Override
	public boolean getHasShellfish() {
		boolean hasShellfish = false;
		for (int i = 0; i < cop.length; i++) {
			if (cop[i].getIsShellfish()) {
				hasShellfish = true;
			}
		}
		return hasShellfish;
	}

	@Override
	public boolean getIsVegetarian() {
		boolean vegetarian = true;
		for (int i = 0; i < cop.length; i++) {
			if (!cop[i].getIsVegetarian()) {
				vegetarian = false;
			}
		}
		return vegetarian;
	}

}
