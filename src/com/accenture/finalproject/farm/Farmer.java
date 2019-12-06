package com.accenture.finalproject.farm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Farmer {
	public String name;
	private int foodAmount;
	private double budget;
	private boolean activeStatus = true;
	private static Random rand = new Random();
	static final double MIN_MONEY = 100;
	static final double MAX_MONEY = 1000;
	static final int MIN_FOOD = 200;
	static final int MAX_FOOD = 500;
	static final int MAX_MOVES = 2; 
	static final int MAX_DAYS = 2; 
	static Scanner userInput = new Scanner(System.in);

	public Farmer(String name, int foodAmount, double budget) {
		this.name = name;
		this.foodAmount = foodAmount;
		this.budget = budget;
		this.activeStatus = true;
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
		if (foodAmount > 0 && price > 0) {
			this.foodAmount = this.foodAmount - foodAmount;
			this.budget = this.budget + price;
			System.out.println("Farmer " + this.name + " sold " + foodAmount + "kg for " + price + " EUR");
		} else {
			System.out.println("Sorry, you can't sell your food! Incorrect input. You loose your move.");
		}
	}
	


	private boolean checkFood(int givingFoodAmount) {
		if (this.foodAmount > givingFoodAmount) {
			return true;
		} else {
			System.out.println("Sorry, farmer " + this.name + " doesn't have " + givingFoodAmount + "kg of food");
			return false;
		}
	}

	private boolean checkMoney(double givingMoneyAmount) {
		if (this.budget > givingMoneyAmount) {
			return true;
		} else {
			System.out.println("Sorry, farmer " + this.name + " doesn't have " + givingMoneyAmount + "EUR");
			return false;
		}
	}

	private void foodExchange(Farmer farmer, int foodAmount) {
		farmer.foodAmount = farmer.foodAmount + foodAmount;
		this.foodAmount = this.foodAmount - foodAmount;
	}

	public void giveFood(Farmer farmer, int givingFoodAmount) {
		if (givingFoodAmount > 0) {
			if (this.checkFood(givingFoodAmount)) {
				this.foodExchange(farmer, givingFoodAmount);
				System.out.println(this.name + " gifted " + givingFoodAmount + " kg of food to" + farmer.name);
			} else  {
				System.out.println("Sorry, farmer " + this.name + "doesn't have " + givingFoodAmount
						+ "kg of food to donate them to " + farmer.name);
			}
		} else {
			System.out.println("Sorry, you can't donate negative number");
		}
	}

	public void purchaseFrom(Farmer farmer, int foodAmount, double money) {
		if (farmer.checkFood(foodAmount) && (this.checkMoney(money))) {
			this.moneyExchange(farmer, money);
			farmer.foodExchange(this, foodAmount);
			System.out.println(this.name + " purchased " + foodAmount + " kg of food from  " + farmer.name + " for "
					+ money + " EUR");
		}
	}

	private void moneyExchange(Farmer farmer1, double money) {
		farmer1.budget = farmer1.budget + money;
		this.budget = this.budget - money;
	}

	public void giftMoneyTo(Farmer farmer, double giftedMoney) {
		if (this.checkMoney(giftedMoney)) {
			this.moneyExchange(farmer, giftedMoney);
			System.out.println(this.name + " gifted " + giftedMoney + " EUR to " + farmer.name);
		}
	}

	public void stealMoneyFrom(Farmer farmer, double money) {
		if (money > 0) {
			if (farmer.checkMoney(money)) {
				farmer.moneyExchange(this, money);
				System.out.println(this.name + " Steal " + money + " EUR from " + farmer.name );
			}
		} else {
			System.out.println("Sorry, you can't steal money. Incorrect input. You loose your move.");
		}
	}

	public String toString() {
		return "Farmers [name = " + name + ", food = " + foodAmount + " kg, budget = " + String.format("%.2f", budget)
				+ " EUR]";
	}

	public void info() {
		System.out.println("Farmers [name = " + name + ", food = " + foodAmount + " kg, budget = "
				+ String.format("%.2f", budget) + " EUR, status: " + activeStatus + ".");
	}

	public static void makeRandomFarmers(ArrayList<Farmer> farmerList) {
		farmerList.add(Farmer.getFarmer("Michael"));
		farmerList.add(Farmer.getFarmer("Valerija"));
		farmerList.add(Farmer.getFarmer("Chanel"));
		farmerList.add(Farmer.getFarmer("Innokentij"));
		farmerList.add(Farmer.getFarmer("Vasilij"));
		farmerList.add(Farmer.getFarmer("Semjon"));
		farmerList.add(Farmer.getFarmer("Aleksandex"));
		farmerList.add(Farmer.getFarmer("Marija"));
		farmerList.add(Farmer.getFarmer("Okulina"));
		farmerList.add(Farmer.getFarmer("Klava"));
	}

	public static Farmer getFarmer(String name) {
		return new Farmer(name, radomPointFood(MAX_FOOD, MIN_FOOD), radomPointMoney(MIN_MONEY, MAX_MONEY));
	}

	private static double radomPointMoney(double max, double min) {
		return rand.nextDouble() * (max - min) + min;
	}

	private static int radomPointFood(int max, int min) {
		return rand.nextInt((max - min) + 1) + min;
	}

	public static void printInfoListFarmers(ArrayList<Farmer> farmerList) {
		System.out.println("Info of our village:");
		for (int i = 0; i < farmerList.size(); i++) {
			System.out.println(farmerList.get(i));
		}
	}

	public static int searchForFarmer(String name, ArrayList<Farmer> farmerList) {
		int idOfFarmer = -1;
		for (int i = 0; i < farmerList.size(); i++) {
			if (farmerList.get(i).name.equals(name)) {
				idOfFarmer = i;
			}
		}
		return idOfFarmer;
	}

	public static void makeUserFarmers(ArrayList<Farmer> farmerList) {
		System.out.println("How many farmers do you want to create?");
		int farmerNumber = userInput.nextInt();
		Scanner nameInput = new Scanner(System.in);
		for (int i = 1; i < farmerNumber + 1; i++) {
			System.out.println("Please enter name of farmer Nr." + i);
			String farmerName = nameInput.nextLine();
			farmerList.add(Farmer.getFarmer(farmerName));
		}
	}
	
	
	public static int chooseFarmer (String farmer, ArrayList<Farmer> farmerList) {
		int id =-1;
		do {
			id = Farmer.searchForFarmer(farmer, farmerList);
			if (id < 0) {
				System.out.println("Incorrect name. Let`s type the name again.");
				farmer = userInput.next();
			}
		} while (id<0);
		return id;
	}

//	public static boolean containName(String name, ArrayList<Farmer> farmerList) {
//		System.out.println(farmerList.contains(name));
//		return farmerList.getcontains(name);
//	}
}