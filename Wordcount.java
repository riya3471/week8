package week8workshop;

import java.io.*;

public class Wordcount {
    public static void main(String[] args) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                count += line.split("\\s+").length;
            }
            System.out.println("Total words: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


