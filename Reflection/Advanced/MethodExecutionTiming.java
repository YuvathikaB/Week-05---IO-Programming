package Advanced;
import java.lang.reflect.Method;
class SampleClass {
    public void slowMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void fastMethod() {
        System.out.println("Fast method executed!");
    }
}
public class MethodExecutionTiming {
    public static void main(String[] args) {
        String[] methodNames = {"slowMethod", "fastMethod"};
        try {
            Class<?> clazz = SampleClass.class;
            Object instance = clazz.getDeclaredConstructor().newInstance();
            for (String methodName : methodNames) {
                Method method = clazz.getDeclaredMethod(methodName);
                long startTime = System.nanoTime();
                method.invoke(instance);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println("Execution time of " + methodName + ": " + duration + " nanoseconds");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
