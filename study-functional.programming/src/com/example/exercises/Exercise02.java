package com.example.exercises;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.maxBy;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;

public class Exercise02 {

	public static void main(String[] args) {
		// C#: LINQ    -> parallel
		// C++: ranges
		// Java: Stream
		InMemoryWorldDao.getInstance()
		                .findAllCities()
		                .stream()
		                .collect(maxBy(comparingLong(City::getPopulation)))
		                .ifPresent(System.out::println);
	}

}
