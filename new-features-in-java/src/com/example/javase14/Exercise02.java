package com.example.javase14;

import java.util.ArrayList;
import java.util.List;

public class Exercise02 {

	public static void main(String[] args) {
		// -XX:AutoBoxCacheMax=4096
		// Object Pooling
		// Integer: immutable class
		Integer i1 = Integer.valueOf(42); // 16B
		Integer i2 = 42; // auto-boxing   // 16B
		Integer j1 = 542;
		Integer j2 = 542;
		System.out.println("i1==i2: "+(i1==i2));
		System.out.println("i1==i2: "+(j1==j2));
		List<Integer> numbers= new ArrayList<>();
		numbers.add(42);
		numbers.add(Integer.valueOf(42));
		numbers.add(42);
	}

}
