package com.skilldistillery.foodtrucks;

public class FoodTruck {
	// F I E L D S
	private String name;
	private String foodtype;
	private static int nextTruckId = 101;
	private double numericRating;
	private int truckId;

	// M E T H O D S
	public FoodTruck(String name, double numericRating, String foodType) {
		this.name = name;
		this.numericRating = numericRating;
		this.foodtype = foodType;
		this.truckId = nextTruckId;
		nextTruckId++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodtype() {
		return foodtype;
	}

	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}

	public int getTruckId() {
		return truckId;
	}

	public double getNumericRating() {
		return numericRating;
	}

	public void setNumericRating(int numericRating) {
		this.numericRating = numericRating;
	}

	public void displayMenu() {
		

	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Name: ");
		builder.append(name);
		builder.append(", Food Type: ");
		builder.append(foodtype);
		builder.append(", Rating: ");
		builder.append(numericRating);
		builder.append(", Truck ID: ");
		builder.append(truckId);
		return builder.toString();
	}

}
