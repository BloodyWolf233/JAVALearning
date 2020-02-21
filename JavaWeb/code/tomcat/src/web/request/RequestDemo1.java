package web.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 获取请求消息体
         */
        //1. get character stream
        BufferedReader reader = request.getReader();
        //2. read
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 获取请求行数据
         */
        //1. get request method: GET
        String method = request.getMethod();
        System.out.println(method);
        //2. get virtual path: /tomcat
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //3. get Servlet path: /RequestDemo1
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //4. get GET method request parameter
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //5. get URI: /tomcat/RequestDemo1
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);
        //6. get protocol and version: HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //7. get server ip
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
        /**
         * 获取请求头数据
         */
        //1. get all headers name
        Enumeration<String> headerNames = request.getHeaderNames();
        //2. get headers's values
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + "---" + value);
        }

    }
}
