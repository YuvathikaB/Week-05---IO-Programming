package Advanced;
import java.io.*;
import java.util.*;
public class DuplicateCSV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter CSV file path: ");
        String filePath = scanner.nextLine();
        Set<String> seenIds = new HashSet<>();
        List<String> duplicates = new ArrayList<>();
        String header = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            header = reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 0) {
                    String id = data[0].trim();
                    if (!seenIds.add(id)) {
                        duplicates.add(line);
                    }
                }
            }
            if (duplicates.isEmpty()) {
                System.out.println("No duplicate IDs found.");
            } else {
                System.out.println("Duplicate records:");
                System.out.println(header);
                for (String dup : duplicates) {
                    System.out.println(dup);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
