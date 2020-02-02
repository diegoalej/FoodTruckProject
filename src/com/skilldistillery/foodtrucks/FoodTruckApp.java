package com.skilldistillery.foodtrucks;

import java.util.Scanner;

public class FoodTruckApp {
	// Main method makes use of getInfo() to get initial FoodTruck input array,
	// The array is then trimmed to exclude null objects using notNull().
	// showMenu() then runs the rest of the application
	public static void main(String[] args) {
		FoodTruckApp newApp = new FoodTruckApp();
		Scanner input = new Scanner(System.in);
		FoodTruck[] allTrucks = newApp.getInfo(input);
		FoodTruck[] finalTruckArray = newApp.notNull(allTrucks);
		newApp.showMenu(finalTruckArray, input);
		input.close();
	}

	// Method displays the menu choices and filters response according to input
	private void showMenu(FoodTruck[] finalTruckArray, Scanner input) {
		while (true) {
			System.out.println("Enter any integer 1 - 4 to select the items below: ");
			System.out.println("1: List all food trucks\n2: See the average rating of all food trucks");
			System.out.println("3: Display the highest-rated food truck(s)\n4: Quit");
			System.out.print("> ");
			int choice = input.nextInt();
			if (choice == 1) { // display all food trucks
				System.out.println("Here is a list of all food trucks: ");
				for (FoodTruck foodTruck : finalTruckArray) {
					System.out.println(foodTruck);
				}
				System.out.println();
			} else if (choice == 2) { // display average
				double averageRating, total = 0;
				for (FoodTruck foodTruck : finalTruckArray) {
					total += foodTruck.getNumericRating();
				}
				averageRating = roundTwoDecimals(total / finalTruckArray.length);
				System.out.println("The average rating of all trucks is: " + averageRating);
				System.out.println();
			} else if (choice == 3) { // display highest rated
				highestRated(finalTruckArray);
				System.out.println();
			} else if (choice == 4) { // quit
				System.out.println("Thanks for using Food Truck App!");
				break;
			} else {
				System.out.println("Sorry, wrong input, try again");
			}
		}
	}

	// Method loops through finalTruck[] and returns the food truck(s) with the
	// highest score
	private double highestRated(FoodTruck[] finalTruckArray) {
		double highestScore = finalTruckArray[0].getNumericRating();
		for (int i = 1; i < finalTruckArray.length; i++) {
			if (finalTruckArray[i].getNumericRating() > finalTruckArray[i - 1].getNumericRating()) {
				highestScore = finalTruckArray[i].getNumericRating();
			}
		}
		System.out.println("The highest rated truck(s) are: ");
		for (FoodTruck foodTruck : finalTruckArray) {
			if (foodTruck.getNumericRating() == highestScore) {
				System.out.println(foodTruck);
			}
		}
		return highestScore;
	}

	// Method loops through array to find how many trucks were input by user
	// and returns a new array of that size
	private FoodTruck[] notNull(FoodTruck[] allTrucks) {
		int truckNotNull = 0;
		for (int i = 0; i < allTrucks.length; i++) {
			if (allTrucks[i] != null) {
				truckNotNull++;
			}
		}
		FoodTruck[] finalTrucks = new FoodTruck[truckNotNull];
		for (int i = 0; i < finalTrucks.length; i++) {
			finalTrucks[i] = allTrucks[i];
		}
		return finalTrucks;
	}

	// Method gets input from user to and returns a FoodTruck[] with input or
	// default values
	private FoodTruck[] getInfo(Scanner input) {
		FoodTruck[] allTrucks = new FoodTruck[5];
		System.out.println(
				"Welcome to food truck App, you can enter up to 5 food trucks\nEnter 'quit' as truck name to stop input: ");
		for (int i = 0; i < 5; i++) {
			System.out.print("Please enter the name for truck number " + (i + 1) + ": ");
			String tName = input.nextLine();
			if (tName.equalsIgnoreCase("quit")) {
				System.out.println("" + i + " food trucks entered");
				break;
			}
			System.out.print("Please enter the food type for truck number " + (i + 1) + ": ");
			String tFoodType = input.nextLine();
			System.out.print("Please enter the star rating of truck " + (i + 1) + "\nAny double from 1 - 10: ");
			double rating = roundTwoDecimals(input.nextDouble());
			allTrucks[i] = new FoodTruck(tName, rating, tFoodType);
			input.nextLine();
			if(i == 4) {
				System.out.println("5 trucks entered");
			}
		}
		return allTrucks;
	}

	// Method rounds numbers to the nearest tenth
	public double roundTwoDecimals(double roundedNum) {
		roundedNum = Math.round(roundedNum * 10);
		roundedNum /= 10;
		return roundedNum;
	}
}
