package com.example.random.service.business;

import java.security.SecureRandom;
import java.util.List;

import com.example.random.service.RandomNumberService;

public class SecureRandomNumberService implements RandomNumberService {
	private SecureRandom random = new SecureRandom();
	
	@Override
	public List<Integer> draw(int max, int size) {
		System.err.println("SecureRandomNumberService::draw");
		return random.ints(1, max)
	                .distinct()
	                .limit(size)
	                .sorted()
	                .boxed()
	                .toList();
	}

}
