package com.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exercise01 {
	private static final ExecutorService executorService = Executors.newFixedThreadPool(8);
	public static CompletableFuture<Integer> doAsyncBusiness() { // asynchronous
		return CompletableFuture.supplyAsync(()->{
			Thread.currentThread().setPriority(10); // Kernel 
			System.err.println("[%s] Running doAsyncBusiness()...".formatted(Thread.currentThread().getName()));
			try {TimeUnit.SECONDS.sleep(5);}catch(Exception e) {}
			System.err.println("[%s] Returning from doAsyncBusiness()...".formatted(Thread.currentThread().getName()));
			return 42;			
		}, executorService);
	}
	
	public static void main(String[] args) {
		System.err.println("[%s] Application is just started.".formatted(Thread.currentThread().getName()));
		doAsyncBusiness().thenAcceptAsync(
			result ->System.err.println("[%s] result is %d".formatted(Thread.currentThread().getName(),result)),
			executorService
		);
		for (var i=0;i<100;++i) {
			System.err.println("[%s] Working hard: %d".formatted(Thread.currentThread().getName(),i));
			try {TimeUnit.MILLISECONDS.sleep(250);}catch(Exception e) {}
		}
		System.out.println("[%s] Application is just completed.".formatted(Thread.currentThread().getName()));
	}

}
