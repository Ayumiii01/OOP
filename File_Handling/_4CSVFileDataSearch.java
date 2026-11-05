package File_Handling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class _4CSVFileDataSearch {
    // Function to create sample CSV files for testing if they do not exist
    static void createSampleCsvFiles() {
        createCsvFileIfNotExists("file1.csv", "Name,Age,City\nJohn,25,New York\nJane,,San Francisco\nMike,35,\n");
        createCsvFileIfNotExists("file2.csv", "Name,Age,City\nAlice,20,Los Angeles\nBob,,Los Angeles\nCharlie,40,\n");
    }

    // Function to create a CSV file with content if it does not already exist
    static void createCsvFileIfNotExists(String filename, String content) {
        if (new File(filename).exists()) {
            return; // Skip creation if the file already exists
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error creating file " + filename + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create sample CSV files only if they do not already exist
        createSampleCsvFiles();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String path = sc.nextLine();

        File file = new File(path);
        if(!file.exists()) {
            System.out.println("Error: File not found.");
            return;
        }

        System.out.print("Enter the value to search for: ");
        String value = sc.nextLine();

        String results = "";

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();

            while((line = br.readLine()) != null) {
                String[] cols = line.split(",", -1);

                for(String col : cols) {
                    if(col.equals(value)) {
                        results += line + "\n";
                        break;
                    }
                }
            }
        } catch(IOException e) {
            System.out.println("An error occured: " + e.getMessage());
        }

        if(results.equals("")) {
            System.out.println("No results found for value '" + value + "'");
        } else {
            System.out.println("Results found for value '" + value + "': ");
            System.out.print(results);
        }
    }
}