package org.example.HandsOn;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import java.util.Scanner;
import java.util.Set;
public class ValidateEmail {
    public static void main(String[] args) {
        try {
            String schemaJson = """
            {
              "$schema": "http://json-schema.org/draft-07/schema#",
              "title": "EmailSchema",
              "type": "object",
              "properties": {
                "email": {
                  "type": "string",
                  "format": "email"
                }
              },
              "required": ["email"]
            }
            """;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter JSON input (e.g., {\"email\": \"test@example.com\"}):");
            String userInput = scanner.nextLine();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode schemaNode = objectMapper.readTree(schemaJson);
            JsonNode inputNode = objectMapper.readTree(userInput);
            JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
            JsonSchema schema = schemaFactory.getSchema(schemaNode);
            Set<ValidationMessage> errors = schema.validate(inputNode);
            if (errors.isEmpty()) {
                System.out.println("email is valid.");
            } else {
                System.out.println("email is invalid. Errors:");
                for (ValidationMessage error : errors) {
                    System.out.println(" - " + error.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
