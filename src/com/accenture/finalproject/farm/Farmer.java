package com.accenture.finalproject.farm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Farmer {
	public String name;
	private int foodAmount;
	private double budget;
	private static Random rand = new Random();
	static final double MIN_MONEY = 100;
	static final double MAX_MONEY = 1000;
	static final int MIN_FOOD = 200;
	static final int MAX_FOOD = 500;
	static final int MAX_MOVES = 2;
	static final int MAX_DAYS = 1;
	static Scanner userInput = new Scanner(System.in);

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

	public void rename(String name) {
		System.out.println(this.name + " was renamed to " + name);
		setName(name);
	}

	public void sellFood(int foodAmount, double price) {
		if (foodAmount > 0 && price > 0) {
			this.foodAmount = this.foodAmount - foodAmount;
			this.budget = this.budget + price;
			System.out.println("Farmer " + this.name + " sold " + foodAmount
					+ "kg for " + price + " EUR");
		} else {
			System.out
					.println("Sorry, you can't sell your food! Incorrect input. You loose your move.");
		}
	}

	private boolean checkFood(int givingFoodAmount) {
		if (this.foodAmount >= givingFoodAmount) {
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

	private void foodExchange(Farmer farmer, int foodAmount) {
		farmer.foodAmount = farmer.foodAmount + foodAmount;
		this.foodAmount = this.foodAmount - foodAmount;
	}

	public void giveFood(Farmer farmer, int givingFoodAmount) {
		if (givingFoodAmount > 0) {
			if (this.checkFood(givingFoodAmount)) {
				this.foodExchange(farmer, givingFoodAmount);
				System.out.println(this.name + " gifted " + givingFoodAmount
						+ " kg of food to" + farmer.name);
			} else {
				System.out.println("Sorry, farmer " + this.name
						+ "doesn't have " + givingFoodAmount
						+ "kg of food to donate them to " + farmer.name);
			}
		} else {
			System.out.println("Sorry, you can't donate negative number");
		}
	}

	public void purchaseFrom(Farmer farmer, int foodAmount, double money) {
		if (foodAmount > 0 && money > 0) {
			if (farmer.checkFood(foodAmount) && (this.checkMoney(money))) {
				this.moneyExchange(farmer, money);
				farmer.foodExchange(this, foodAmount);
				System.out.println(this.name + " purchased " + foodAmount
						+ " kg of food from  " + farmer.name + " for " + money
						+ " EUR");
			}
		} else {
			System.out
					.println("Sorry, you can't buy NEGATIVE food! Incorrect input. You loose your move.");
		}
	}

	private void moneyExchange(Farmer farmer1, double money) {
		farmer1.budget = farmer1.budget + money;
		this.budget = this.budget - money;
	}

	public void giftMoneyTo(Farmer farmer, double giftedMoney) {
		if (giftedMoney > 0) {
			if (this.checkMoney(giftedMoney)) {
				this.moneyExchange(farmer, giftedMoney);
				System.out.println(this.name + " gifted " + giftedMoney
						+ " EUR to " + farmer.name);
			}
		} else {
			System.out
					.println("Sorry, you can't donate negative number. Incorrect input. You loose your move.");
		}
	}

	public void stealMoneyFrom(Farmer farmer, double money) {
		if (money > 0) {
			if (farmer.checkMoney(money)) {
				farmer.moneyExchange(this, money);
				System.out.println(this.name + " Steal " + money + " EUR from "
						+ farmer.name);
			}
		} else {
			System.out
					.println("Sorry, you can't steal NEGATIVE money. Incorrect input. You loose your move.");
		}
	}

	public String toString() {
		return "Farmer [name = " + name + ", food = " + foodAmount
				+ " kg, budget = " + String.format("%.2f", budget) + " EUR]";
	}

	public void info() {
		System.out.println("Farmer [name = " + name + ", food = " + foodAmount
				+ " kg, budget = " + String.format("%.2f", budget)
				+ " EUR.");
	}

	public static void makeRandomFarmers(ArrayList<Farmer> farmerList) {
		farmerList.add(Farmer.getFarmer("Bob"));
		farmerList.add(Farmer.getFarmer("John"));
		farmerList.add(Farmer.getFarmer("Alice"));
		farmerList.add(Farmer.getFarmer("Alex"));
		farmerList.add(Farmer.getFarmer("Rob"));
		farmerList.add(Farmer.getFarmer("Tom"));
		farmerList.add(Farmer.getFarmer("Jerry"));
		farmerList.add(Farmer.getFarmer("Lisa"));
		farmerList.add(Farmer.getFarmer("Eva"));
		farmerList.add(Farmer.getFarmer("Lena"));
	}

	public static Farmer getFarmer(String name) {
		return new Farmer(name, radomPointFood(MAX_FOOD, MIN_FOOD),
				radomPointMoney(MIN_MONEY, MAX_MONEY));
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
			if (farmerList.get(i).name.equalsIgnoreCase(name)) {
				idOfFarmer = i;
			}
		}
		return idOfFarmer;
	}

	public static void makeUserFarmers(ArrayList<Farmer> farmerList) {
		System.out
				.println("How many farmers do you want to create? Remember, the minimum is 3");
		int farmerNumber = userInput.nextInt();
		int totalFarmers;
		Scanner nameInput = new Scanner(System.in);
		if (farmerNumber < 3) {
			totalFarmers = 3;
		} else {
			totalFarmers = farmerNumber;
		}
		for (int i = 1; i < totalFarmers + 1; i++) {
			System.out.println("Please enter name of farmer Nr." + i);
			String farmerName = nameInput.nextLine();
			farmerList.add(Farmer.getFarmer(farmerName));
		}
	}

	public static int chooseFarmer(String farmer, ArrayList<Farmer> farmerList) {
		int id = -1;
		do {
			id = Farmer.searchForFarmer(farmer, farmerList);
			if (id < 0) {
				System.out
						.println("Incorrect name. Let`s type the name again.");
				farmer = userInput.next();
			}
		} while (id < 0);
		return id;
	}

	public static double checkCorrectNumber() {
		String input;
		while (!userInput.hasNextDouble()) {
			System.out.println("Uncorrect input, please try again");
			input = userInput.next();
		}
		return userInput.nextDouble();
	}
	
	public static int searchForFarmerRichest( ArrayList<Farmer> farmerList) {
		int id = -1;
		Farmer richestFarmer = farmerList.get(0);
		for (int i = 0; i < farmerList.size(); i++) {
			if (farmerList.get(i).budget > richestFarmer.budget ) {
				id = i;
			}
		}
		return id;
	}

	public static int searchForFarmerMostFood( ArrayList<Farmer> farmerList) {
		int id = -1;
		Farmer richestFarmer = farmerList.get(0);
		for (int i = 0; i < farmerList.size(); i++) {
			if (farmerList.get(i).foodAmount > richestFarmer.foodAmount ) {
				id = i;
			}
		}
		return id;
	}
}