package com.example.javase22;

import java.util.function.Predicate;

public class Exercise01 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			
		}catch(Exception _) { // unnamed variable
			System.out.println("Something is wrong!");
		}

		Predicate<Integer> isEven = _ -> true;
	}

}
