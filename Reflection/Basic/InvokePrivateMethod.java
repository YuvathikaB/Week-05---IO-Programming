package Basic;
import java.lang.reflect.Method;
import java.util.Scanner;
class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}
public class InvokePrivateMethod {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number 1: ");
            int a = scanner.nextInt();
            System.out.print("Enter number 2: ");
            int b = scanner.nextInt();

            Calculator calculator = new Calculator();
            Class<?> clazz = calculator.getClass();
            Method multiplyMethod = clazz.getDeclaredMethod("multiply", int.class, int.class);
            multiplyMethod.setAccessible(true);
            int result = (int) multiplyMethod.invoke(calculator, a, b);
            System.out.println(a + " X " + b + " = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}