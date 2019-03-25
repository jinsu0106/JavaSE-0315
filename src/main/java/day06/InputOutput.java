package day06;

import java.io.*;

public class InputOutput {
    public static void main(String[] args) {
        try (
                InputStream inputOutput = new FileInputStream("chapter 7 IO.pdf");
                OutputStream outputStream = new FileOutputStream("new.pdf")
        ) {
            int i = inputOutput.read();
            while (i != -1) {
                outputStream.write(i);
                i = inputOutput.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
