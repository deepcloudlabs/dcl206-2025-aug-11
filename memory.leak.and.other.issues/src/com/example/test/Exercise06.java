package com.example.test;

public class Exercise06 {

	public static void main(String[] args) {
		var start = System.currentTimeMillis();
		var s = new StringBuilder(788888890);
		//var s = "";
		for (var i = 0; i < 100_000_000; ++i) {
		    s.append(i);
			// s += i;
		}
		var stop = System.currentTimeMillis();
		System.out.println("Duration: %d ms. length: %d".formatted(stop - start,s.length()));
	}

}
