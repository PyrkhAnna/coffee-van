package com.epam.coffee_van.logic;

import java.util.List;
import com.epam.coffee_van.entity.Coffee;
import com.epam.coffee_van.entity.Van;

public interface CoffeeSeacher {
	public List<Coffee> findPurchase (Van van, String type, String value);
}
