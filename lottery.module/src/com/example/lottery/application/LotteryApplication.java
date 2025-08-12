package com.example.lottery.application;

import java.util.ServiceLoader;

import com.example.random.service.RandomNumberService;

public class LotteryApplication {

	public static void main(String[] args) {
		var randomNumberServices = ServiceLoader.load(RandomNumberService.class);
		for (var randomService : randomNumberServices) {
			System.out.println(randomService.getClass());
		}
		RandomNumberService rns = randomNumberServices.stream().toList().get(1).get();
		rns.draw(60, 6, 10)
		   .forEach(System.out::println);
	}

}
