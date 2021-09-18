package a3;

import java.util.Scanner;

public class A3Jedi {
	
	public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
		
		int numItems = scan.nextInt();
		Ingredient[] ingredients = new IngredientImpl[numItems];
		double[] answer = new double[numItems];
		for (int i = 0; i < numItems; i++) {
			String ingredientName = scan.next();
			double pricePerOunce = scan.nextDouble();
			boolean isVegetarian = scan.nextBoolean();
			int caloriesPerOunce = scan.nextInt();
			ingredients[i] = new IngredientImpl(ingredientName, pricePerOunce, caloriesPerOunce, isVegetarian);
		}
		// start looking here for information for this problem
		// before this point was intake values
		int numMenueItems = scan.nextInt();
		// menueItems need the dish name and an array of ingredient portions
		//ingredient portions need ingredient and an ammount
		MenuItem[] menueItems = new MenuItemImpl[numMenueItems];
		//store the weights with each name
		for (int i = 0; i < menueItems.length; i++) {
			String dishName = scan.next();
			int numIngredientsPerDish = scan.nextInt();
			IngredientPortion[] ingredientPortions = new IngredientPortionImpl[numIngredientsPerDish];
			for(int j = 0; j < ingredientPortions.length; j++) {
				String name = scan.next();
				int ind = finder (name, ingredients);
				ingredientPortions[j] = new IngredientPortionImpl(ingredients[ind], scan.nextDouble());
			}
			menueItems[i] = new MenuItemImpl (dishName, ingredientPortions);
		}
		// correct through here
		String checker = scan.next();
		while (!(checker.equals("EndOrder"))) {
			int holder = finderTwo(checker, menueItems);
			for (int i = 0; i < menueItems[holder].getIngredients().length; i++) {
				int temp = finder(menueItems[holder].getIngredients()[i].getName(), ingredients);
				answer[temp] += menueItems[holder].getIngredients()[i].getAmount();
			}
			checker = scan.next();
		}
		System.out.println("The order will require:");
		for (int i = 0; i < answer.length; i++) {
			System.out.println(String.format("%.2f", answer[i]) + " ounces of " + ingredients[i].getName());
		}
		scan.close();
}

	private static int finder(String look, Ingredient[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i].getName().equals(look)) {
				return i;
			}
		}
		return 0;
	}
	private static int finderTwo(String look, MenuItem[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i].getName().equals(look)) {
				return i;
			}
		}
		return 0;
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

4

Avocado_Roll
3
Rice 0.5
Avocado 0.5
Seaweed 0.1

Unagi_Nigiri
2
Rice 0.75
Eel 0.75

KMP_Roll
4
Eel 0.6
Rice 0.4
Seaweed 0.2
Avocado 0.3

Salmon_Sashimi
1
Salmon 0.8

Avocado_Roll
Unagi_Nigiri
Unagi_Nigiri
Unagi_Nigiri
KMP_Roll
Salmon_Sashimi
Avocado_Roll
KMP_Roll
EndOrder
should produce the following output:

The order will require: 
4.05 ounces of Rice
0.60 ounces of Seaweed
1.60 ounces of Avocado
0.80 ounces of Salmon
0.00 ounces of Yellowtail
3.45 ounces of Eel
*/
