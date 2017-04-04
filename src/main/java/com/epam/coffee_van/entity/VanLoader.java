package com.epam.coffee_van.entity;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VanLoader {
	private final static Logger Log = LogManager.getLogger("VanLoader.class");
	private List<Coffee> stockList;
	private BigDecimal budget;
	private Van van;
	
	public VanLoader(List<Coffee> stockList, BigDecimal budget, Van van) {
		super();
		this.stockList = stockList;
		this.budget = budget;
		this.van = van;
		Log.info("New VanLoader is created");
	}

	public List<Coffee> getStockList() {
		return stockList;
	}

	public void setStockList(List<Coffee> stockList) {
		this.stockList = stockList;
	}

	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
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
		result = prime * result + ((budget == null) ? 0 : budget.hashCode());
		result = prime * result + ((stockList == null) ? 0 : stockList.hashCode());
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
		VanLoader other = (VanLoader) obj;
		if (budget == null) {
			if (other.budget != null)
				return false;
		} else if (!budget.equals(other.budget))
			return false;
		if (stockList == null) {
			if (other.stockList != null)
				return false;
		} else if (!stockList.equals(other.stockList))
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
		return "VanLoader [stockList=" + stockList + ", budget=" + budget + ", van=" + van + "]";
	}
}
