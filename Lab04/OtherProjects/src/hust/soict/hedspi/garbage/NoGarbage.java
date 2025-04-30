package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
    	String filename = "C:\\eclipse - workspace\\OtherProjects\\src\\text.txt";

        try {
            byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

            long startTime = System.currentTimeMillis();

            StringBuffer output = new StringBuffer();

            for (byte b : inputBytes) {
                output.append((char) b); 
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Time (No Garbage): " + (endTime - startTime) + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
