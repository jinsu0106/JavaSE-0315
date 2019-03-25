package exercise;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Screen {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader("D:\\Jinsu\\hello.txt"));
        String str = null;
        int lineNumber = 0;
        while ((str = bfr.readLine()) != null) {
            lineNumber++;
            System.out.println(lineNumber + " " + str);
        }
        bfr.close();
    }
}

