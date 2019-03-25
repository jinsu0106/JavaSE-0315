package day05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("build.gradle");
            System.out.println((char)inputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}