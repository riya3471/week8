package week8workshop;

import java.io.*;
import java.util.*;

public class NumberFileProcessor {

    public List<Integer> read(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String[] data = br.readLine().split(" ");
            for (String s : data) {
                numbers.add(Integer.parseInt(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }

    public List<Integer> getEven(List<Integer> numbers) {
        List<Integer> even = new ArrayList<>();
        for (int n : numbers) {
            if (n % 2 == 0) {
                even.add(n);
            }
        }
        return even;
    }

    public List<Integer> getOdd(List<Integer> numbers) {
        List<Integer> odd = new ArrayList<>();
        for (int n : numbers) {
            if (n % 2 != 0) {
                odd.add(n);
            }
        }
        return odd;
    }

    public void write(List<Integer> numbers, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (int n : numbers) {
                bw.write(n + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NumberFileProcessor obj = new NumberFileProcessor();
        List<Integer> all = obj.read("numbers.txt");
        obj.write(obj.getEven(all), "even.txt");
        obj.write(obj.getOdd(all), "odd.txt");
    }
}


