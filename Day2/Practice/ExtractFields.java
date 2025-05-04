package org.example.practice;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
public class ExtractFields {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File jsonFile = new File("C:\\Users\\Yuvathika\\Desktop\\Java BL\\JSON\\src\\main\\resources\\users.json");
            JsonNode rootNode = objectMapper.readTree(jsonFile);
            String name = rootNode.path("name").asText();
            String email = rootNode.path("email").asText();
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
