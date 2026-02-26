package com.example.postman;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PatchRequestTest {
    private static PostmanEchoClient client;
    
    @BeforeAll
    public static void setUp() {
        client = new PostmanEchoClient();
    }
    
    private Map<String, Object> createTestData() {
        Map<String, Object> data = new HashMap<>();
        data.put("patch", true);
        data.put("timestamp", 123456789);
        return data;
    }
    
    @Test
    @Order(1)
    @DisplayName("PATCH - Status code 200")
    public void testPatchStatusCode() throws Exception {
        JsonObject response = client.patch(createTestData());
        assertNotNull(response);
    }
    
    @Test
    @Order(2)
    @DisplayName("PATCH - Response fields")
    public void testPatchResponseFields() throws Exception {
        JsonObject response = client.patch(createTestData());
        assertTrue(response.has("args"));
        assertTrue(response.has("headers"));
        assertTrue(response.has("url"));
        assertTrue(response.has("json"));
    }
    
    @Test
    @Order(3)
    @DisplayName("PATCH - Data fields")
    public void testPatchDataFields() throws Exception {
        JsonObject response = client.patch(createTestData());
        JsonObject jsonData = response.getAsJsonObject("json");
        assertTrue(jsonData.get("patch").getAsBoolean());
        assertEquals(123456789, jsonData.get("timestamp").getAsInt());
    }
    
    @Test
    @Order(4)
    @DisplayName("PATCH - URL")
    public void testPatchUrl() throws Exception {
        JsonObject response = client.patch(createTestData());
        String url = response.get("url").getAsString();
        assertEquals("https://postman-echo.com/patch", url);
    }
}