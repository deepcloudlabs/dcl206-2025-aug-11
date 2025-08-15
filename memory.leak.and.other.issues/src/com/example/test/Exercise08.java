package com.example.test;

import java.util.HashSet;

public class Exercise08 {

	public static void main(String[] args) {
		var set = new HashSet<>();
		var start = System.currentTimeMillis();
		for (var i = 0; i < 10_000_000; ++i) {
			set.add(new ABC(42));
		}
		System.out.println(set.size());
		while (!set.isEmpty()) {
			set.remove(new ABC(42));
			//System.out.println(set.size());
		}
		System.out.println(set.size());
		var stop = System.currentTimeMillis();
		System.out.println("Duration: %d ms. length: %d".formatted(stop - start,set.size()));
		
	}

}

record R1(int x) {}
record ABC(int x) {}
