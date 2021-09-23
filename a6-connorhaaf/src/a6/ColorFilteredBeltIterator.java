package a6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ColorFilteredBeltIterator implements Iterator {

		private Belt belt;
		private int startingPosition;
		private Plate.Color color;
		
		public ColorFilteredBeltIterator(Belt belt, int startingPosition, Plate.Color color) {
			this.belt = belt;
			this.startingPosition = startingPosition;
			this.color = color;
		}
		
		public boolean hasNext() {
			boolean test = false;
			for (int i = 0; i < belt.getSize(); i++) {
				if (belt.getPlateAtPosition(i + startingPosition) != null && belt.getPlateAtPosition(i + startingPosition).getColor() == color) {
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
