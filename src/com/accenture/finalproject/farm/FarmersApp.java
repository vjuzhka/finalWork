package com.accenture.finalproject.farm;

public class FarmersApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Farmers user1 = new Farmers("Kolja", 14, 100d);
		Farmers user2 = new Farmers("Vera", 20, 100d);
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
		
		

	}

}
