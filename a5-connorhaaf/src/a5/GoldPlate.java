package a5;

public class GoldPlate extends PlateImpl {
	double associatedPrice;
	Plate.Color associatedColor = Plate.Color.GOLD;

	public GoldPlate(Sushi contents, double price) throws PlatePriceException {
		super(contents, price, Plate.Color.GOLD);		
		associatedPrice = price;
		if (contents != null && contents.getCost() > associatedPrice) {
			throw new PlatePriceException("Illegal plate price");
		}
		if (price < 5) {
			throw new IllegalArgumentException("This needs to cost more");
		}
	}
}