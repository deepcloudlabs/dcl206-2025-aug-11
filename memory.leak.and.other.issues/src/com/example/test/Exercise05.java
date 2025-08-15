package com.example.test;

import java.lang.ref.WeakReference;
import java.util.Objects;

public class Exercise05 {

	public static void main(String[] args) {
		var strongRef = new Circle(1,2,3);

		WeakReference<Circle> weakRef = new WeakReference<>(strongRef);
		strongRef = null;
		System.gc(); // FullGC -> unless -XX:+DisableExplicitGC
		var circle = weakRef.get();
		if (Objects.nonNull(circle)) {
			System.out.println(circle.area());
		} else {
			System.out.println("No longer references to the Circle object.");
		}

	}

}

record Circle(int x,int y,int radius) {
	public double area() {return Math.PI * this.radius * this.radius; }
}
