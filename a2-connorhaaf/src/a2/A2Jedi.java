package a2;

import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numItems = scan.nextInt();
		String[] ingredientName = new String[numItems];
		double[] pricePerOunce = new double[numItems];
		boolean[] isVegetarian = new boolean[numItems];
		int[] caloriesPerOunce = new int[numItems];
		for (int i = 0; i < numItems; i++) {
			ingredientName[i] = scan.next();
			pricePerOunce[i] = scan.nextDouble();
			isVegetarian[i] = scan.nextBoolean();
			caloriesPerOunce[i] = scan.nextInt();
		}
		
		// start looking here for information for this problem
		// before this point was intake values
		int numMenueItems = scan.nextInt();
		String[] dishName = new String[numMenueItems];
		int[] numIngredientsPerDish = new int[numMenueItems];
		//store the weights with each name
		int[] finalWeights = new int[numItems];
		String[][] nameIngredientsPerDish = new String[numMenueItems][];
		double[][] weightOfIngredient = new double[numMenueItems][];
		for (int i = 0; i < numMenueItems; i++) {
			dishName[i] = scan.next();
			numIngredientsPerDish[i] = scan.nextInt();
			nameIngredientsPerDish[i] = new String[numIngredientsPerDish[i]];
			weightOfIngredient[i] = new double[numIngredientsPerDish[i]];
			for(int j = 0; j < numIngredientsPerDish[i]; j++) {
				nameIngredientsPerDish[i][j] = scan.next();
				weightOfIngredient[i][j] = scan.nextDouble();
			}
		}
		System.out.print("The order will require:");
		String orderName = "HELLO";
		int ind;
		int indTwo;
		String ing;
		while (!orderName.equals("EndOrder")) {
			orderName = scan.next();
			ind = finder(orderName, dishName);
			for(int i = 0; i < numIngredientsPerDish[ind]; i++) {
				ing = nameIngredientsPerDish[ind][i];
				indTwo = finder(ing, ingredientName);
				finalWeights[indTwo] += weightOfIngredient[ind][i];
			}
			//ind2 = finder(order, ingredientName);
			
		}
		for (int i = 0; i < finalWeights.length; i++) {
			System.out.print(finalWeights[i]);
			System.out.print(" Ounces of ");
			System.out.println(ingredientName[i]);
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

