package com.example.javase8;

public class Exercise02 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Imperative Programming
		// Problem -> Algorithm/Flow -> Solution
		// Declarative Programming: Functional Programming, SQL, ...
		// Problem -> Describe Solution
		// SQL
		// select count(*) from countries where continent='Asia';

		// Functional Programming
		// functions: 
		//  i) Higher-Order Function: Chain -> pipeline
		// ii) Pure Function
		int x = 42; // data: int
		Employee y = new Employee(); // reference: object
		Fun z = n -> n%2 ==0;// i. lambda expression ii. method reference
	}
	
	public static void gun(Fun f) { // Higher-Order Function
		
	}
	
	public static Fun sun() { // Higher-Order Function
		return n -> n%2 ==0;
	}

	
}

@FunctionalInterface
interface Fun { // Single Abstract Method
	boolean fun(int x);
}

class Employee {}