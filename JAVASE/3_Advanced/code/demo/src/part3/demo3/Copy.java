package part3.demo3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
    public static void main(String[] args) throws IOException {
        //1. create steam object
        //1.1 set stream source
        String filepath = "";
        FileInputStream fis = new FileInputStream(filepath);
        FileOutputStream fos = new FileOutputStream("test_copy.jpg");

        //2. read
        byte[] b = new byte[1024];
        int len;
        while ((len = fis.read(b))!=-1){
            fos.write(b,0,len);
        }

        //3. close
        fos.close();
        fis.close();
    }
}
