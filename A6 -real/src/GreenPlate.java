

public class GreenPlate extends PlateImpl {
	double associatedPrice = 2.0;
	Plate.Color associatedColor = Plate.Color.GREEN;

	public GreenPlate(Sushi contents) throws PlatePriceException {
		super(contents, 2.0, Plate.Color.GREEN);
		if (contents != null && contents.getCost() > associatedPrice) {
			throw new PlatePriceException("Illegal plate price");
		}
			
	}
}