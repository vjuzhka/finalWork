package com.accenture.finalproject.farm;

public class Farmers {
	private String name;
	private int foodAmount;
	private double budget;
	private boolean activeStatus;

	public Farmers(String name, int foodAmount, double budget) {
		this.name = name;
		this.foodAmount = foodAmount;
		this.budget = budget;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFoodAmount() {
		return foodAmount;
	}

	public void setFoodAmount(int foodAmount) {
		this.foodAmount = foodAmount;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	private boolean checkStatus() {
		if (this.activeStatus) {
			return true;
		}
		return false;
	}

	public void rename(String name) {
		System.out.println(this.name + " was renamed to " + name);
		setName(name);
	}

	public void sellFood(int foodAmount, double price) {
		this.foodAmount = this.foodAmount - foodAmount;
		this.budget = this.budget + price;
		System.out.println("Farmer " + this.name + " sold " + foodAmount
				+ "kg for " + price + " EUR");
	}
	
	private boolean checkFood (int givingFoodAmount) {
		if (this.foodAmount > givingFoodAmount) {
			return true;
		} else {
			System.out.println("Sorry, farmer " + this.name + "doesn't have "
				+ givingFoodAmount + "kg of food");
			return false;
		} 
	}
	
	private boolean checkMoney (double givingMoneyAmount) {
		if (this.budget > givingMoneyAmount) {
			return true;
		} else {
			System.out.println("Sorry, farmer " + this.name + "doesn't have "
				+ givingMoneyAmount + "EUR");
			return false;
		} 
	}
		
	public void giveFood(Farmers farmer, int givingFoodAmount) {
		if (this.checkFood(givingFoodAmount)) {
			farmer.foodAmount = farmer.foodAmount + givingFoodAmount;
			this.foodAmount = this.foodAmount - givingFoodAmount;
		} else {
			System.out.println("Sorry, farmer " + this.name + "doesn't have "
					+ givingFoodAmount + "kg of food to donate them to "
					+ farmer.name);
		}
	}

	public void purchaseFrom(Farmers farmer, int foodAmount, double money) {
		if (farmer.checkFood(foodAmount)) {
		} else if (this.checkMoney(money)) {
			} else {
			farmer.budget = farmer.budget + money;
			this.budget = this.budget - money;
			farmer.foodAmount = farmer.foodAmount - foodAmount;
			this.foodAmount = this.foodAmount + foodAmount;

		}
	}

	public void giftMoneyTo(Farmers farmer, double giftedMoney) {
		if (this.checkMoney(giftedMoney)) {
			
/// zdesj povtor				
			farmer.budget = farmer.budget + giftedMoney;
			this.budget = this.budget - giftedMoney;
		} 
	}
	
	public void stealMoneyFrom(Farmers farmer, double money) {
		if (farmer.checkMoney(money)) {
			
/// zdesj povtor			
			farmer.budget = farmer.budget - money;
			this.budget = this.budget + money;
			System.out.println(this.name + " Steal " + money + " from"
				+ farmer.name);
		}
	}

	public String toString() {
		return "Farmers [name = " + name + ", food = " + foodAmount
				+ " kg, budget = " + budget + " EUR]";
	}

}
