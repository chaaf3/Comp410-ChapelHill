

public class BluePlate extends PlateImpl {
	double associatedPrice = 4.0;
	Plate.Color associatedColor = Plate.Color.BLUE;

	public BluePlate(Sushi contents) throws PlatePriceException {
		super(contents, 4.0, Plate.Color.BLUE);
		if (contents != null && contents.getCost() > associatedPrice) {
			throw new PlatePriceException("Illegal plate price");
		}
			
	}
}
