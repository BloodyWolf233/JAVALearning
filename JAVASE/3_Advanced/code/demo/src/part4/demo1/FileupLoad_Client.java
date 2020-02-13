package part4.demo1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class FileupLoad_Client {
    public static void main(String[] args) throws IOException {
        String filepath = "src\\part4\\demo1\\";
        //1. create stream object
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\test.jpg"));
        //2. create socket
        Socket socket = new Socket("localhost", 6666);

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        //3. write
        byte[] b = new byte[1024 * 8];
        int len;
        while((len=bis.read(b))!=-1){
            bos.write(b,0,len);
            bos.flush();
        }
        System.out.println("file upload success.");
        //4. close
        bos.close();
        socket.close();
        bis.close();
    }
}
