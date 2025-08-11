package com.example.javase7;

public class Exercise06 {

	public static void main(String[] args) {
		try( // try-with-resources (3)
			PreciousResource res1 = new PreciousResource(1);
			PreciousResource res2 = new PreciousResource(2);
			PreciousResource res3 = new PreciousResource(3);		
		) { 
			// use resources
			res1.useResource();
			res2.useResource();
			res3.useResource();
			throw new IllegalStateException("Something is wrong!");
		}catch (Exception e) {
			System.err.println("An error has occured: %s".formatted(e.getMessage()));
            for (Throwable suppressedException : e.getSuppressed()) {
            	System.err.println("An error has occured while closing the resource: %s".formatted(suppressedException.getMessage()));
            }
		} 
		
	}

}
