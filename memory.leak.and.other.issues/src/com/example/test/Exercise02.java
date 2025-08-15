package com.example.test;

public class Exercise02 {

	public static void main(String[] args) {
		Integer x = 42; // auto-boxing
		Integer y = 42; // auto-boxing
		Integer u = Integer.valueOf(549); 
		Integer v = 549; // auto-boxing
		System.out.println("x==y: "+(x==y));
		System.out.println("u==v: "+(u==v));
	}

}
