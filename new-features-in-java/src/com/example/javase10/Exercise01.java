package com.example.javase10;

import java.util.List;

public class Exercise01 {
    
	public static void main(String[] args) {
		var x = 42.0F; // c++: auto x = 42.0;
        
		var numbers1 = List.of(4,8,15,16,23,42); // List<Integer>
		var numbers2 = List.of(4,8,15.0,16,23,42); // List<Number & Comparable>
		List<Number> numbers3 = List.of(4,8,15.0,16,23,42); // List<Object & Comparable & Serializable>
		
	}

}

class A { 
	// var x = 42;
}