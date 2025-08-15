package com.example;

import java.util.IdentityHashMap;

public class Exercise05 {

	public static void main(String[] args) {
		var map = new IdentityHashMap<Integer,String>();
		map.put(Integer.valueOf(42), "42");
		System.out.println(map.size()); // 1
		map.put(42, "42");
		System.out.println(map.size()); // 1
		map.put(542, "542");
		System.out.println(map.size()); // 2
		map.put(542, "542");
		System.out.println(map.size()); // 3
	}

}
