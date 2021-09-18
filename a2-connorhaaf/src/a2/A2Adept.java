package a2;

import java.util.Arrays;
import java.util.Scanner;

public class A2Adept {
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numOfIngredients = scan.nextInt();
		//arrays for ingredients
		String[] ingredientNames = new String[numOfIngredients];
		double[] pricePerOunce = new double[numOfIngredients];
		boolean[] isVegetarian = new boolean[numOfIngredients];
		int[] caloriesPerOunce = new int[numOfIngredients];
		for (int i = 0; i < numOfIngredients; i++) {
			ingredientNames[i] = scan.next();
			pricePerOunce[i] = scan.nextDouble();
			isVegetarian[i] = scan.nextBoolean();
			caloriesPerOunce[i] = scan.nextInt();
		}
		
		
		
		int numberOfMenueItems = scan.nextInt();
		//arrays for nameOfRecepie
		String[] recepieName = new String[numberOfMenueItems];
		int[] numberOfIngredientsInRecepie = new int[numberOfMenueItems];
		//arrays for ingredientsInRecepie
		String[][] recipeIngredientName = new String[numberOfMenueItems][];
		double[][] amountOfEachIngredient = new double[numberOfMenueItems][];
		for (int i = 0; i < numberOfMenueItems; i++) {
			recepieName[i] = scan.next();
			numberOfIngredientsInRecepie[i] = scan.nextInt();
			recipeIngredientName[i] = new String[numberOfIngredientsInRecepie[i]];
			amountOfEachIngredient[i] = new double[numberOfIngredientsInRecepie[i]];
			for (int j = 0; j < numberOfIngredientsInRecepie[i]; j++) {
				recipeIngredientName[i][j] = scan.next();
				amountOfEachIngredient[i][j] = scan.nextDouble();
			}
		}

		scan.close();
		double numOfCalories;
		int index;
		double costOfRecipe;
		boolean isVegetarian2;
		for (int i = 0; i < numberOfMenueItems; i++) {
			numOfCalories = 0;
			costOfRecipe = 0;
			isVegetarian2 = true;
			System.out.println(recepieName[i] + ":");
			for (int j = 0; j < numberOfIngredientsInRecepie[i]; j++) {
				index = finder(recipeIngredientName[i][j], ingredientNames);
				numOfCalories += (caloriesPerOunce[index]) * (amountOfEachIngredient[i][j]);
				costOfRecipe += pricePerOunce[index] * amountOfEachIngredient[i][j];
				if (!isVegetarian[index]) {
					isVegetarian2 = false;
				}
			}
			
			

			
			System.out.println(((int) (numOfCalories + 0.5)) + " calories");
			System.out.println("$" + (String.format("%.2f", costOfRecipe)));
			if (isVegetarian2) {
				System.out.println("Vegetarian");
			}
			else {
				System.out.println("Non-Vegetarian");
			}
			
		}
		
	}
	private static int finder(String look, String[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals(look)) {
				return i;
			}
		}
		return 0;
	}
}

// Helper Method for finding ingredient index

/*
Avocado_Roll:
52 calories
$0.47
Vegetarian
Unagi_Nigiri:
91 calories
$1.73
Non-Vegetarian
KMP_Roll:
101 calories
$2.01
Non-Vegetarian
Salmon_Sashimi:
38 calories
$1.42
Non-Vegetarian
*/

/*6
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
*/

