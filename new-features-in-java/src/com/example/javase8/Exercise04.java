package com.example.javase8;

public class Exercise04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface Gun {
	int gun(int n);
	default boolean fun(int n) { // default implementation
		return n%2 == 1;
	};
}

class Y implements Gun {

	@Override
	public int gun(int n) {
		return n*n*n;
	}
	
}