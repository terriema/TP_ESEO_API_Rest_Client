package com.example.tp_eseo_api_rest_client.dao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AccueilDao {

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public HttpResponse<String> getAllVilles() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8181/villes"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> getVilleByCodePostal(String codePostal) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8181/ville/"+codePostal))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
