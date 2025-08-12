package com.example.javase14;

public class Exercise04 {
	public static void main(String[] args) {
		    // String: immutable
			String name1 = "jack"; // Constant Pool
			String name2 = new String("jack"); // Heap
			String name3 = "jack"; // Constant Pool
			name2 = name2.intern();
			System.out.println("name1==name2: "+(name1==name2));
			System.out.println("name1==name3: "+(name1==name3));
			
			System.out.println(name1);
			name1 = name1.toUpperCase();
			System.out.println(name1);
			// G1GC,ParallelGC,ZGC,ShennandoahGC -> FullGC?
			// String De-duplication
			// -XX:+UseStringDeduplication -> Memory Footprint
	}
}
