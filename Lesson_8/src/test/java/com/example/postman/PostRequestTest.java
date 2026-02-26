package com.example.postman;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PostRequestTest {
    private static PostmanEchoClient client;
    
    @BeforeAll
    public static void setUp() {
        client = new PostmanEchoClient();
    }
    
    private Map<String, Object> createTestData() {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "test user");
        data.put("age", 25);
        data.put("active", true);
        data.put("tags", new String[]{"student", "java"});
        
        Map<String, Object> address = new HashMap<>();
        address.put("city", "Moscow");
        address.put("zip", 123456);
        data.put("address", address);
        
        return data;
    }
    
    @Test
    @Order(1)
    @DisplayName("POST - Status code 200")
    public void testPostStatusCode() throws Exception {
        JsonObject response = client.post(createTestData());
        assertNotNull(response);
    }
    
    @Test
    @Order(2)
    @DisplayName("POST - Response fields")
    public void testPostResponseFields() throws Exception {
        JsonObject response = client.post(createTestData());
        assertTrue(response.has("args"));
        assertTrue(response.has("headers"));
        assertTrue(response.has("url"));
        assertTrue(response.has("json"));
    }
    
    @Test
    @Order(3)
    @DisplayName("POST - Basic fields")
    public void testPostBasicFields() throws Exception {
        JsonObject response = client.post(createTestData());
        JsonObject jsonData = response.getAsJsonObject("json");
        assertEquals("test user", jsonData.get("name").getAsString());
        assertEquals(25, jsonData.get("age").getAsInt());
        assertTrue(jsonData.get("active").getAsBoolean());
    }
    
    @Test
    @Order(4)
    @DisplayName("POST - Tags array")
    public void testPostTags() throws Exception {
        JsonObject response = client.post(createTestData());
        JsonObject jsonData = response.getAsJsonObject("json");
        JsonArray tags = jsonData.getAsJsonArray("tags");
        assertEquals(2, tags.size());
        assertEquals("student", tags.get(0).getAsString());
        assertEquals("java", tags.get(1).getAsString());
    }
    
    @Test
    @Order(5)
    @DisplayName("POST - Address object")
    public void testPostAddress() throws Exception {
        JsonObject response = client.post(createTestData());
        JsonObject jsonData = response.getAsJsonObject("json");
        JsonObject address = jsonData.getAsJsonObject("address");
        assertEquals("Moscow", address.get("city").getAsString());
        assertEquals(123456, address.get("zip").getAsInt());
    }
    
    @Test
    @Order(6)
    @DisplayName("POST - URL")
    public void testPostUrl() throws Exception {
        JsonObject response = client.post(createTestData());
        String url = response.get("url").getAsString();
        assertEquals("https://postman-echo.com/post", url);
    }
}