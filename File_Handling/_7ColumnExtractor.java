package File_Handling;

import java.io.*;
import java.util.*;

public class _7ColumnExtractor {
    public static void main(String[] args) {
        // initialize 3 test files with sample data
        List<List<String>> testData1 = new ArrayList<>();
        testData1.add(Arrays.asList("Name", "Age", "Gender"));
        testData1.add(Arrays.asList("John", "32", "Male"));
        testData1.add(Arrays.asList("Jane", "25", "Female"));
        testData1.add(Arrays.asList("Bob", "40", "Male"));

        List<List<String>> testData2 = new ArrayList<>();
        testData2.add(Arrays.asList("Name", "Age", "Gender"));
        testData2.add(Arrays.asList("Alice", "28", "Female"));
        testData2.add(Arrays.asList("Tom", "42", "Male"));
        testData2.add(Arrays.asList("Samantha", "33", "Female"));

        List<List<String>> testData3 = new ArrayList<>();
        testData3.add(Arrays.asList("Name", "Age", "Gender"));
        testData3.add(Arrays.asList("Michael", "45", "Male"));
        testData3.add(Arrays.asList("Emily", "29", "Female"));
        testData3.add(Arrays.asList("David", "37", "Male"));

        // write test data to files
        writeCsvFile("test_data_1.csv", testData1);
        writeCsvFile("test_data_2.csv", testData2);
        writeCsvFile("test_data_3.csv", testData3);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter filename: ");
        String filename = sc.nextLine();

        System.out.print("Enter column number: ");
        int col = sc.nextInt();

        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            ArrayList<String> values = new ArrayList<>();

            String line;
            while((line = br.readLine()) != null) {
                String[] p = line.split(",");
                String val = p[col - 1].replace("\"", "");
                values.add(val);
            }

            br.close();

            System.out.println(String.join(", ", values));
        } catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void writeCsvFile(String filename, List<List<String>> data) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (List<String> row : data) {
                for (int i = 0; i < row.size(); i++) {
                    writer.write("\"");
                    for (char c : row.get(i).toCharArray()) {
                        if (c == '\"') {
                            writer.write("\"\"");
                        } else {
                            writer.write(c);
                        }
                    }
                    writer.write("\"");
                    if (i < row.size() - 1) {
                        writer.write(",");
                    }
                }
                writer.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
