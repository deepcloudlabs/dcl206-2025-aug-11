package com.example;

import java.io.Closeable;
import java.io.IOException;

public class Exercise03 {

	public static void main(String[] args) {

		try(
				var res1 = new PreciousResource(1);
				var res2 = new PreciousResource(2);
				var res3 = new PreciousResource(3);				
				) { // try-with-resources
			throw new IllegalStateException("Something is wrong!");
		}  catch (Exception e) {
			System.out.println(e.getMessage());
			for (var suppressedException: e.getSuppressed()) {
				System.out.println(suppressedException.getMessage());
			}
		}
		
	}

}

class PreciousResource implements Closeable {

	private final int id ;
	
	public PreciousResource(int id) {
		this.id = id;
	}

	@Override
	public void close() throws IOException {
		System.err.println("Closing the resource %d...".formatted(id));
		throw new IllegalStateException("Error has occured while closing the resource %d".formatted(id));
	}
	
}