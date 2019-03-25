package exercise;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\Jinsu\\hello.txt");

        try {
            BasicFileAttributes bfa = Files.readAttributes(path,
                    BasicFileAttributes.class);
            System.out.format("Size:%s bytes %n", bfa.size());
            System.out.format("Creation Time:%s %n", bfa.creationTime());
            System.out.format("Last Access  Time:%s %n", bfa.lastAccessTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

