package com.example.lottery.application;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.example.lottery.annotation.RandomNumber;
import com.example.lottery.model.LotteryModel;

public class LotteryApplication {

	public static void main(String[] args) {
		var lotteryModel = new LotteryModel();
		generate(lotteryModel);
		System.out.println(lotteryModel.getNumbers());

	}

	public static void generate(Object o) { // Reflection
		var clazz = o.getClass();
		for (var field: clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(RandomNumber.class)) {
				var randomNumber = field.getAnnotation(RandomNumber.class);
				var numbers = generateRandomNumbers(randomNumber);
				try {
					field.setAccessible(true);
					field.set(o, numbers); // reflection
					field.setAccessible(false);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					System.err.println("Error has occured: %s".formatted(e.getMessage()));
				}
			}
		}
	}
	
	public static List<Integer> generateRandomNumbers(RandomNumber randomNumber){
		return ThreadLocalRandom.current()
				                .ints(randomNumber.min(), randomNumber.max())
				                .distinct()
				                .limit(randomNumber.size())
				                .sorted()
				                .boxed()
				                .toList();
	}
}
