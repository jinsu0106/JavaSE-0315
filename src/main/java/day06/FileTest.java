package day06;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        // File: 文件 或 目录
        File file = new File("README.md");
        System.out.println(file.isFile());
        File f2 = new File("src");
        System.out.println(f2.isFile());
        System.out.println(f2.isDirectory());
    }
}

