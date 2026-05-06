package week8workshop;
import java.io.*;
import java.util.*;

public class CsvToTextFiles {
    public static void main(String[] args) {

        String inputFile = "students.csv.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

            String headerLine = br.readLine();
            String[] headers = headerLine.split(",");

            Map<String, BufferedWriter> writers = new HashMap<>();

            for (String header : headers) {
                BufferedWriter bw = new BufferedWriter(
                        new FileWriter(header.trim() + ".txt")
                );
                writers.put(header.trim(), bw);
            }

            String line;
            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");

                for (int i = 0; i < headers.length; i++) {
                    BufferedWriter bw = writers.get(headers[i].trim());
                    bw.write(values[i].trim());
                    bw.newLine();
                }
            }
            for (BufferedWriter bw : writers.values()) {
                bw.close();
            }

            System.out.println("Text files created successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}