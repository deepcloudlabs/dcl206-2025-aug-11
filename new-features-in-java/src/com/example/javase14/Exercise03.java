package com.example.javase14;

import java.util.List;

public class Exercise03 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Point> points = List.of(
				new Point(1,2),
				new Point(3,4),
				new Point(5,6),
				new Point(7,8)
		);
        // | @ | @ | @ | @ | @ | @ |
		//  | OH | 1 | 2 | ... | OH | 3 | 4 | ...
		//  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | ... Cache
		// List<Integer> --> List<int> 
		// List<Point> --> | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
		// Memory Footprint
		// CPU <-> Memory
		// GPU
	}

}

// Immutable
record A(int x){}
final record Point (int x,int y) {}
final record MyRecord(boolean x,double y,String z,A a) {}
