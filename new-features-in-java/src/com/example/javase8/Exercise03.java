package com.example.javase8;

public class Exercise03 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Fun1 x = NumberUtility::isOdd; // method reference

	}

}

interface Fun1 {
	boolean f(int n);
}

interface NumberUtility {
	static boolean isOdd(int p) { // since java se 8
		return p%2 == 1;
	}
}