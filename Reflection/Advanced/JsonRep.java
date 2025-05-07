package Advanced;
import java.lang.reflect.Field;
import java.util.Scanner;
class Person1 {
    private String name;
    private int age;
    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class JsonRep {
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder();
        json.append("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            Object value = fields[i].get(obj);
            json.append("\"").append(fields[i].getName()).append("\":");
            if (value == null) {
                json.append("null");
            } else if (value instanceof String || value instanceof Character) {
                json.append("\"").append(escapeString(value.toString())).append("\"");
            } else {
                json.append(value);
            }
            if (i < fields.length - 1) {
                json.append(",");
            }
        }
        json.append("}");
        return json.toString();
    }
    private static String escapeString(String input) {
        return input.replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t")
                .replace("\\", "\\\\");
    }
    public static void main(String[] args) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        Person1 person = new Person1(name, age);
        String json = toJson(person);
        System.out.println("JSON Representation: " + json);
        scanner.close();
    }
}
