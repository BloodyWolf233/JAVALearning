package part4.demo1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileupLoad_Server {
    public static void main(String[] args) throws IOException {
        String filepath = "src\\part4\\demo1\\";
        System.out.println("server start....");
        //1. create ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        //2. establish connection
        Socket accept = serverSocket.accept();
        //3. create stream object
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filepath+"copy.jpg"));
        //4. read data
        byte[] b = new byte[1024 * 8];
        int len;
        while ((len=bis.read(b))!=-1){
            bos.write(b,0,len);
        }
        //5. close
        bos.close();
        bis.close();
        accept.close();
        System.out.println("file upload success.");

    }
}
