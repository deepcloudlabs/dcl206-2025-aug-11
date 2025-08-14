package com.example.hr.client;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise04 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
	     ExecutorService es = Executors.newFixedThreadPool(16);
	     var myTask = new MyTask();
	     var futures = new ArrayList<Future>();
	     for (var i=0;i<100;++i) {
			 futures.add(es.submit(myTask));
	     }
	     for (var future: futures)
	    	 future.get();
	     System.err.println(myTask.getCounter());
	     es.shutdown();
	}
	
	

}

class MyTask implements Runnable {
	private AtomicInteger counter = new AtomicInteger();

	@Override
	public void run() {
		for (var i=0;i<1_000_000;++i) {
			counter.getAndIncrement();
		}
	}

	public int getCounter() {
		return counter.get();
	} 
	
	
	
	
}
