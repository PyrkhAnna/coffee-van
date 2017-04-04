package com.epam.coffee_van.entity;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Van {
	private final static Logger Log = LogManager.getLogger("Van.class");
	private List<Coffee> purchaseList;
	private int capacity;

	public Van() {
		purchaseList = new ArrayList<Coffee>();
		capacity = 0;
		Log.info("New Van is created");
	}

	public Van(int capacity) {
		purchaseList = new ArrayList<Coffee>();
		this.capacity = capacity;
		Log.info("New Van is created");
	}

	public Van(List<Coffee> purchaseList, int capacity) {
		this.purchaseList = new ArrayList<Coffee>(purchaseList);
		this.capacity = capacity;
		Log.info("New Van is created");
	}

	public boolean addPurchase(Coffee coffee) {
		if (purchaseList.add(coffee)) {
			return true;
		} else {
			return false;
		}
	}

	public List<Coffee> getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(List<Coffee> purchaseList) {
		this.purchaseList = purchaseList;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + ((purchaseList == null) ? 0 : purchaseList.hashCode());
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
		Van other = (Van) obj;
		if (capacity != other.capacity)
			return false;
		if (purchaseList == null) {
			if (other.purchaseList != null)
				return false;
		} else if (!purchaseList.equals(other.purchaseList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Van [purchaseList=" + purchaseList + ", capacity=" + capacity + "]";
	}
}
