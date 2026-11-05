package File_Handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class _2CSVFileDataCount {

    // Function to create a CSV file with content if it does not already exist
    static void createCsvFileIfNotExists(String filename, String content) {
        File file = new File(filename);
        if (file.exists()) {
            return; // Skip creation if the file already exists
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error creating file " + filename + ": " + e.getMessage());
        }
    }

    // Function to create sample CSV files for testing if they do not exist
    static void createSampleCsvFiles() {
        createCsvFileIfNotExists("file1.csv", "Name,Age,Gender\nAlice,25,Female\nBob,30,Male\n");
        createCsvFileIfNotExists("file2.csv", "ID,Name,Age,Gender\n1,Alice,25,Female\n2,Bob,30,Male\n3,Charlie,35,Male\n");
        createCsvFileIfNotExists("file3.csv", "Name,Age,Gender,Height,Weight\nAlice,25,Female,1.68,60.0\nBob,30,Male,1.75,75.5\nCharlie,35,Male,1.80,80.0\nDavid,40,Male,1.83,85.5\nEmily,45,Female,1.70,65.5\n");
    }

    public static void main(String[] args) {
        // Create sample CSV files only if they do not already exist
        createSampleCsvFiles();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the filename/path of the CSV file: ");
        String filename = sc.nextLine();

        File file = new File(filename);
        if(!file.exists()) {
            System.out.println("Error: File not found.");
            return;
        }

        int rows = 0;
        int cols = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            if(line != null) {
                cols = line.split(",").length;
                while((line = br.readLine()) != null) {
                    if(!line.trim().isEmpty()) {
                        rows++;
                    }
                }
            }
        } catch(IOException e) {
            System.out.println("Error: file not found.");
            return;
        }

        System.out.println(filename + " contains " + rows + " rows and " + cols + " columns of data.");
    }
}