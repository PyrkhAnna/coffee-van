package com.epam.coffee_van.logic.impl;

import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.coffee_van.entity.Coffee;
import com.epam.coffee_van.entity.Van;
import com.epam.coffee_van.logic.UploadVan;

public class VanLogic implements UploadVan {
	private final static Logger Log = LogManager.getLogger("VanLogicImpl.class");
	private int purchasesWeight;
	private BigDecimal expenses;
	private Van van;

	public VanLogic(Van van) {
		this.van = van;
		purchasesWeight = 0;
		expenses = new BigDecimal("0");
	}

	public boolean loadToVan(Coffee coffee) {
		if (checkPurchasesWeight(coffee.getWeight())) {
			if (van.addPurchase(coffee)) {
				countPurchasesWeight(coffee.getWeight());
				countExpenses(coffee.getPrice());
				Log.info("Load Coffee to Van");
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public int getPurchasesWeight() {
		return purchasesWeight;
	}

	public void setPurchasesWeight(int purchasesWeight) {
		this.purchasesWeight = purchasesWeight;
	}

	public BigDecimal getExpenses() {
		return expenses;
	}

	public void setExpenses(BigDecimal expenses) {
		this.expenses = expenses;
	}

	public Van getVan() {
		return van;
	}

	public void setVan(Van van) {
		this.van = van;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expenses == null) ? 0 : expenses.hashCode());
		result = prime * result + purchasesWeight;
		result = prime * result + ((van == null) ? 0 : van.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VanLogic other = (VanLogic) obj;
		if (expenses == null) {
			if (other.expenses != null)
				return false;
		} else if (!expenses.equals(other.expenses))
			return false;
		if (purchasesWeight != other.purchasesWeight)
			return false;
		if (van == null) {
			if (other.van != null)
				return false;
		} else if (!van.equals(other.van))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VanLogicImpl [purchasesWeight=" + purchasesWeight + ", expenses=" + expenses + ", van=" + van + "]";
	}

	private void countPurchasesWeight(int weight) {
		purchasesWeight = +weight;
	}

	private void countExpenses(BigDecimal price) {
		expenses = expenses.add(price);
	}

	private boolean checkPurchasesWeight(int weight) {
		int check = this.purchasesWeight + weight;
		return check <= van.getCapacity();
	}
}
