package Basic;
import java.lang.reflect.*;
import java.util.Scanner;
public class ClassInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the class name (e.g java.util.ArrayList): ");
        String className = scanner.nextLine();
        try {
            Class<?> clazz = Class.forName(className);

            System.out.println("\nMethods:");
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println("  " + method.getName());
            }
            System.out.println("\nFields:");
            for (Field field : clazz.getDeclaredFields()) {
                System.out.println("  " + field.getName());
            }
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                System.out.println("  " + constructor.getName());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
        } finally {
            scanner.close();
        }
    }
}