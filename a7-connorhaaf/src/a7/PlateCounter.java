package a7;

import comp401sushi.Plate;

public class PlateCounter implements BeltObserver {
	private int redPlate;
	private int bluePlate;
	private int greenPlate;
	private int goldPlate;
	private Belt b;

	public PlateCounter(Belt b) {
		
		if (b == null) {
			throw new IllegalArgumentException();
		}
		this.b = b;
		this.b.addBeltObserver(this);
		redPlate = 0;
		bluePlate = 0;
		greenPlate = 0;
		goldPlate = 0;
		for (int i = 0; i < b.getSize(); i++) {
			if (b.getPlateAtPosition(i) != null) {
				if (b.getPlateAtPosition(i).getColor() == Plate.Color.RED) {
					redPlate++;
				}
				else if (b.getPlateAtPosition(i).getColor() == Plate.Color.BLUE) {
					bluePlate++;
				}
				else if (b.getPlateAtPosition(i).getColor() == Plate.Color.GREEN) {
					greenPlate++;
				}
				else if (b.getPlateAtPosition(i).getColor() == Plate.Color.GOLD) {
					goldPlate++;
				}
			}
		}
			
	}
	public int getRedPlateCount() {
		return redPlate;
	}
	public int getGreenPlateCount() {
		return greenPlate;
	}
	public int getBluePlateCount() {
		return bluePlate;
	}
	public int getGoldPlateCount() {
		return goldPlate;
	}

	@Override
	public void handlePlateEvent(PlateEvent e) {
		if (e.getType() == PlateEvent.EventType.PLATE_PLACED) {
			if (e.getPlate().getColor() == Plate.Color.BLUE) {
				bluePlate++;
			}
			if (e.getPlate().getColor() == Plate.Color.RED) {
				redPlate++;
			}
			if (e.getPlate().getColor() == Plate.Color.GREEN) {
				greenPlate++;
			}
			if (e.getPlate().getColor() == Plate.Color.GOLD) {
				goldPlate++;
			}
		}
		
		else if (e.getType() == PlateEvent.EventType.PLATE_REMOVED) {
			if (e.getPlate().getColor() == Plate.Color.BLUE) {
				bluePlate--;
			}
			if (e.getPlate().getColor() == Plate.Color.RED) {
				redPlate--;
			}
			if (e.getPlate().getColor() == Plate.Color.GREEN) {
				greenPlate--;
			}
			if (e.getPlate().getColor() == Plate.Color.GOLD) {
				goldPlate--;
			}
		}

	}

}
