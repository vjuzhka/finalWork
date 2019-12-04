package com.accenture.finalproject.farm;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.Scanner;

public class FarmersApp {

	public static void main(String[] args) {

		ArrayList<Farmer> farmerList = new ArrayList<Farmer>();

		Farmer.makeRandomFarmers(farmerList);

		Scanner userInput = new Scanner(System.in);

		System.out.println("The farmers are created!");
		System.out.println("Please choose your farmer:");
		Farmer.printInfoListFarmers(farmerList);
		String farmer = userInput.next();

		int id = Farmer.searchForFarmer(farmer, farmerList);

		System.out.println("Let`s start the game!");

		System.out.println("Press 'r' to rename farmer");
		System.out.println("Press 'i' to see info of some farmer");
		System.out.println("Press 's' to sell food to another farmer");
		System.out.println("Press 'd' to donate some food to another farmer");
		System.out.println("Press 'm' to donate money to another farmer");
		System.out
				.println("Press 'p' to purchase some food from another farmer");
		System.out.println("Press 't' to steal money from another farmer");
		String choice = "";

		do {
			choice = userInput.next();
			switch (choice) {
			case "r": // rename;
				System.out.println("Please enter NEW farmer`s name.");
				String newname = userInput.next();
				farmerList.get(id).rename(newname);
				break;
			case "i": // info;
				farmerList.get(id).info();
				break;

			case "s": // sell;
				System.out.println("How much food would you like to sell?");
				int amount = userInput.nextInt();
				System.out.println("What is the price?");
				double price = userInput.nextDouble();
				farmerList.get(id).sellFood(amount, price);
				break;

			case "d": // donate food;
				System.out.println("How much food would you like to donate?");
				amount = userInput.nextInt();
				System.out
						.println("To whom you would you like to donate food?");
				String farmersname = userInput.next();
				int idToDonate = Farmer
						.searchForFarmer(farmersname, farmerList);
				farmerList.get(id).giveFood(farmerList.get(idToDonate), amount);
				// method combo that finds right farmer and donates them food;
				break;
			case "m": // donate money;
				System.out.println("How much money would you like to donate?");
				price = userInput.nextDouble();
				System.out
						.println("To whom you would you like to donate maney?");
				farmersname = userInput.next();
				idToDonate = Farmer.searchForFarmer(farmersname, farmerList);
				farmerList.get(id).giftMoneyTo(farmerList.get(idToDonate),
						price);
				break;
			case "p": // purchase food;
				System.out.println("How much food would you like to purchase?");
				amount = userInput.nextInt();
				System.out.println("How much money would you like to spend?");
				price = userInput.nextDouble();
				System.out.println("Who is the seller?");
				farmersname = userInput.next();
				int idPurchase = Farmer
						.searchForFarmer(farmersname, farmerList);
				farmerList.get(id).purchaseFrom(farmerList.get(idPurchase),
						amount, price);
				break;
			case "t": // steal money;
				System.out.println("How much do you want to steal?");
				price = userInput.nextInt();
				System.out.println("From who do you want to steal?");
				farmersname = userInput.next();
				int idSteal = Farmer.searchForFarmer(farmersname, farmerList);
				farmerList.get(id).stealMoneyFrom(farmerList.get(idSteal),
						price);

				break;
			case "q":

			}
		} while (!choice.equals("q")) ;
		System.out.println("ata");

	}

}