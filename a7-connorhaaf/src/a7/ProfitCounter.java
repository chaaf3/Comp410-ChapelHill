package a7;

import comp401sushi.Plate;

public class ProfitCounter implements BeltObserver {
	private int numPlates;
	private double profit;
	private Belt b;


	public ProfitCounter(Belt b) {
		
			if (b == null) {
				throw new IllegalArgumentException();
			}
			this.b = b;
			this.b.addBeltObserver(this);
			
			for (int i = 0; i < b.getSize(); i++) {
				if (b.getPlateAtPosition(i) != null) {
					numPlates++;
					profit += b.getPlateAtPosition(i).getProfit();
				}
			}
	}

	@Override
	public void handlePlateEvent(PlateEvent e) {
		if (e.getType() == PlateEvent.EventType.PLATE_PLACED) {
			profit += e.getPlate().getProfit();
			numPlates++;
		}
		
		else if (e.getType() == PlateEvent.EventType.PLATE_REMOVED) {
				profit -= e.getPlate().getProfit();
				numPlates--;
		}
	}
	public double getTotalBeltProfit() {
		return profit;
		
	}
	public double getAverageBeltProfit() {
		if (numPlates == 0)
			return 0;
		return profit/ (double) numPlates;
	}

}
