package week8workshop;
import java.io.*;
import java.util.*;

public class ProductAverage {
    public static void main(String[] args) {
        String inputFile = "products.txt";
        String outputFile = "average.csv";

        Map<String, List<Double>> productMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");

                String product = parts[0].trim();
                double price = Double.parseDouble(parts[1].trim());

                productMap.putIfAbsent(product, new ArrayList<>());
                productMap.get(product).add(price);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

   
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            bw.write("Product,AveragePrice\n");

            for (String product : productMap.keySet()) {
                List<Double> prices = productMap.get(product);

                double sum = 0;
                for (double p : prices) {
                    sum += p;
                }

                double avg = sum / prices.size();

                bw.write(product + "," + avg + "\n");
            }

            System.out.println("Average written to CSV!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}