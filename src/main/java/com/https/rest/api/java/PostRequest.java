package com.https.rest.api.java;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.time.Duration;

public class PostRequest {
    public static final String URL_POST = "https://httpbin.org/forms/post";
    public static final String FILE_JSON = "C:/Users/PauloProgram/Music/https-rest-api-java/src/main/java/com/https/rest/api/java/file/pedido.json";
    public static void main(String[] args)  {
        // Cliente http
        HttpClient client = HttpClient.newHttpClient();

        // criar requesição
        HttpRequest request = HttpRequest.newBuilder()
                //.POST(HttpRequest.BodyPublishers.ofFile(Path.of(FILE_JSON)))
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_POST))
                .build();

        // enviar solicitação
        client.sendAsync(request,
                HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();


    }
}