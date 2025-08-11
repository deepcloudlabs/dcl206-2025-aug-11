package com.example.javase7;

import java.io.Closeable;
import java.io.IOException;

public class Exercise05 {

	public static void main(String[] args) {
		PreciousResource res1 = new PreciousResource(1);
		PreciousResource res2 = new PreciousResource(2);
		PreciousResource res3 = new PreciousResource(3);
		try {
			// use resources
			throw new IllegalStateException("Something is wrong!");
		} finally {
			try {
				res1.close();
			} catch (IOException e) {
				System.err.println("An error has occured while closing the resuorce: %s".formatted(e.getMessage()));
			} finally {
				try {
					res2.close();
				} catch (IOException e) {
					System.err.println("An error has occured while closing the resuorce: %s".formatted(e.getMessage()));
				} finally {
					try {
						res3.close();
					} catch (IOException e) {
						System.err.println("An error has occured while closing the resuorce: %s".formatted(e.getMessage()));
					} finally {
						System.err.println("Finally all resources are closed!");
					}
				}
			}
		}
	}

}

class PreciousResource implements Closeable {
	private final int resourceId;

	public PreciousResource(int resourceId) {
		this.resourceId = resourceId;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void useResource() {
		System.out.println("Using the resource (%d)...".formatted(resourceId));
	}
	
	@Override
	public void close() throws IOException {
		System.err.println("Resource[%d] is closing now...".formatted(resourceId));
		throw new IllegalArgumentException("Ooopps [%d]".formatted(resourceId));
	}
	
	
}
