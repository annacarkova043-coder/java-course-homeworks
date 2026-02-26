package com.example.postman;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class PostmanEchoClient {
    private static final String BASE_URL = "https://postman-echo.com";
    private final HttpClient client;
    private final Gson gson;
    
    public PostmanEchoClient() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }
    
    public JsonObject get(String... queryParams) throws Exception {
        String url = buildUrl(BASE_URL + "/get", queryParams);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return JsonParser.parseString(response.body()).getAsJsonObject();
    }
    
    public JsonObject post(Map<String, Object> body) throws Exception {
        String jsonBody = gson.toJson(body);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/post"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return JsonParser.parseString(response.body()).getAsJsonObject();
    }
    
    public JsonObject put(Map<String, Object> body) throws Exception {
        String jsonBody = gson.toJson(body);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/put"))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return JsonParser.parseString(response.body()).getAsJsonObject();
    }
    
    public JsonObject patch(Map<String, Object> body) throws Exception {
        String jsonBody = gson.toJson(body);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/patch"))
                .header("Content-Type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return JsonParser.parseString(response.body()).getAsJsonObject();
    }
    
    public JsonObject delete(String... queryParams) throws Exception {
        String url = buildUrl(BASE_URL + "/delete", queryParams);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .DELETE()
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return JsonParser.parseString(response.body()).getAsJsonObject();
    }
    
    private String buildUrl(String base, String... params) {
        if (params.length == 0 || params.length % 2 != 0) {
            return base;
        }
        
        StringBuilder url = new StringBuilder(base).append("?");
        for (int i = 0; i < params.length; i += 2) {
            if (i > 0) url.append("&");
            url.append(params[i]).append("=").append(params[i + 1]);
        }
        return url.toString();
    }
}