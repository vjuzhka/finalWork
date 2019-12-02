package com.accenture.finalproject.farm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FarmersApp {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		Farmer user1 = new Farmer("Kolja", 14, 100d);
		Farmer user2 = new Farmer("Vera", 20, 100d);
		System.out.println(user1);
		System.out.println(user2);
		user1.purchaseFrom(user2, 2, 120);
		System.out.println(user1);
		System.out.println(user2);
		user1.rename("Vasja");
		System.out.println(user1);
		user1.sellFood(30, 20);
		System.out.println(user1);
		user1.stealMoneyFrom(user2, 20);
		System.out.println(user1);
		System.out.println(user2);

		System.out.println("The farmers are created!");
		System.out.println("Please choose your farmer:");
		// print out all created farmer names;
		String farmer1 = userInput.next();
		// we need method that finds right farmer by name;

		System.out.println("Let`s start the game!");
		String choice = userInput.next();
		System.out.println("Press 'r' to rename farmer");
		System.out.println("Press 'i' to see info of some farmer");
		System.out.println("Press 's' to sell food to another farmer");
		System.out.println("Press 'g' to donate some food to another farmer");
		System.out.println("Press 'm' to donate money to another farmer");
		System.out
				.println("Press 'p' to purchase some food from another farmer");
		System.out.println("Press 't' to steal money from another farmer");

		switch (choice) {
		case "r": // rename;
			System.out.println("Please enter NEW farmer`s name.");
			String newname = userInput.next();
			user1.rename(newname);
			break;
		case "i": // info;
			user1.info();
			break;
		case "s": // sell;
			System.out.println("How much food would you like to sell?");
			int amount = userInput.nextInt();
			System.out.println("What is the price?");
			double price = userInput.nextDouble();
			user1.sellFood(amount, price);
			break;
		case "g": // donate food;
			System.out.println("How much food would you like to donate?");
			amount = userInput.nextInt();
			System.out.println("To whom you would you like to donate food?");
			String farmersname = userInput.next();
			//method combo that finds right farmer and donates them food;
			break;
		case "m": // donate money;
			System.out.println("How much money would you like to donate?");
			 price = userInput.nextDouble();
			System.out.println("To whom you would you like to donate maney?");
			farmersname = userInput.next();
			//method combo that finds right farmer and donates them maney;
			break;
		case "p": // purchase food;
			System.out.println("How much food would you like to purchase?");
			amount = userInput.nextInt();
			System.out.println("How much money would you like to spend?");
			price = userInput.nextDouble();
			System.out.println("Who is the seller?");
			farmersname = userInput.next();
			//method combo that finds right farmer and purchases from them food;
			break;
		case "t": // steal money;
			
			
			break;

		}

	}

}