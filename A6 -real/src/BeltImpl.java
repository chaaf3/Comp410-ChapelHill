
import java.util.NoSuchElementException;
import java.util.Iterator;
public class BeltImpl implements Belt, Iterable {
	private int beltSize;
	private Plate[] plateArray;

	public BeltImpl(int beltSize) {
		if (beltSize < 0) {
			throw new IllegalArgumentException("fix the size");
		}
		this.beltSize = beltSize;
		plateArray = new Plate[beltSize]; 
	}

	@Override
	public int getSize() {
		return this.beltSize;
	}
	
	public Plate getPlateAtPosition(int position) {
		int normalized_position = ((position % plateArray.length) + plateArray.length) % plateArray.length;
		return plateArray[normalized_position];
	}
	
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		int normalized_position = ((position % this.plateArray.length) + this.plateArray.length) % this.plateArray.length;
		position = normalized_position;
		if (plate == null) {
			throw new IllegalArgumentException("fix the Plate");
		}
		else if (this.plateArray[position] != null) {
			throw new BeltPlateException(position, plate, this);
		}
		else {
			plateArray[position] = plate;
		}
	}

	@Override
	public void clearPlateAtPosition(int position) {
		int normalized_position = ((position % this.plateArray.length) + this.plateArray.length) % this.plateArray.length;
		position = normalized_position;
		plateArray[position] = null;
	}
	
	public Plate removePlateAtPosition(int position) {
		int normalized_position = ((position % this.plateArray.length) + this.plateArray.length) % this.plateArray.length;
		position = normalized_position;
		Plate holder = plateArray[position];
		if (plateArray[position] == null) {
			throw new NoSuchElementException();
		}
		else {
			clearPlateAtPosition(position);
		}
		return holder;
	}
	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		int normalized_position = ((position % this.plateArray.length) + this.plateArray.length) % this.plateArray.length;
		position = normalized_position;
		int holder = 0;
		boolean test = false;
		for (int i = position; i < plateArray.length; i++) {
			if (plateArray[i] == null) {
				holder = i;
				test = true;
				plateArray[i] = plate;
				break;
			}
		}
		if (!test) {
			for (int i = 0; i < position; i++) {
				if (plateArray[i] == null) {
					holder = i;
					test = true;
					plateArray[i] = plate;
					break;
			}
		}	
	}
		if (!test) {
			throw new BeltFullException(this);
		}
		return holder;

	}
	public Iterator<Plate> iterator() {
		return new BeltIterator(this, 0);
	}
	public Iterator<Plate> iteratorFromPosition(int position) {
		return new BeltIterator(this, position);
	}
}
