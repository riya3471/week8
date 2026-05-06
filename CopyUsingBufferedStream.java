package week8workshop;
import java.io.*;

public class CopyUsingBufferedStream {
    public static void main(String[] args) {
        try (
            BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream("one.txt"));
            BufferedOutputStream bos =
                new BufferedOutputStream(new FileOutputStream("two.txt"))
        ) {
            int data;
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}