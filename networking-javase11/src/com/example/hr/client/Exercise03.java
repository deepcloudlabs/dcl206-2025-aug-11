package com.example.hr.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

public class Exercise03 {

private static final String BINANCE_WS_API = "wss://stream.binance.com:9443/ws/btcusdt@trade";
	
	public static void main(String[] args) throws IOException, InterruptedException {
		var listener = new BinanceWebSocketListener();
		HttpClient.newHttpClient()
			      .newWebSocketBuilder()
				  .buildAsync(URI.create(BINANCE_WS_API), listener);
		TimeUnit.SECONDS.sleep(30);
	}

}

class BinanceWebSocketListener implements Listener {

	@Override
	public void onOpen(WebSocket webSocket) {
		System.out.println("Connected to the binance ws server.");
		webSocket.request(100);
	}

	@Override
	public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
		System.out.println("[%s] %s".formatted(Thread.currentThread().getName(),data.toString()));
		webSocket.request(10);
		try {
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
		System.out.println("Disconnected from the binance ws server.");
		return Listener.super.onClose(webSocket, statusCode, reason);
	}

	@Override
	public void onError(WebSocket webSocket, Throwable error) {
		System.err.println("Error has occured: %s".formatted(error.getMessage()));
		Listener.super.onError(webSocket, error);
	}
	
}