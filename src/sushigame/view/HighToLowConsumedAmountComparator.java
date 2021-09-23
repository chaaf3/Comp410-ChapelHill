package sushigame.view;
import java.util.Comparator;

import sushigame.model.Chef;
import sushigame.model.HistoricalPlateImpl;

public class HighToLowConsumedAmountComparator implements Comparator<Chef> {

	public int compare(Chef a, Chef b) {
		return (int) (Math.round(b.getConsumedAmount()*100.0) - 
				Math.round(a.getConsumedAmount()*100));
	}

}
