package com.example.hr.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.util.concurrent.CompletionStage;

public class Exercise05 {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        // Toggle between request(1) and request(100) here
        final int initialRequest = 100;  

        @SuppressWarnings("unused")
		WebSocket ws = client.newWebSocketBuilder()
            .buildAsync(URI.create("wss://ws.postman-echo.com/raw"), new Listener() {
                @SuppressWarnings("unused")
				int count = 0;

                @Override
                public void onOpen(WebSocket webSocket) {
                    System.out.println("Connected");
                    webSocket.request(initialRequest); // initial demand

                    // Send 20 messages quickly
                    for (int i = 1; i <= 20; i++) {
                        webSocket.sendText("Msg " + i, true);
                    }
                }

                @Override
                public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                    count++;
                    System.out.println("Received: " + data);

                    try {
                        Thread.sleep(1000); // simulate slow processing
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    // Request the next message (controls flow)
                    webSocket.request(1);
                    return null;
                }

                @Override
                public void onError(WebSocket webSocket, Throwable error) {
                    error.printStackTrace();
                }
            }).join();

        // Keep the main thread alive
        Thread.sleep(60000);
    }
}

