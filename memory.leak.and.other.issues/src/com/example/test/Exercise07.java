package com.example.test;

import java.util.ArrayList;

public class Exercise07 {

	public static void main(String[] args) {
		var start = System.currentTimeMillis();
		var s = new ArrayList<Integer>(100_000_000);
		for (var i = 0; i < 100_000_000; ++i) {
			s.add(Integer.valueOf(42));
		}
		var stop = System.currentTimeMillis();
		System.out.println("Duration: %d ms. length: %d".formatted(stop - start,s.size()));

	}

}
