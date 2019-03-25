package exercise;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void main(String[] args) {
        java.io.Writer wr = null;
        try {
            wr = new FileWriter("D:\\Jinsu\\hello.txt", true);
            wr.write("姓名:tester" +
                    "性别:male" +
                    "年龄:18" +
                    "班级:201601");
            wr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (wr != null) {
                try {
                    wr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
