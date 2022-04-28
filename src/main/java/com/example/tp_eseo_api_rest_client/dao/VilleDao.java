package com.example.tp_eseo_api_rest_client.dao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class VilleDao {

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

    public HttpResponse<String> getVilleByCodeINSEE(String codeINSEE) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8181/ville/"+codeINSEE))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> updateVilleByCodeINSEE(String codeINSEE, String villeJSON) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(villeJSON))
                .uri(URI.create("http://localhost:8181/villes/"+codeINSEE))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .setHeader("Content-Type", "application/json")
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> deleteVilleByCodeINSEE(String codeINSEE) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create("http://localhost:8181/villes/"+codeINSEE))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
