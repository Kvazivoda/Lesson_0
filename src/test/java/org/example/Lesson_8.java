package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static org.junit.jupiter.api.Assertions.*;

public class Lesson_8 {
    private static final String BASE_URL = "https://postman-echo.com";
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // GET Test
    @Test
    void testGet() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/get?foo=bar"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(200, response.statusCode());

        JsonNode json = objectMapper.readTree(response.body());
        assertEquals("bar", json.path("args").path("foo").asText());
    }

    // POST Test
    @Test
    void testPost() throws Exception {
        String requestBody = "{\"name\":\"John\",\"age\":30}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/post"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(200, response.statusCode());

        JsonNode json = objectMapper.readTree(response.body());
        assertEquals("John", json.path("json").path("name").asText());
        assertEquals(30, json.path("json").path("age").asInt());
    }

    // PUT Test
    @Test
    void testPut() throws Exception {
        String requestBody = "title=Hello&content=World";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/put"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(200, response.statusCode());

        JsonNode json = objectMapper.readTree(response.body());
        assertEquals("Hello", json.path("form").path("title").asText());
        assertEquals("World", json.path("form").path("content").asText());
    }

    // PATCH Test
    @Test
    void testPatch() throws Exception {
        String requestBody = "{\"status\":\"updated\"}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/patch"))
                .header("Content-Type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(200, response.statusCode());

        JsonNode json = objectMapper.readTree(response.body());
        assertEquals("updated", json.path("json").path("status").asText());
    }

    // DELETE Test
    @Test
    void testDelete() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/delete"))
                .DELETE()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(200, response.statusCode());

        JsonNode json = objectMapper.readTree(response.body());
        assertNotNull(json.path("data")); // Проверяем наличие поля data в ответе
    }
}


