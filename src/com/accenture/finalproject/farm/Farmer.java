package com.accenture.finalproject.farm;

public class Farmer {
	private String name;
	private int foodAmount;
	private double budget;
	private boolean activeStatus = false;

	public Farmer(String name, int foodAmount, double budget) {
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

	private boolean checkFood(int givingFoodAmount) {
		if (this.foodAmount > givingFoodAmount) {

			return true;
		} else {
			System.out.println("Sorry, farmer " + this.name + " doesn't have "
					+ givingFoodAmount + "kg of food");
			return false;
		}
	}

	private boolean checkMoney(double givingMoneyAmount) {
		if (this.budget > givingMoneyAmount) {
			return true;
		} else {
			System.out.println("Sorry, farmer " + this.name + " doesn't have "
					+ givingMoneyAmount + "EUR");
			return false;
		}
	}
	
	private void foodExchange (Farmer farmer, int foodAmount ) {
		farmer.foodAmount = farmer.foodAmount + foodAmount;
		this.foodAmount = this.foodAmount - foodAmount;
	}

	public void giveFood(Farmer farmer, int givingFoodAmount) {
		if (this.checkFood(givingFoodAmount)) {
			this.foodExchange(farmer, givingFoodAmount);
			System.out.println(this.name + " gifted " + givingFoodAmount + " kg of food to "
					+ farmer.name);
		} else {
			System.out.println("Sorry, farmer " + this.name + "doesn't have "
					+ givingFoodAmount + "kg of food to donate them to "
					+ farmer.name);
		}
	}

	public void purchaseFrom(Farmer farmer, int foodAmount, double money) {
		if (farmer.checkFood(foodAmount) && (this.checkMoney(money))) {
			this.moneyExchange(farmer, money);
			farmer.foodExchange(this, foodAmount);
			System.out.println(this.name + " purchased " + foodAmount + " kg of food from  "
					+ farmer.name + " for " + money + " EUR");

		}
	}

	private void moneyExchange(Farmer farmer1, double money) {
		farmer1.budget = farmer1.budget + money;
		this.budget = this.budget - money;
	}

	public void giftMoneyTo(Farmer farmer, double giftedMoney) {
		if (this.checkMoney(giftedMoney)) {
			this.moneyExchange(farmer, giftedMoney);
			System.out.println(this.name + " gifted " + giftedMoney + " EUR to "
					+ farmer.name);
		}
	}

	public void stealMoneyFrom(Farmer farmer, double money) {
		if (farmer.checkMoney(money)) {
			farmer.moneyExchange(this, money);
			System.out.println(this.name + " Steal " + money + " from "
					+ farmer.name + " EUR");
		} 
	}

	public String toString() {
		return "Farmers [name = " + name + ", food = " + foodAmount
				+ " kg, budget = " + budget + " EUR]";
	}

}
