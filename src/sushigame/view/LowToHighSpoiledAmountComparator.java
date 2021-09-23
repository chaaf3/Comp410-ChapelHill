package sushigame.view;

import java.util.Comparator;

import sushigame.model.Chef;

public class LowToHighSpoiledAmountComparator implements Comparator<Chef>{

	public int compare(Chef a, Chef b) {
		return (int) (Math.round(a.getSpoiledAmount()*100) - (Math.round(b.getSpoiledAmount()*100.0)));
	}

}
