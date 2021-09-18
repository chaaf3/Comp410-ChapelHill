

public class PlateImpl implements Plate {
	private Sushi sushi;
	double associatedPrice;
	Plate.Color associatedColor;

	public PlateImpl(Sushi contents, double associatedPrice, Color associatedColor) throws PlatePriceException {
		
		this.sushi = contents;
		this.associatedColor = associatedColor;
		this.associatedPrice = associatedPrice;
	}

	@Override
	public Sushi getContents() {
		if (sushi == null) {
			return null;
		}
		return sushi;
	}

	@Override
	public Sushi removeContents() {
		if (this.sushi.getCalories() == 0) {
			return null;
		}
		else {
			Sushi pointer = sushi;
			sushi = null;
			return pointer;
		}
	}

	@Override
	public void setContents(Sushi s) throws PlatePriceException {
		if (s.equals(null)) {
			throw new IllegalArgumentException("sushi must exist");
		}
		else if (s.getCost() >= this.getPrice()) {
			throw new PlatePriceException("Illegal plate price");
		}
		else {
			this.sushi = s;
		}
	}

	@Override
	public boolean hasContents() {
		if (sushi.equals(null)) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public double getPrice() {
		return this.associatedPrice;
	}

	@Override
	public Color getColor() {
		return associatedColor;
	}

	@Override
	public double getProfit() {
		if (sushi == null) {
			return 0.0;
		}
		else {
			double holder = this.getPrice() - sushi.getCost() - .001;
			holder = holder * 100;
			holder = Math.round(holder);
			holder = holder / 100;
			return holder;
		}
	}

}
