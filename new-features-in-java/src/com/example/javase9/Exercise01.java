package com.example.javase9;

public class Exercise01 {
	public static void main(String[] args) {

	}
}

interface III {
	public static void f1() {
		fun();
	}

	public static void f2() {
		fun();
	}

	public static void f3() {
		fun();
	}

	private static void fun() {
	} // since java se 9

	default void g1() {
		gun();
	}

	default void g2() {
		gun();
	}

	default void g3() {
		gun();
	}

	private void gun() { // private method since java se 9
		gun();
	}

}