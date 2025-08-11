package com.example.javase7;

@SuppressWarnings("finally")
public class Exercise04 {
	public static int fun() {
		try {
			// return 42;
			throw new RuntimeException("Oooops");
		} catch(Exception e) {
			return 108;
		} finally {
			return 549;
		}
	}
	
	public static void main(String[] args) {
		// try-catch-finally
		System.out.println(fun());
	}

}
