package com.example;

public class Exercise01 {
// Linux:
//	Millis elapsed: %6
//	Millis elapsed: 4232
// Windows:
//	Millis elapsed: %30
//  Millis elapsed: 5187	
	
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 2_000; i++) {
			Thread.sleep(2);
		}
		long end = System.currentTimeMillis();
		System.out.println("Millis elapsed: " + (end - start - 4000.0) / 40.0);
		System.out.println("Millis elapsed: " + (end - start) );
	}

}
