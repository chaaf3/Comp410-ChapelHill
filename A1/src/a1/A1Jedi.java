package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		No customers bought Apple
		2 customers bought 5 Banana
		1 customers bought 2 Milk
		1 customers bought 1 Orange
		1 customers bought 5 Salami
		1 customers bought 2 Sponge

		6
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
		int numItems = scan.nextInt();
		String[] itemNames = new String[numItems];
		int[] pplWhoGotThisItem = new int[numItems];
		int[] numItemPurchased = new int[numItems];
		double scrap = 0;
		String orig = "hi";
		String scrapped;
		for (int i = 0; i < numItems; i++) {
			itemNames[i] = scan.next();
			scrap = scan.nextDouble();
		}
		int numPPL = scan.nextInt();
		int numItemsPerPerson;
		int indexHolder;
		int numItemFromPerson;
		boolean[] found = new boolean[numItems];
		for (int i = 0; i < numPPL; i++) {
			scrapped = scan.next();
			scrapped = scan.next();
			numItemsPerPerson = scan.nextInt();
			for (int j = 0; j < numItemsPerPerson; j++) {
				numItemFromPerson = scan.nextInt();
				scrapped = scan.next();
				indexHolder = indexFinder(itemNames, scrapped);
				//add one to the number of ppl buying type
				// some sort of secondary condition needs to happen here that makes it so that the people number doesn't increase
				if (!(orig.equals(scrapped))) {
					found[i] = true;
				}
				orig = scrapped;
				//add number to total of an item purchased
				numItemPurchased[indexHolder] += numItemFromPerson;
			}
		}
		
		for(int i = 0; i < numItems; i++) {
			if(found[i]) {
				pplWhoGotThisItem[i]++;
			}
		}
		for(int i = 0; i < numItems; i++) {
			if (pplWhoGotThisItem[i] == 0) {
				System.out.println("No customers bought " + itemNames[i]);
			}
			else {
			System.out.println(pplWhoGotThisItem[i] + " customers bought " + numItemPurchased[i] + " " + itemNames[i]);
			}
		}
		scan.close();
	}
	
	public static int indexFinder(String[] s1, String s2) {
		int indexH = 0;
		for (int i = 0; i < s1.length; i++) {
			if (s1[i].equals(s2)) {
				indexH = i;
			}
		}
		return indexH;
	}
}


/*
No customers bought Apple
2 customers bought 5 Banana
1 customers bought 2 Milk
1 customers bought 1 Orange
1 customers bought 5 Salami
1 customers bought 2 Sponge

6
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
