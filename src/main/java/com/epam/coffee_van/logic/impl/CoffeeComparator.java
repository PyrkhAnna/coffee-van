package com.epam.coffee_van.logic.impl;

import java.util.Comparator;

import com.epam.coffee_van.entity.Coffee;

public class CoffeeComparator implements Comparator <Coffee>{

	@Override
	public int compare(Coffee o1, Coffee o2) {
		int comparePrice = o1.getPrice().compareTo(o2.getPrice());
		int compareWeight = o1.getWeight() - o2.getWeight();
		return (comparePrice != 0 ? comparePrice : compareWeight);
	}
}
