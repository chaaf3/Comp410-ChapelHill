package a2;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numItems = scan.nextInt();
		String[] ingredientName = new String[numItems];
		double[] pricePerOunce = new double[numItems];
		boolean[] isVegetarian = new boolean[numItems];
		int numVegetarianIngredients = 0;
		int[] caloriesPerOunce = new int[numItems];
		for (int i = 0; i < numItems; i++) {
			ingredientName[i] = scan.next();
			pricePerOunce[i] = scan.nextDouble();
			isVegetarian[i] = scan.nextBoolean();
			caloriesPerOunce[i] = scan.nextInt();
		}
		// Find the number of vegetarian ingredients
		for (int j = 0; j < numItems; j++) {
			if (isVegetarian[j] == true) {
				numVegetarianIngredients++;
			}
			//cal/0z divided by dollars/ozj
		}
		int extraCounter = 0;
		double highest = -99999;
		String highestAnswer = "";
		double lowest = 99999999;
		String lowestAnswer = "";
		double[] calPerDollar = new double[numItems];
		for (int j = 0; j < numItems; j++) {
				calPerDollar[extraCounter] = caloriesPerOunce[j] / pricePerOunce[j];
				extraCounter++;
				if ((caloriesPerOunce[j] / pricePerOunce[j]) > highest) {
					highest = caloriesPerOunce[j] / pricePerOunce[j];
					highestAnswer = ingredientName[j];
				}
				if ((caloriesPerOunce[j] / pricePerOunce[j]) < lowest) {
					lowest = caloriesPerOunce[j] / pricePerOunce[j];
					lowestAnswer = ingredientName[j];
				}
					
		}
		System.out.println("Number of vegetarian ingredients: " + numVegetarianIngredients);
		System.out.println("Highest cals/$: " +  highestAnswer);
		System.out.println("Lowest cals/$: " + lowestAnswer);
	scan.close();
	}
	
	// You can define helper methods here if needed.
	
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