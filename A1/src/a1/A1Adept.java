package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int itemsBought = scan.nextInt();
		//item name and item price are general values to be accessed to find people's purchase values
		String[] itemName = new String[itemsBought];
		double[] itemPrice = new double[itemsBought];
		
		for (int i = 0; i < itemsBought; i++) {
			itemName[i] = scan.next();
			itemPrice[i] = scan.nextDouble();
		}
		//numPeople is the number of people that we have information on
		int numPeople = scan.nextInt();
		String[] fullNames = new String[numPeople];
		double[] pplMoney = new double[numPeople];
		String concat;
		int numBought;
		int multiplier;
		double price = 0.00000;
		double sumPrice = 0.0000;
		String nameToLookFor;
		double smallest = 9999999.00000;
		String smallestName = "";
		double largest = -9999999.00000;
		String largestName = "";
		double average = 0.00000;
		for (int i = 0; i < numPeople; i++) {
			price = 0.00000;
			sumPrice = 0.00000;
			concat = scan.next() + " " + scan.next();
			fullNames[i] = concat;
			numBought = scan.nextInt();
			for (int j = 0; j < numBought; j++) {
				// multiplier is the number of a given item that a person buys
				multiplier = scan.nextInt();
				// nameToLookFor is the name of the given item that a person is buying
				nameToLookFor = scan.next();
				// at this point I have all the information stored and need to break it down
				price = findCost(nameToLookFor, itemName, itemPrice);
				sumPrice += price * multiplier;
				}
			if (sumPrice < smallest) {
				smallest = sumPrice;
				smallestName = fullNames[i];
				}
			if (sumPrice > largest) {
				largest = sumPrice;
				largestName = fullNames[i];
			}
			average += sumPrice;
			}
		
		average /= numPeople;

				//System.out.printf("%,.2f%n", value);
		System.out.println("Biggest: " + largestName + " (" + String.format("%.2f", largest) + ")");
		System.out.println("Smallest: " + smallestName + " (" + String.format("%.2f", smallest) + ")");
		System.out.println("Average: " + String.format("%.2f", average));
		scan.close();
		}
		
	
	
	public static double findCost (String name, String[] allItems, double[] ItemsCost) {
		int indexOfIntrest = 0;
		for (int i = 0; i < allItems.length; i++) {
			if (name.equals(allItems[i])) {
				indexOfIntrest = i;
			}
		}
		return ItemsCost[indexOfIntrest];
	}
	
	// You can define / use static helper methods here.
	//new comment
}

/*
 *6
Apple 0.25
Banana 0.75
Milk 3.15
Orange 1.25
Salami 2.50
Sponge 1.15
3 
Carrie Brownstein 3 2 Banana 1 Orange 2 Milk
Corin Tucker 2 3 Banana 2 Sponge
Janet Weiss 1 5 Salami
*/

/*
 *Biggest: Janet Weiss (12.50)
Smallest: Corin Tucker (4.55)
Average: 8.70
*/
