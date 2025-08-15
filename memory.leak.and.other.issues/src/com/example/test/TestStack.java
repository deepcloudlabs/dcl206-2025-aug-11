package com.example.test;

import java.util.concurrent.TimeUnit;

import com.example.util.Stack;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 * 
 */
public class TestStack {
	private static final int SIZE = 1024 * 1024;

	public static void main(String[] args) throws InterruptedException {
		Stack<LargeObject> s = new Stack<>(SIZE);
		System.out.println("Pushing %d objects into the stack".formatted(SIZE));
		for (int i = 0; i < SIZE; i++) {
			s.push(new LargeObject());
		}
		System.out.println("Stack size is %d".formatted(s.size()));
		System.out.println("Popping objects from the stack until it is empty.");
		while (!s.isEmpty()) {
			s.pop();
		}
		System.out.println("Stack is now empty: %d".formatted(s.size()));
		while (true) {
			TimeUnit.MILLISECONDS.sleep(100);
		}
	}

}

class LargeObject {
	@SuppressWarnings("unused")
	private int[] array = new int[4 * 1024];
}
