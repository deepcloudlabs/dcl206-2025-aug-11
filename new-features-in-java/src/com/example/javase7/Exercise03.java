package com.example.javase7;

public class Exercise03 {

	public static void fun() throws E2 {
		throw new E2();
	}

	public static void gun() throws E2, E3 {

	}

	public static void main(String[] args) throws E2, E3 {
		try {
			fun(); // E2
		} catch (E1 e) {
			throw e; // (1) re-throw -> E2 before Java SE 7
		}
		try {
			gun();
		} catch (E2 | E3 e) { // (2) multi-catch
			System.out.println("An error has occured: %s".formatted(e.getMessage()));
			throw e;
		}
	}

}

@SuppressWarnings("serial")
class E1 extends Exception {
}

@SuppressWarnings("serial")
class E2 extends E1 {
}

@SuppressWarnings("serial")
class E3 extends E1 {
}
