package com.example.javase15;

public class Exercise01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

record Point(int x,int y) {
	public Point {
	   if (x < 0 || y<0)
		   throw new IllegalArgumentException("coordinates must be positive!");
	}
}

