package sushigame.view;

import java.util.Comparator;

import sushigame.model.Chef;

public class HighToLowBalanceComparator implements Comparator<Chef> {

	@Override
	public int compare(Chef one, Chef two) {
		// We do b - a because we want largest to smallest
		return (int) (Math.round(two.getBalance()*100.0) - 
				Math.round(one.getBalance()*100));
	}			
}
