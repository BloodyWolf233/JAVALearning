package part4.demo2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileupLoad_Server2 {
    public static void main(String[] args) throws IOException {
        String filepath = "src\\part4\\demo2\\";
        System.out.println("server start....");
        //1. create ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);

        while (true) {
            //2. establish connection
            Socket accept = serverSocket.accept();

            new Thread(() -> {
                try {
                    //3. create stream object
                    BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filepath + System.currentTimeMillis() + ".jpg"));
                    //4. read data
                    byte[] b = new byte[1024 * 8];
                    int len;
                    while ((len = bis.read(b)) != -1) {
                        bos.write(b, 0, len);
                    }
                    //5. ============write back==================
                    System.out.println("write back.....");
                    OutputStream out = accept.getOutputStream();
                    out.write("server: upload success".getBytes());
                    out.close();
                    //6. ================close====================
                    bos.close();
                    bis.close();
                    accept.close();
                    System.out.println("file upload success.");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();

        }
    }
}