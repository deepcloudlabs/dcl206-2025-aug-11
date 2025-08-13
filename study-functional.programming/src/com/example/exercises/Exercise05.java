package com.example.exercises;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;
import com.example.domain.Country;

public class Exercise05 {

	public static void main(String[] args) {
		InMemoryWorldDao worldDao = InMemoryWorldDao.getInstance();
		var countries = worldDao.findAllCountries();
		countries.stream()
  		         .peek(System.err::println)
		         .map(Country::getCapital)
		         .peek(System.err::println)
		         //.map(cityId -> worldDao.findCityById(cityId))
		         .map(worldDao::findCityById)
		         .peek(System.err::println)
		         .filter(Objects::nonNull)
		         .peek(System.err::println)
		         .collect(Collectors.maxBy(Comparator.comparingLong(City::getPopulation)))
		         .ifPresent(System.out::println);
		         

	}

}
