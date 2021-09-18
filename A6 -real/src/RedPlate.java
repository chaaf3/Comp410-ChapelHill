

public class RedPlate extends PlateImpl {
	double associatedPrice = 1.0;
	Plate.Color associatedColor = Plate.Color.RED;

	public RedPlate(Sushi contents) throws PlatePriceException {
		super(contents, 1.0, Plate.Color.RED);
		if (contents != null && contents.getCost() > associatedPrice) {
			throw new PlatePriceException("Illegal plate price");
		}
			
	}
}