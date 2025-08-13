package com.example.exercises;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.domain.Director;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

public class Exercise01 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		Map<Director, Long> directorsMovieCount = new HashMap<>();
		var movies = movieService.findAllMovies();
		// imperative programming -> external loop
		System.err.println("Imperative Programming");
		for (var movie : movies) { // external loop
			for (var director : movie.getDirectors()) { // external loop
				//directorsMovieCount.computeIfAbsent(director, _ -> 0L);
				//directorsMovieCount.computeIfPresent(director, (_, v) -> v + 1);
				directorsMovieCount.put(director, directorsMovieCount.getOrDefault(director, 0L)+1);
			}
		}
		for (var entry : directorsMovieCount.entrySet() ) {
			System.out.println("%24s: %d".formatted(entry.getKey().getName(),entry.getValue()));
		}
		System.err.println("\n\n\nFunctional Programming");
		// functional programming -> internal loop
		// HoF (Higher-Order Function)
		// Stream API -> pipeline -> Chain of HoFs
		// pipeline: efficient
		// methods: i. intermediary ii. terminal
		// Stream API: i) map/reduce framework
		//            ii) parallel() -> fork/join framework (java se 7) -> job/task stealing algorithms
        movies.stream()                                     // Stream<Movie>
              .parallel() // multi-core programming
              //.map( movie -> movie.getDirectors())          // Stream<Collection<Director>>
              .map( Movie::getDirectors )          // Stream<Collection<Director>>
              //.flatMap(collection -> collection.stream())   // Stream<Director>
              .flatMap(Collection::stream)   // Stream<Director>
              .collect(groupingBy(identity(),counting()))
              .forEach((director,count) -> System.out.println("%24s: %d".formatted(director.getName(),count)));
        // clean version
        movies.stream().map(Movie::getDirectors).flatMap(Collection::stream).collect(groupingBy(identity(),counting()))
        .forEach((director,count) -> System.out.println("%24s: %d".formatted(director.getName(),count)));
	}

}
