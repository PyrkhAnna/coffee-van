package com.epam.coffee_van.logic.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.epam.coffee_van.entity.Coffee;
import com.epam.coffee_van.entity.InstantCoffee;
import com.epam.coffee_van.entity.NaturalCoffee;
import com.epam.coffee_van.entity.Van;
import com.epam.coffee_van.logic.CoffeeSeacher;

public class CoffeeVanSeacher implements CoffeeSeacher {
	private List<Coffee> foundList = new ArrayList<Coffee>();

	@Override
	public List<Coffee> findPurchase(Van van, String type, String value) {
		if (van != null) {
			List<Coffee> purchaseList = van.getPurchaseList();
			if (!purchaseList.isEmpty() && purchaseList != null && type != null && value != null) {
				doSearch(purchaseList, type, value);
			} 
		} 
		return foundList;
	}

	private void doSearch(List<Coffee> purchaseList, String type, String value) {
		switch (type.toUpperCase()) {
		case "BREND":
			seachCoffeeByString(purchaseList, value);
			break;
		case "TYPEBEANS":
			seachCoffeeByString(purchaseList, value);
			break;
		case "WRAPPER":
			seachCoffeeByString(purchaseList, value);
			break;
		case "WEIGHT":
			seachCoffeeByNumber(purchaseList, Integer.parseInt(value));
			break;
		case "PRICE":
			seachCoffeeByNumber(purchaseList, new BigDecimal(value));
			break;
		case "ROASTINGDEGREE":
			seachNaturalCoffeeByString(purchaseList, value);
			break;
		case "GRIDINGDEGREE":
			seachNaturalCoffeeByString(purchaseList, value);
			break;
		case "PRODUCTION":
			seachInstantCoffeeByString(purchaseList, value);
			break;
		}
	}

	private boolean seachCoffeeByNumber(List<Coffee> purchaseList, Number value) {
		boolean flag = false;
		for (Coffee coffee : purchaseList) {
			if (value.equals(coffee.getPrice()) || value.equals(coffee.getWeight())) {
				flag = foundList.add(coffee);
			}
		}
		return flag;
	}

	private boolean seachCoffeeByString(List<Coffee> purchaseList, String value) {
		boolean flag = false;
		for (Coffee coffee : purchaseList) {
			if (value.equals(coffee.getBrend()) || value.equals(coffee.getTypeBeans())
					|| value.equals(coffee.getWrapper())) {
				flag = foundList.add(coffee);
			}
		}
		return flag;
	}

	private boolean seachNaturalCoffeeByString(List<Coffee> purchaseList, String value) {
		boolean flag = false;
		for (Coffee coffee : purchaseList) {
			if (coffee.getClass() == NaturalCoffee.class) {
				if (value.equals(((NaturalCoffee) coffee).getRoastingDegree())
						|| value.equals(((NaturalCoffee) coffee).getGridingDegree())) {
					flag = foundList.add(coffee);
				}
			}
		}
		return flag;
	}

	private boolean seachInstantCoffeeByString(List<Coffee> purchaseList, String value) {
		boolean flag = false;
		for (Coffee coffee : purchaseList) {
			if (coffee.getClass() == InstantCoffee.class) {
				if (value.equals(((InstantCoffee) coffee).getProduction())) {
					flag = foundList.add(coffee);
				}
			}
		}
		return flag;
	}
}
