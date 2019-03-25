package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RAFTest {
    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("raf", "rw")) {
            for (int i = 0; i < 10; i++) {
                randomAccessFile.writeDouble(i * 0.5);
            }
            randomAccessFile.seek(8);
            System.out.println(randomAccessFile.readDouble()); // EOF: End Of File
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
