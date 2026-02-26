package com.example.postman;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PutRequestTest {
    private static PostmanEchoClient client;
    
    @BeforeAll
    public static void setUp() {
        client = new PostmanEchoClient();
    }
    
    private Map<String, Object> createTestData() {
        Map<String, Object> data = new HashMap<>();
        data.put("id", 123);
        data.put("name", "updated user");
        data.put("status", "active");
        return data;
    }
    
    @Test
    @Order(1)
    @DisplayName("PUT - Status code 200")
    public void testPutStatusCode() throws Exception {
        JsonObject response = client.put(createTestData());
        assertNotNull(response);
    }
    
    @Test
    @Order(2)
    @DisplayName("PUT - Response fields")
    public void testPutResponseFields() throws Exception {
        JsonObject response = client.put(createTestData());
        assertTrue(response.has("args"));
        assertTrue(response.has("headers"));
        assertTrue(response.has("url"));
        assertTrue(response.has("json"));
    }
    
    @Test
    @Order(3)
    @DisplayName("PUT - Data fields")
    public void testPutDataFields() throws Exception {
        JsonObject response = client.put(createTestData());
        JsonObject jsonData = response.getAsJsonObject("json");
        assertEquals(123, jsonData.get("id").getAsInt());
        assertEquals("updated user", jsonData.get("name").getAsString());
        assertEquals("active", jsonData.get("status").getAsString());
    }
    
    @Test
    @Order(4)
    @DisplayName("PUT - URL")
    public void testPutUrl() throws Exception {
        JsonObject response = client.put(createTestData());
        String url = response.get("url").getAsString();
        assertEquals("https://postman-echo.com/put", url);
    }
}