package part3.demo5;

import java.io.*;

public class TransDemo {
    public static void main(String[] args) throws IOException {
        //1. set path
        String filepath = "src\\part3\\demo5\\";
        String srcFile = "file_gbk.txt";
        String destFile = "file_utf8.txt";

        //2. create stream object
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filepath+srcFile),"GBK");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filepath+destFile),"utf-8");

        //3. read data
        char[] cbuf = new char[1024];
        int len;
        while ((len = isr.read(cbuf))!=-1){
            osw.write(cbuf,0,len);
        }

        //close
        osw.close();
        isr.close();
    }
}
