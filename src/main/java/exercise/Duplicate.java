package exercise;
import java.io.*;
public class Duplicate {
    public static void main(String[] args) throws Exception{
        getInputStream("C:\\heee","D:\\Jinsu");
    }
    private static void getInputStream(String pathName,String copyName)throws Exception{
        File file = new File(pathName);
        if(!file.exists())
            throw new RuntimeException("文件不存在");
        else{
            getCopy(copyName,new BufferedInputStream(new FileInputStream(file)));
        }
    }
    private static void getCopy(String copyName,BufferedInputStream bis)throws Exception{
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(copyName));
        BufferedInputStream biss = bis;
        byte[] b = new byte[biss.available()];
        int len = 0;
        while((len = biss.read(b))!=-1){
            bos.write(b, 0, len);
        }
        bos.close();
        biss.close();
        System.out.println(copyName+"复制成功！");
    }
}

