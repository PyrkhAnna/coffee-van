package com.epam.coffee_van.logic.impl;

import java.math.BigDecimal;
import com.epam.coffee_van.entity.Coffee;
import com.epam.coffee_van.entity.VanLoader;
import com.epam.coffee_van.logic.Uploader;
public class VanLoaderLogic implements Uploader {
	private VanLoader loader;
	private VanLogic vanLogic;

	public VanLoaderLogic(VanLoader loader) {
		super();
		this.loader = loader;
		this.vanLogic = new VanLogic(loader.getVan());
	}
	
	public boolean loadFromStock() {
		boolean flag = true;
		if (ifInit()) {
			int i=0;
			Coffee coffee;
			BigDecimal cost;
			do {
				coffee=takeFromStock(i);
				cost = coffee.getPrice().add(vanLogic.getExpenses());
				if (checkBudget(cost)&&vanLogic.loadToVan(coffee)) {
					flag = false;
				}
				i++;
			} while (i<loader.getStockList().size()&&flag);
		}
		return flag;
	}
		
	public VanLoader getLoader() {
		return loader;
	}

	public void setLoader(VanLoader loader) {
		this.loader = loader;
	}

	public VanLogic getVanLogic() {
		return vanLogic;
	}

	public void setVanLogic(VanLogic vanLogic) {
		this.vanLogic = vanLogic;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loader == null) ? 0 : loader.hashCode());
		result = prime * result + ((vanLogic == null) ? 0 : vanLogic.hashCode());
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
		VanLoaderLogic other = (VanLoaderLogic) obj;
		if (loader == null) {
			if (other.loader != null)
				return false;
		} else if (!loader.equals(other.loader))
			return false;
		if (vanLogic == null) {
			if (other.vanLogic != null)
				return false;
		} else if (!vanLogic.equals(other.vanLogic))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VanLoaderLogic [loader=" + loader + ", vanLogic=" + vanLogic + "]";
	}

	private Coffee takeFromStock(int index) {
		return loader.getStockList().get(index);
	}

	private boolean ifInit() {
		return loader != null && loader.getStockList() != null && !loader.getStockList().isEmpty()
				&& loader.getBudget() != null && loader.getVan() != null && loader.getVan().getPurchaseList() != null
				&& !loader.getStockList().isEmpty() && loader.getVan().getCapacity() != 0;
	}

	private boolean checkBudget(BigDecimal cost) {
		return loader.getBudget().compareTo(cost) == 1;
	}
}
