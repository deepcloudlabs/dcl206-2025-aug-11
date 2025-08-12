package com.example.javase8;

public class Exercise05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface I1 {
	default void fun() {}
}

interface I2 {
	default void fun() {}
}

class TTT implements I1 {}
class SSS implements I2 {}

class RRR implements I1, I2 {

	@Override
	public void fun() {

	}
	
}
