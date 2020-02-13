package part4.demo3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
* GET /demo/web/index.html HTTP/1.1
* Host: localhost:8080
* Connection: keep-alive
* Upgrade-Insecure-Requests: 1
* User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36
* Accept:
* Sec-Fetch-Site: none
* Sec-Fetch-Mode: navigate
* Accept-Encoding: gzip, deflate, br
* Accept-Language: zh-CN,zh;q=0.9
* */
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("server started, wait for connection.....");
        //1. create socket
        ServerSocket server = new ServerSocket(8080);
        Socket socket = server.accept();
        //2. deal the request message
        BufferedReader readwb = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String requst = readwb.readLine();
        //get request path
        String[] strArr = requst.split(" ");
        //get ride of what's before web
        String path = strArr[1].substring(1);
        //System.out.println(path);

        //3. read local file that client request
        FileInputStream fis = new FileInputStream(path);
        byte[] bytes = new byte[1024];
        int len = 0;

        //4. create byte stream to send
        OutputStream out = socket.getOutputStream();
        //write
        out.write("HTTP/1.1 200 OK\r\n".getBytes());
        out.write("Content-Type:text/html\r\n".getBytes());
        out.write("\r\n".getBytes());

        while((len = fis.read(bytes))!=-1){
            out.write(bytes,0,len);
        }

        fis.close();
        out.close();
        readwb.close();
        socket.close();
        server.close();
    }
}
