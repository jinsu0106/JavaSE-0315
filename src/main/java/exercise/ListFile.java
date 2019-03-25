package exercise;

import java.io.File;

public class ListFile {
    public void listJavaFile(String fileName) {
        File file = new File(fileName);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                String name = files[i].getName();
                if (name.trim().toLowerCase().endsWith(".java")) {
                    System.out.println(name + "\t");
                }
                if (files[i].isDirectory()) {
                    String path = files[i].getPath();
                    listJavaFile(path);
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListFile listfile = new ListFile();
        listfile.listJavaFile("C:");
    }
}
