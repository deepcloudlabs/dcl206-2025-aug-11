package com.example;

public class Exercise02 {

	private final int ARR_SIZE = 2 * 1024 * 1024;
	private volatile int[] testData = new int[ARR_SIZE]; // Heap: 2M * 4B = 8MB

	private void run() {
		System.err.println("Start: " + System.currentTimeMillis());
		for (int i = 0; i < 15_000; i++) {
			touchEveryLine();
			touchEveryItem();
		}
		System.err.println("Warmup finished: " + System.currentTimeMillis());
		System.err.println("Every Item,Every Line");

		for (int i = 0; i < 100; i++) {
			long t0 = System.nanoTime();
			touchEveryLine();
			long t1 = System.nanoTime();
			touchEveryItem();
			long t2 = System.nanoTime();
			long elItem = t2 - t1;
			long elLine = t1 - t0;
			System.err.println(elItem + "," + elLine );
		}
	}

	private void touchEveryItem() { // 16 * 10 microsec.
		for (int i = 0; i < testData.length; i++)
			testData[i]++;
	}

	private void touchEveryLine() {
		for (int i = 0; i < testData.length; i += 16)
			testData[i]++;
	}

	public static void main(String[] args) {
		var c = new Exercise02();
		c.run();
	}

}
