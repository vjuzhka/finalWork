package com.accenture.finalproject.farm;

public class FarmersApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Farmer user1 = new Farmer("Kolja", 50, 100d);
		Farmer user2 = new Farmer("Vera", 40, 100d);
		System.out.println(user1);
		System.out.println(user2);
		user1.purchaseFrom(user2, 6, 20);
		System.out.println(user1);
		System.out.println(user2);
		user1.rename("Vasja");
		System.out.println(user1);
		user1.sellFood(30, 20);
		System.out.println(user1);
		user1.stealMoneyFrom(user2, 1110);
		System.out.println(user1);
		System.out.println(user2);
//		user1.giftMoneyTo(user2, 30000);
//		System.out.println(user1);
//		System.out.println(user2);
//		user1.giveFood(user2, 4);
//		System.out.println(user1);
//		System.out.println(user2);
		

	}

}
