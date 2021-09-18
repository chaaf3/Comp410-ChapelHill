
import java.util.Iterator;
import java.util.NoSuchElementException;
public class BeltIterator implements Iterator {

	private Belt belt;
	private int startingPosition;
	private int lastIndexReturned;
	
	public BeltIterator(Belt belt, int startingPosition) {
		this.belt = belt;
		this.startingPosition = startingPosition;
		lastIndexReturned = -1;
	}
	
	public boolean hasNext() {
		boolean test = false;
		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i + startingPosition) != null) {
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
		lastIndexReturned = startingPosition;
		startingPosition++;
		return plate;
	}
	
	
	public void remove() {
		if (lastIndexReturned < 0) {
			throw new RuntimeException("nothing to remove");
		}
		belt.removePlateAtPosition(lastIndexReturned);
		lastIndexReturned = -1;
	}

}
