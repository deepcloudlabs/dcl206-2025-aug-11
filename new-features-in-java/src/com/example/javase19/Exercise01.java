package com.example.javase19;

public class Exercise01 {
	public static int distance(Object o) {
		if (o instanceof Point point) {
			return point.x() * point.x() + point.y() * point.y();
		}
		throw new IllegalArgumentException("Cannot calculate the distance!");
	}

	public static int distance19(Object o) {
		if (o instanceof Point(int x, int y)) {
			return x * x + y * y;
		}
		throw new IllegalArgumentException("Cannot calculate the distance!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

record Point(int x, int y) {
	public Point {
		if (x < 0 || y < 0)
			throw new IllegalArgumentException("coordinates must be positive!");
	}
}