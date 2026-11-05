package File_Handling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class _6CSVFileDataAveraging {

    static void writeCsvFile(String filename, String[][] data) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for(String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        }
    }

    public static void main(String[] args) {
        String[][] file1 = { { "Name", "Age", "City" }, { "John", "25", "New York" }, { "Jane", "30", "San Francisco" },
                { "Mike", "35", "Chicago" } };

        String[][] file2 = { { "Name", "Age", "City" }, { "Alice", "20", "Los Angeles" }, { "Bob", "30", "Los Angeles" },
                { "Charlie", "40", "New York" } };

        String[][] file3 = { { "Name", "Age", "City" }, { "David", "25", "Chicago" }, { "Eva", "30", "Los Angeles" },
                { "Frank", "35", "New York" } };

        // Write sample files
        try {
            writeCsvFile("file1.csv", file1);
            writeCsvFile("file2.csv", file2);
            writeCsvFile("file3.csv", file3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String path = sc.nextLine();
        System.out.print("Enter the column name to filter on: ");
        String col = sc.nextLine();
        System.out.print("Enter the condition to apply: ");
        String con = sc.nextLine();

        List<String> rows = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            if(line != null) {
                String[] headers = line.split(",");
                Map<String, Integer> index = new HashMap<>();
                for(int i = 0; i < headers.length; i++) {
                    index.put(headers[i], i);
                }

                if(index.containsKey(col)) {
                    int cols = index.get(col);

                    while((line = br.readLine()) != null) {
                        String[] data = line.split(",");
                        if(data[cols].equals(con)) {
                            rows.add(line);
                        }
                    }
                }
            }
        } catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Rows that satisfy the condition: ");
        for(String r : rows) {
            System.out.println(r);
        }
    }
}