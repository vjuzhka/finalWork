package com.accenture.finalproject.farm;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.Scanner;

public class FarmersApp {

	public static void main(String[] args) {

		ArrayList<Farmer> farmerList = new ArrayList<Farmer>();
		boolean correctName;
		String choice = "";
		int id = 0;
		System.out.println("Welcome to our village 'Lauki'!");
		System.out.println("The minimum population is 3 farmers. The entry food is: minimum " + Farmer.MIN_FOOD
				+ "kg amd maximum " + Farmer.MAX_FOOD + " kg, minumum budget is " + Farmer.MIN_MONEY
				+ " EUR and maximum " + Farmer.MAX_MONEY + "EUR");
		System.out.println("Press 's' to start the game with our randomly created 10 farmers");
		System.out.println("Press 'a' to add farmers by yourself");
		Scanner userInput = new Scanner(System.in);
		String option;

		do {
			option = userInput.next();
			switch (option) {
			case "s":
				Farmer.makeRandomFarmers(farmerList);
				break;
			case "a":
				Farmer.makeUserFarmers(farmerList);
				break;
			case "q":
				System.exit(0);
				break;
			default:
				System.out.println("Input is incorrect. Please try again or press 'q' to exit.");
				break;

			}
		} while (!(option.equals("a") || option.equals("s")));

		System.out.println(
				"The farmers are created! Let`s start the game. You have " + Farmer.MAX_MOVES + " moves each day! We will play for" +Farmer.MAX_DAYS + " days");

		for (int i = 1; i <= Farmer.MAX_MOVES;) {
			 do {
			System.out.println("Let`s make your " + i + " move.");
			System.out.println("Please choose your farmer:");
			Farmer.printInfoListFarmers(farmerList);
			String farmer = userInput.next();
			id = Farmer.chooseFarmer(farmer, farmerList);

			System.out.println("Press 'r' to rename farmer");
			System.out.println("Press 'i' to see info of choosen farmer");
			System.out.println("Press 's' to sell food to another farmer in another village");
			System.out.println("Press 'd' to donate some food to another farmer from this village");
			System.out.println("Press 'm' to donate money to another farmer from this village");
			System.out.println("Press 'p' to purchase some food from another farmer in this village");
			System.out.println("Press 't' to steal money from another farmer in this village");
			System.out.println("Press 'q' to quit.");

			choice = userInput.next();
			switch (choice) {
			case "r": // rename;
				System.out.println("Please enter NEW farmer`s name.");
				String newname = userInput.next();
				farmerList.get(id).rename(newname);
				i++;
				break;
			case "i": // info;
				farmerList.get(id).info();
				i++;
				break;
			case "s": // sell;
				System.out.println("How much food would you like to sell?");
				int amount = userInput.nextInt();
				System.out.println("What is the total price?");
				double price = userInput.nextDouble();
				farmerList.get(id).sellFood(amount, price);
				i++;
				break;
			case "d": // donate food;
				System.out.println("How much food would you like to donate?");
				amount = userInput.nextInt();
				System.out.println("To whom you would you like to donate food?");
				String farmersname = userInput.next();
				int idToDonate = Farmer.chooseFarmer(farmersname, farmerList);
				farmerList.get(id).giveFood(farmerList.get(idToDonate), amount);
				i++;
				break;
			case "m": // donate money;
				System.out.println("How much money would you like to donate?");
				price = userInput.nextDouble();
				System.out.println("To whom you would you like to donate maney?");
				farmersname = userInput.next();
				idToDonate = Farmer.chooseFarmer(farmersname, farmerList);
				farmerList.get(id).giftMoneyTo(farmerList.get(idToDonate), price);
				i++;
				break;
			case "p": // purchase food;
				System.out.println("How much food would you like to purchase?");
				amount = userInput.nextInt();
				System.out.println("How much money would you like to spend?");
				price = userInput.nextDouble();
				System.out.println("Who is the seller?");
				farmersname = userInput.next();
				int idPurchase = Farmer.chooseFarmer(farmersname, farmerList);
				farmerList.get(id).purchaseFrom(farmerList.get(idPurchase), amount, price);
				i++;
				break;
			case "t": // steal money;
				System.out.println("How much do you want to steal?");
				price = userInput.nextInt();
				System.out.println("From who do you want to steal?");
				farmersname = userInput.next();
				int idSteal = Farmer.chooseFarmer(farmersname, farmerList);
				farmerList.get(id).stealMoneyFrom(farmerList.get(idSteal), price);
				i++;
				break;
			case "q":
				System.out.println("Thanks for playing!");
				i = Farmer.MAX_MOVES;
				System.exit(0);
			}

			 } while (!choice.equals("q"));
		}

	}

}
