package com.example.postman;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GetRequestTest {
    private static PostmanEchoClient client;
    
    @BeforeAll
    public static void setUp() {
        client = new PostmanEchoClient();
    }
    
    @Test
    @Order(1)
    @DisplayName("GET - Status code 200")
    public void testGetStatusCode() throws Exception {
        JsonObject response = client.get();
        assertNotNull(response);
    }
    
    @Test
    @Order(2)
    @DisplayName("GET - Response fields")
    public void testGetResponseFields() throws Exception {
        JsonObject response = client.get("foo1", "bar1", "foo2", "bar2");
        assertTrue(response.has("args"));
        assertTrue(response.has("headers"));
        assertTrue(response.has("url"));
    }
    
    @Test
    @Order(3)
    @DisplayName("GET - Query parameters")
    public void testGetQueryParameters() throws Exception {
        JsonObject response = client.get("foo1", "bar1", "foo2", "bar2");
        JsonObject args = response.getAsJsonObject("args");
        assertEquals("bar1", args.get("foo1").getAsString());
        assertEquals("bar2", args.get("foo2").getAsString());
    }
    
    @Test
    @Order(4)
    @DisplayName("GET - URL")
    public void testGetUrl() throws Exception {
        JsonObject response = client.get();
        String url = response.get("url").getAsString();
        assertTrue(url.contains("https://postman-echo.com/get"));
    }
}