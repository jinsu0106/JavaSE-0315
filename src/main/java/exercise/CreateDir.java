package exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CreateDir {
    public static void main(String[] args) {
        createFile();
        readTxt();
    }

    public static void createFile() {
        File dir = new File("D:/Jinsu");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File text = new File("D:/Jinsu/hello.txt");
        if (!text.exists()) {
            try {
                text.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public static void readTxt() {
        try {
            Scanner sc = new Scanner(new File("D:/Jinsu/hello.txt"));
            while (sc.hasNext()) {
                System.out.println(sc.next());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}