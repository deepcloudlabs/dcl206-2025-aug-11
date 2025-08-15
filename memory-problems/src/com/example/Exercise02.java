package com.example;

public class Exercise02 {

	@SuppressWarnings("finally")
	public static int fun() {
		try {
			return 100;
		} finally {
			return 200;
		}
	}
	public static void main(String[] args) {
		System.out.println(fun());
	}

}
