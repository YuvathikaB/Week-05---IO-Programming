package Exercise;
import java.util.ArrayList;
import java.util.Scanner;
public class SuppressWarningsEg {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList list = new ArrayList();
        System.out.print("Enter the number of elements of the list : ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the elements :");
        for (int i = 0; i < n; i++) {
            String element = sc.nextLine();
            list.add(element);
        }
        System.out.println("Elements in the list:");
        for (Object item : list) {
            System.out.println(item);
        }
        sc.close();
    }
}
