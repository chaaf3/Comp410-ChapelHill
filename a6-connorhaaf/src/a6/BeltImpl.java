package a6;

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
	public void rotate() {
		Plate[] newList = new Plate[beltSize];
		for (int i = 1; i < beltSize - 1; i++) {
			newList[i] = plateArray[i-1];
		}
		newList[0] = plateArray[beltSize - 1];
		plateArray = newList;
	}
	
	public Iterator<Plate> iterator(double maxPrice) {
		return new PriceThresholdBeltIterator(this, 0, maxPrice);
	}
	
	public Iterator<Plate> iteratorFromPosition(int position, double maxPrice){
		return new PriceThresholdBeltIterator(this, position, maxPrice);
	}
	
	public Iterator<Plate> iterator(Plate.Color color) {
		return new ColorFilteredBeltIterator(this, 0, color);
	}
	
	public Iterator<Plate> iteratorFromPosition(int position, Plate.Color color) {
		return new ColorFilteredBeltIterator(this, 0, color);
	}
}
