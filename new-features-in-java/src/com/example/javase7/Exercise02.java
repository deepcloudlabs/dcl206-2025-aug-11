package com.example.javase7;

public class Exercise02 {

	public static void main(String[] args) {
		String day = "wednesday";
		switch(day) { // byte, short, int, char, enum + String
		case "monday":
		case "tuesday":
		case "wednesday":
		case "thursday":
		case "friday":
			System.out.println("Work hard!");
			break;
		case "saturday":
		case "sunday":
			System.out.println("Have rest!");
			break;
		default:
			throw new IllegalArgumentException("No such week day is available: %s".formatted(day));
		}

	}

}
