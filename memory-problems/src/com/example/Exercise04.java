package com.example;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class Exercise04 {
	public static void main(String[] args) {
		var strongRef = new Circle(1, 2, 100);
		var weakRef = new WeakReference<>(strongRef);
		System.gc();
		System.out.println(weakRef.get().area());
		strongRef = null;
		System.out.println(weakRef.get().area());
		System.gc();
		System.out.println(weakRef.get());
		var cache = new WeakHashMap<String, Circle>();
		cache.put("1", new Circle(0, 0, 0));
		System.out.println(cache.containsKey("1"));
		System.gc(); // cache invalidation/eviction
		System.out.println(cache.containsKey("1"));
	}
}

record Circle(int x, int y, int radius) {
	public double area() {
		return Math.PI * this.radius * this.radius;
	}
}