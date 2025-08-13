package com.example.exercises;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Exercise04 {

	public static void main(String[] args) {
		var numbers = List.of(4,8,15,16,23,42);
		var total =
		numbers.stream()
		         .parallel()
                 .peek(n -> {
                	 System.out.println("[%s] Peek#1: %d".formatted(Thread.currentThread().getName(), n));
                 })
                 .filter(n -> n%2 == 0)
                 .peek(n -> {
                	 System.out.println("[%s] Peek#2: %d".formatted(Thread.currentThread().getName(), n));
                 })
                 .map(u -> u * u * u)
                 .peek(n -> {
                	 System.out.println("[%s] Peek#3: %d".formatted(Thread.currentThread().getName(), n));
                 })
                 .reduce(0,(acc,n)->{
                	 System.out.println("[%s] Reducing...: %d,%d".formatted(Thread.currentThread().getName(), acc,n));                	 
                	 return acc+n;
                 });
		System.out.println(total);
	}

}
