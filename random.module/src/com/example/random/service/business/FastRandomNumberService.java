package com.example.random.service.business;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.example.random.service.RandomNumberService;

public class FastRandomNumberService implements RandomNumberService {

	@Override
	public List<Integer> draw(int max, int size) {
		System.err.println("FastRandomNumberService::draw");
		return ThreadLocalRandom.current().ints(1, max)
				                .distinct()
				                .limit(size)
				                .sorted()
				                .boxed()
				                .toList();
	}

}
