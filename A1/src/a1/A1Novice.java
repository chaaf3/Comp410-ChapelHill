package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName;
		String lastName;
		int priceMultiplier;
		String scrapStep;
		double price;
		double priceHolder;
		int scani = scan.nextInt();
		int scanj;
		for(int i = 0; i < scani; i++) {
			priceHolder = 0;
			firstName = scan.next();
			lastName = scan.next();
			scanj = scan.nextInt();
			for(int j = 0; j < scanj; j++) {
				priceMultiplier = scan.nextInt();
				scrapStep = scan.next();
				price = scan.nextDouble();
				priceHolder += priceMultiplier * price;
				
			}
			System.out.println(firstName.charAt(0) + ". " + lastName + ": " + String.format("%.2f",priceHolder));
		}
		scan.close();
	}
}

/*
3
Carrie Brownstein 3
2 Banana 0.75
1 Orange 1.25
2 Milk 3.15
Corin Tucker 2
3 Banana 0.75
2 Sponge 1.15
Janet Weiss 1
5 Salami 2.50
*/