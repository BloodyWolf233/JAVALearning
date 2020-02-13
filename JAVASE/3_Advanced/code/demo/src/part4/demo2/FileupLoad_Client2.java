package part4.demo2;

import java.io.*;
import java.net.Socket;

public class FileupLoad_Client2 {
    public static void main(String[] args) throws IOException {
        String filepath = "src\\part4\\demo2\\";
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
        //4. close socket, alert server upload success
        socket.shutdownOutput();
        System.out.println("file upload success.");
        //5. feed back
        InputStream in = socket.getInputStream();
        byte[] back = new byte[20];
        in.read(back);
        System.out.println(new String(back));
        in.close();
        //6. close
        bos.close();
        socket.close();
        bis.close();
    }
}
