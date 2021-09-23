package a6;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PriceThresholdBeltIterator implements Iterator {

	private Belt belt;
	private int startingPosition;
	private double maxPrice;
	
	public PriceThresholdBeltIterator(Belt belt, int startingPosition, double maxPrice) {
		this.belt = belt;
		this.startingPosition = startingPosition;
		this.maxPrice = maxPrice;
	}
	
	public boolean hasNext() {
		boolean test = false;
		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i + startingPosition) != null && belt.getPlateAtPosition(i + startingPosition).getPrice() <= maxPrice) {
				startingPosition = i + startingPosition;
				return true;
			}
		}
		return false;
	}
	public Plate next() {
		if (belt == null) {
			throw new NoSuchElementException();
		}
		if (hasNext() == false) {
			throw new RuntimeException("there is no new plate");
		}
		Plate plate = belt.getPlateAtPosition(startingPosition);
		startingPosition++;
		return plate;
	}

}
