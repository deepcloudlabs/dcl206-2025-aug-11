package com.example.javase14;

import java.util.ArrayList;
import java.util.List;

public class Exercise01 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// integral types: byte, short, int, long -> signed
		byte z = 42; // 1B, [-128..127]
		z = 127;
		//z++; // (byte)(z + 1)
		z += 1; //(byte)(z + 1) 
		z = (byte)(z + 1);
		// unsigned -> char
		System.out.println("z: %d".formatted(z));
		int x = 42; // 4B
		// Wrapper Class
		Integer y = 42; // y: reference: 4B -> UseCompressedOops
		                // Object Header (12B) + Value (4B) = 16B 
		                // 20B
		
		// cache!
		int []array = new int[1024]; // 4B -> 12B + 4B + 4*1024B = 4KB
		// Integer[]
        List<Integer> numbers= new ArrayList<>(); // 20KB
        // 
	}

}
