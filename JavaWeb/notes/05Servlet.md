# 五、 Servlet

5.1 [web回顾](#5.1-web回顾)

5.2 [web服务器软件](#5.2-web服务器软件)

5.3 [IDEA与tomcat的相关配置](#5.3-IDEA与tomcat的相关配置)

5.4 [Servlet入门](#5.4-Servlet入门)

5.5 [Servlet](#5.5-Servlet)

## 5.1 web回顾

1. 软件架构

   1. C/S：客户端/服务器端
   2. B/S：浏览器/服务器端

2. 资源分类

   1. 静态资源：所有用户访问后，得到的结果都是一样的，称为静态资源.静态资源可以直接被浏览器解析

      如： html,css,JavaScript

   2. 动态资源:每个用户访问相同资源后，得到的结果可能不一样。称为动态资源。动态资源被访问后，需要先转换为静态资源，在返回给浏览器

      如：servlet/jsp,php,asp....

3. 网络通信三要素

   1. IP：电子设备(计算机)在网络中的唯一标识。
   2. 端口：应用程序在计算机中的唯一标识。 0~65536
   3. 传输协议：规定了数据传输的规则
      1. 基础协议：
         1. tcp:安全协议，三次握手。 速度稍慢
         2. udp：不安全协议。 速度快

## 5.2 web服务器软件

- 服务器：安装了服务器软件的计算机
- 服务器软件：接收用户的请求，处理请求，做出响应
- web服务器软件：接收用户的请求，处理请求，做出响应。
  - 在web服务器软件中，可以部署web项目，让用户通过浏览器来访问这些项目
  - web容器
- 常见的java相关的web服务器软件：
  - webLogic：oracle公司，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
  - webSphere：IBM公司，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
  - JBOSS：JBOSS公司的，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
  - Tomcat：Apache基金组织，中小型的JavaEE服务器，仅仅支持少量的JavaEE规范servlet/jsp。开源的，免费的。
- JavaEE：Java语言在企业级开发中使用的技术规范的总和，一共规定了13项大的规范



- Tomcat：web服务器软件

  1. 下载：http://tomcat.apache.org/
  2. 安装：解压压缩包即可。
  3. 卸载：删除目录就行了
  4. 启动：
     1. bin/startup.bat ,双击运行该文件即可
     2. 访问：浏览器输入：http://localhost:8080 回车访问自己

  > 可能遇到的问题：
  >
  > 1. 黑窗口一闪而过：
  >
  >    原因： 没有正确配置JAVA_HOME环境变量
  >
  > 2. 启动报错：
  >
  >    1. 暴力：找到占用的端口号，并且找到对应的进程，杀死该进程
  >
  >       netstat -ano
  >
  >    2. 温柔：修改自身的端口号
  >
  >       - conf/server.xml
  >
  >       - `<Connector port="8888" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8445"`
  >
  >       - 一般会将tomcat的默认端口号修改为80。80端口号是http协议的默认端口号。好处：在访问时，就不用输入端口号

  5. 关闭：

     1. 正常关闭：
        - bin/shutdown.bat
        - ctrl+c
     2. 强制关闭：
        - 点击启动窗口的×

  6. 配置：

     - 部署项目的方式：

       1. 直接将项目放到webapps目录下即可。

          - /hello：项目的访问路径-->虚拟目录
          - 简化部署：将项目打成一个war包，再将war包放置到webapps目录下。

       2. 配置conf/server.xml文件

          在`<Host>`标签体中配置

          `<Context docBase="D:\hello" path="/hehe" />`

          - docBase:项目存放的路径
          - path：虚拟目录

       3. 在conf\Catalina\localhost创建任意名称的xml文件。在文件中编写

          `<Context docBase="D:\hello" />`

          - 虚拟目录：xml文件的名称

     - 静态项目和动态项目：

       - 目录结构

       - java动态项目的目录结构：

         ```
         -- 项目的根目录
           -- WEB-INF目录：
             -- web.xml：web项目的核心配置文件
             -- classes目录：放置字节码文件的目录
             -- lib目录：放置依赖的jar包
         ```

     - 将Tomcat集成到IDEA中，并且创建JavaEE的项目，部署项目。

![](../img/05/tomcat目录结构.png)

![](../img/05/资源分类.bmp)

## 5.3 IDEA与tomcat的相关配置

1. IDEA会为每一个tomcat部署的项目单独建立一份配置文件

   查看控制台的log：`Using CATALINA_BASE:   "C:\Users\fqy\.IntelliJIdea2018.1\system\Tomcat\_tomcat"`

2. 工作空间项目和tomcat部署的web项目

   - tomcat真正访问的是“tomcat部署的web项目”，"tomcat部署的web项目"对应着"工作空间项目" 的web目录下的所有资源
   - WEB-INF目录下的资源不能被浏览器直接访问。

3. 断点调试：使用"小虫子"启动 dubug 启动

## 5.4 Servlet入门

Servlet：server applet

- 概念：运行在服务器端的小程序

  ![](../img/05/Servlet.bmp)

  - Servlet就是一个接口，定义了Java类被浏览器访问到(tomcat识别)的规则。
  - 将来我们自定义一个类，实现Servlet接口，复写方法。

- 快速入门：

  1. 创建JavaEE项目

  2. 定义一个类，实现Servlet接口

     `public class ServletDemo1 implements Servlet`

  3. 实现接口中的抽象方法

  4. 配置Servlet

     在web.xml中配置：

     ```xml
     <!--配置Servlet -->
     	    <servlet>
     	        <servlet-name>demo1</servlet-name>
     	        <servlet-class>TomcatDemo.servlet.ServletDemo1</servlet-class>
     	    </servlet>
     	
     	    <servlet-mapping>
     	        <servlet-name>demo1</servlet-name>
     	        <url-pattern>/demo1</url-pattern>
     	    </servlet-mapping>
     ```

- 执行原理：

  ![](../img/05/Servlet执行原理.bmp)

  1. 当服务器接受到客户端浏览器的请求后，会解析请求URL路径，获取访问的Servlet的资源路径
  2. 查找web.xml文件，是否有对应的<url-pattern>标签体内容。
  3. 如果有，则在找到对应的<servlet-class>全类名
  4. tomcat会将字节码文件加载进内存，并且创建其对象
  5. 调用其方法

- Servlet中的生命周期方法：

  1. 被创建：执行init方法，只执行一次

     - Servlet什么时候被创建？

       - 默认情况下，第一次被访问时，Servlet被创建

       - 可以配置执行Servlet的创建时机。

         在<servlet>标签下配置

         1. 第一次被访问时，创建；<load-on-startup>的值为负数
         2. 在服务器启动时，创建；<load-on-startup>的值为0或正整数

     - Servlet的init方法，只执行一次，说明一个Servlet在内存中只存在一个对象，Servlet是单例的

       - 多个用户同时访问时，可能存在线程安全问题。
       - 解决：尽量不要在Servlet中定义成员变量。即使定义了成员变量，也不要对修改值

  2. 提供服务：执行service方法，执行多次

     - 每次访问Servlet时，Service方法都会被调用一次。

  3. 被销毁：执行destroy方法，只执行一次

     - Servlet被销毁时执行。服务器关闭时，Servlet被销毁
     - 只有服务器正常关闭时，才会执行destroy方法。
     - destroy方法在Servlet被销毁之前执行，一般用于释放资源

- Servlet3.0：

  - 好处：支持注解配置。可以不需要web.xml了。
  - 步骤：
    1. 创建JavaEE项目，选择Servlet的版本3.0以上，可以不创建web.xml
    2. 定义一个类，实现Servlet接口
    3. 复写方法
    4. 在类上使用@WebServlet注解，进行配置

```java
@WebServlet("资源路径")
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebServlet {
    String name() default "";//相当于<Servlet-name>		

    String[] value() default {};//代表urlPatterns()属性配置

    String[] urlPatterns() default {};//相当于<url-pattern>

    int loadOnStartup() default -1;//相当于<load-on-startup>

    WebInitParam[] initParams() default {};

    boolean asyncSupported() default false;

    String smallIcon() default "";

    String largeIcon() default "";

    String description() default "";

    String displayName() default "";
}
```

3. 

## 5.5 Servlet

### 5.5.1 HTTPServlet 

1. Servlet的体系结构

   Servlet -- 接口

   ​       |

   GenericServlet -- 抽象类

   ​       |

   HTTPServlet -- 抽象类

   > - GenericServlet：将Servlet接口中其他的方法做了默认空实现，只将service()方法作为抽象
   >
   >   将来定义Servlet类时，可以继承GenericServlet，实现service()方法即可
   >
   > - HttpServlet：对http协议的一种封装，简化操作
   >
   >   1. 定义类继承HttpServlet
   >   2. 复写doGet/doPost方法

2. Servlet相关配置

   1. urlpartten:Servlet访问路径
      1. 一个Servlet可以定义多个访问路径 ： @WebServlet({"/d4","/dd4","/ddd4"})
      2. 路径定义规则：
         1. /xxx：路径匹配
         2. /xxx/xxx:多层路径，目录结构
         3. *.do：扩展名匹配

### 5.4.2 HTTP

- 概念：Hyper Text Transfer Protocol 超文本传输协议

  - 传输协议：定义了，客户端和服务器端通信时，发送数据的格式
  - 特点
    1. 基于TCP/IP的高级协议
    2. 默认端口号:80
    3. 基于请求/响应模型的:一次请求对应一次响应
    4. 无状态的：每次请求之间相互独立，不能交互数据
  - 历史版本：
    - 1.0：每一次请求响应都会建立新的连接
    - 1.1：复用连接

- 请求消息数据格式

  1. 请求行

     请求方式 请求url 请求协议/版本

     GET /login.html HTTP /1.1

     - 请求方式：HTTP协议有7中请求方式，常用的有2种
       - GET
         1. 请求参数在请求行中，在url后。
         2. 请求的url长度有限制的
         3. 不太安全
       - POST
         1. 请求参数在请求体中
         2. 请求的url长度没有限制的
         3. 相对安全

  2. 请求头：客户端浏览器告诉服务器一些信息

     请求头名称: 请求头值

     - 常见的请求头

       1. User-Agent：浏览器告诉服务器，我访问你使用的浏览器版本信息

          可以在服务器端获取该头的信息，解决浏览器的兼容性问题

       2. Referer：http://localhost/login.html

          告诉服务器，我(当前请求)从哪里来？

          作用：

          1. 防盗链
          2. 统计工作

  3. 请求空行

     空行，就是用于分割POST请求的请求头，和请求体的。

  4. 请求体（正文）

     封装POST请求消息的请求参数的

  字符串格式：

  ```
  POST /login.html	HTTP/1.1
  Host: localhost
  User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0
  Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
  Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
  Accept-Encoding: gzip, deflate
  Referer: http://localhost/login.html
  Connection: keep-alive
  Upgrade-Insecure-Requests: 1
  		
  username=zhangsan
  ```

- 响应消息数据格式

  1. 响应行

     1. 组成：协议/版本 响应状态码 状态码描述
     2. 响应状态码：服务器告诉客户端浏览器本次请求和响应的一个状态。
        1. 状态码都是3位数字
        2. 分类：
           1. 1xx：服务器就收客户端消息，但没有接受完成，等待一段时间后，发送1xx多状态码
           2. 2xx：成功。代表：200
           3. 3xx：重定向。代表：302(重定向)，304(访问缓存)
           4. 4xx：客户端错误。代表：404（请求路径没有对应的资源），405：请求方式没有对应的doXxx方法
           5. 5xx：服务器端错误。代表：500(服务器内部出现异常)

  2. 响应头

     1. 格式：头名称:值

     2. 常见的响应头

        1. Content-Type：服务器告诉客户端本次响应体数据格式以及编码格式

        2. Content-disposition：服务器告诉客户端以什么格式打开响应体数据

           值：

           - in-line:默认值,在当前页面内打开
           - attachment;filename=xxx：以附件形式打开响应体。文件下载

  3. 响应空行

  4. 响应体：传输的数据

  响应字符串格式：

  ```
  HTTP/1.1 200 OK
  Content-Type: text/html;charset=UTF-8
  Content-Length: 101
  Date: Wed, 06 Jun 2018 07:08:42 GMT
  
  <html>
  	<head>
  		<title>$Title$</title>
  	</head>
  	<body>
  	hello , response
  	</body>
  </html>
  ```

  

### 5.4.3 Request对象

![]()

1. request对象和response对象的原理

   1. request和response对象是由服务器创建的。我们来使用它们
   2. request对象是来获取请求消息，response对象是来设置响应消息

2. request对象继承体系结构：

   ServletRequest  --  接口

   ​        |        继承

   HttpServletRequest  --  接口

   ​        |        实现

   org.apache.catalina.connector.RequestFacade 类(tomcat)

3. request功能

   1. 获取请求消息数据

      1. 获取请求行数据

         -  GET /tomcat/demo1?name=zhangsan HTTP/1.1

         - 方法：

           1. 获取请求方式 ：GET

              `String getMethod()`

           2. (*)获取虚拟目录：/tomcat

              `String getContextPath()`

           3. 获取Servlet路径: /demo1

              `String getServletPath()`

           4. 获取get方式请求参数：name=zhangsan

              `String getQueryString()`

           5. (*)获取请求URI：/tomcat/demo1

              `String getRequestURI():		/tomcat/demo1`

              `StringBuffer getRequestURL()  :http://localhost/tomcat/demo1`

              - URL:统一资源定位符 ： http://localhost/tomcat/demo1    中华人民共和国
              - URI：统一资源标识符 : /tomcat/demo1    共和国

           6. 获取协议及版本：HTTP/1.1

              `String getProtocol()`

           7. 获取客户机的IP地址：

              `String getRemoteAddr()`

      2. 获取请求头数据

         方法：

         - (*)String getHeader(String name):通过请求头的名称获取请求头的值
         - Enumeration<String> getHeaderNames():获取所有的请求头名称

      3. 获取请求体数据

         - 请求体：只有POST请求方式，才有请求体，在请求体中封装了POST请求的请求参数
         - 步骤
           1. 获取流对象
              - BufferedReader getReader()：获取字符输入流，只能操作字符数据
              - ServletInputStream getInputStream()：获取字节输入流，可以操作所有类型数据
           2. 再从流对象中拿数据

   2. 其他功能

      1. 获取请求参数通用方式：不论get还是post请求方式都可以使用下列方法来获取请求参数

         1. String getParameter(String name):根据参数名称获取参数值    username=zs&password=123

         2. String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game

         3. Enumeration<String> getParameterNames():获取所有请求的参数名称

         4. Map<String,String[]> getParameterMap():获取所有参数的map集合

            中文乱码问题：

            - get方式：tomcat 8 已经将get方式乱码问题解决了
            - post方式：会乱码；解决：在获取参数前，设置request的编码request.setCharacterEncoding("utf-8");

      2. 请求转发：一种在服务器内部的资源跳转方式

         1. 步骤
            1. 通过request对象获取请求转发器对象：RequestDispatcher getRequestDispatcher(String path)
            2. 使用RequestDispatcher对象来进行转发：forward(ServletRequest request, ServletResponse response)
         2. 特点
            1. 浏览器地址栏路径不发生变化
            2. 只能转发到当前服务器内部资源中。
            3. 转发是一次请求

      3. 共享数据

         - 域对象：一个有作用范围的对象，可以在范围内共享数据
         - request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据
         - 方法
           1. void setAttribute(String name,Object obj):存储数据
           2. Object getAttitude(String name):通过键获取值
           3. void removeAttribute(String name):通过键移除键值对

      4. 获取ServletContext：

         `ServletContext getServletContext()`

### 5.4.4 案例：用户登录

#### **用户登录案例需求**：

1. 编写login.html登录页面
2. 使用Druid数据库连接池技术,操作mysql，tomcat数据库中user表
3. 使用JdbcTemplate技术封装JDBC
4. 登录成功跳转到SuccessServlet展示：登录成功！用户名,欢迎您
5. 登录失败跳转到FailServlet展示：登录失败，用户名或密码错误

#### 分析

#### 开发步骤

1. 创建项目，导入html页面，配置文件，jar包

2. 创建数据库环境

   ```
   CREATE DATABASE db3;
   USE db3;
   CREATE TABLE USER(
       id INT PRIMARY KEY AUTO_INCREMENT,
       username VARCHAR(32) UNIQUE NOT NULL,
       PASSWORD VARCHAR(32) NOT NULL
   );
   ```
   
3. 创建包loginTest.domain,创建类User

   ```java
   package loginTest.domain;
   /**
   * 用户的实体类
   */
   public class User {
       
       private int id;
       private String username;
       private String password;
       public int getId() {
           return id;
       }
   
       public void setId(int id) {
           this.id = id;
       }
   
       public String getUsername() {
           return username;
       }
   		
       public void setUsername(String username) {
           this.username = username;
       }
   
       public String getPassword() {
           return password;
       }
   
       public void setPassword(String password) {
           this.password = password;
       }
   
       @Override
       public String toString() {
           return "User{" +
               "id=" + id +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               '}';
       }
   }
   ```

4. 创建包loginTest.util,编写工具类JDBCUtils

   ```java
   package loginTest.util;
   
   import com.alibaba.druid.pool.DruidDataSourceFactory;
   
   import javax.sql.DataSource;
   import javax.xml.crypto.Data;
   import java.io.IOException;
   import java.io.InputStream;
   import java.sql.Connection;
   import java.sql.SQLException;
   import java.util.Properties;
   
   /**
    * JDBC工具类 使用Durid连接池
    */
   public class JDBCUtils {
   
       private static DataSource ds;
   
       static {
   
           try {
               //1.加载配置文件
               Properties pro = new Properties();
               //使用ClassLoader加载配置文件，获取字节输入流
               InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
               pro.load(is);
   
               //2.初始化连接池对象
               ds = DruidDataSourceFactory.createDataSource(pro);
   
           } catch (IOException e) {
               e.printStackTrace();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
   
       /**
        * 获取连接池对象
        */
       public static DataSource getDataSource() {
           return ds;
       }
   
       /**
        * 获取连接Connection对象
        */
       public static Connection getConnection() throws SQLException {
           return ds.getConnection();
       }
   }
   ```

5. 创建包loginTest.dao,创建类UserDao,提供login方法

   ```java
   package loginTest.dao;
   
   import loginTest.domain.User;
   import loginTest.util.JDBCUtils;
   import org.springframework.dao.DataAccessException;
   import org.springframework.jdbc.core.BeanPropertyRowMapper;
   import org.springframework.jdbc.core.JdbcTemplate;
   
   /**
    * 操作数据库中User表的类
    */
   public class UserDao {
   
       //声明JDBCTemplate对象共用
       private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
   
       /**
        * 登录方法
        *
        * @param loginUser 只有用户名和密码
        * @return user包含用户全部数据, 没有查询到，返回null
        */
       public User login(User loginUser) {
           try {
               //1.编写sql
               String sql = "select * from user where username = ? and password = ?";
               //2.调用query方法
               User user = template.queryForObject(sql,
                       new BeanPropertyRowMapper<User>(User.class),
                       loginUser.getUsername(), loginUser.getPassword());
               return user;
           } catch (DataAccessException e) {
               e.printStackTrace();//记录日志
               return null;
           }
       }
   }
   ```

6. 编写loginTest.web.servlet.LoginServlet类

   ```java
   package loginTest.web.servlet;
   
   import loginTest.dao.UserDao;
   import loginTest.domain.User;
   
   import javax.servlet.ServletException;
   import javax.servlet.annotation.WebServlet;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
   import java.io.IOException;
   
   @WebServlet("/loginServlet")
   public class LoginServlet extends HttpServlet {
       @Override
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           //1.设置编码
           req.setCharacterEncoding("utf-8");
           //2.获取请求参数
           String username = req.getParameter("username");
           String password = req.getParameter("password");
           //3.封装user对象
           User loginUser = new User();
           loginUser.setUsername(username);
           loginUser.setPassword(password);
   
           //4.调用UserDao的login方法
           UserDao dao = new UserDao();
           User user = dao.login(loginUser);
   
           //5.判断user
           if (user == null) {
               //登录失败
               req.getRequestDispatcher("/failServlet").forward(req, resp);
           } else {
               //登录成功
               //存储数据
               req.setAttribute("user", user);
               //转发
               req.getRequestDispatcher("/successServlet").forward(req, resp);
           }
   
       }
   
       @Override
       protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           this.doGet(req, resp);
       }
   }
   
   ```

7. 编写FailServlet和SuccessServlet类

   ```java
   @WebServlet("/successServlet")
   public class SuccessServlet extends HttpServlet {
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取request域中共享的user对象
           User user = (User) request.getAttribute("user");
   
           if (user != null) {
               //给页面写一句话
   
               //设置编码
               response.setContentType("text/html;charset=utf-8");
               //输出
               response.getWriter().write("登录成功！" + user.getUsername() + ",欢迎您");
           }
       }
   }
   ```

   ```java
   @WebServlet("/failServlet")
   public class FailServlet extends HttpServlet {
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //给页面写一句话
   
           //设置编码
           response.setContentType("text/html;charset=utf-8");
           //输出
           response.getWriter().write("登录失败，用户名或密码错误");
   
       }
   
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           this.doPost(request,response);
       }
   }
   ```

8. login.html中form表单的action路径的写法

   虚拟目录+Servlet的资源路径

9. BeanUtils工具类，简化数据封装

   用于封装JavaBean的

   1. JavaBean：标准的Java类

      1. 要求
         1. 类必须被public修饰
         2. 必须提供空参的构造器
         3. 成员变量必须使用private修饰
         4. 提供公共setter和getter方法
      2. 功能：分装数据

   2. 概念

      成员变量

      属性：setter和getter方法截取后的产物

      ​        例如：getUsername() --> Username--> username

   3. 方法

      1. setProperty()
      2. getProperty()
      3. populate(Object obj , Map map):将map集合的键值对信息，封装到对应的JavaBean对象中

   > 注意：
   >
   > 通常我们setter和getter方法名和成员变量对应，但是也可以不同。例如：
   >
   > ```java
   > private String name;
   > public void setLol(String name){
   >     this.name = name;
   > }
   > ```
   >
   > setProperty和getProperty对应的属性是lol，而不是name 

### 5.4.5 Response对象

- 功能：设置响应消息

  1. 设置响应行

     1. 格式：HTTP/1.1 200 ok
     2. 设置状态码：setStatus(int sc)

  2. 设置响应头：setHeader(String name, String value)

  3. 设置响应体

     步骤：

     1. 获取输出流：
        - 字符输出流：PrintWriter getWriter()
        - 字节输出流：ServletOutputStream getOutputStream()
     2. 使用输出流，将数据输出到客户端浏览器

- 案例

  1. 完成重定向

     - 重定向：资源跳转的方式

     - 代码实现：

       ```
       //1. 设置状态码为302
       response.setStatus(302);
       //2.设置响应头location
       response.setHeader("location","/tomcat/responseDemo2");
       
       //简单的重定向方法
       response.sendRedirect("/tomcat/responseDemo2");
       ```

     - 重定向的特点：redirect

       1. 地址栏发生变化
       2. 重定向可以访问其他站点(服务器)的资源
       3. 重定向是两次请求。不能使用request对象来共享数据

     - 转发的特点：forward

       1. 转发地址栏路径不变
       2. 转发只能访问当前服务器下的资源
       3. 转发是一次请求，可以使用request对象来共享数据

       forward和redirect的区别

     - 路径写法

       - 路径分类
         1. 相对路径：通过相对路径不可以确定唯一资源
            - 如：./index.html
            - 不以/开头，以.开头路径
            - 规则：找到当前资源和目标资源之间的相对位置关系
              - ./：当前目录
              - ../:后退一级目录
         2. 绝对路径：通过绝对路径可以确定唯一资源
            - 如：http://localhost/tomcat/responseDemo2		/tomcat/responseDemo2
            - 以/开头的路径
            - 规则：判断定义的路径是给谁用的？判断请求将来从哪儿发出
              - 给客户端浏览器使用：需要加虚拟目录(项目的访问路径)
                - **建议虚拟目录动态获取**：request.getContextPath()
                - <a> , <form> 重定向...
              - 给服务器使用：不需要加虚拟目录
                - 转发路径

  2. 服务器输出字符数据到浏览器

     步骤

     1. 获取字节输出流：`PrintWriter pw = response.getWriter();`
     2. 输出数据：`pw.write("<h1>hello,world</h1>");`

     注意：乱码问题

     1. PrintWriter pw = response.getWriter();获取的流的默认编码是ISO-8859-1

     2. 设置该流的默认编码`respnse.setCharacterEncoding("utf-8");`

     3. 告诉浏览器响应体使用的编码

        ```java
        //respnse.setHeader("content-type","text/html;charset=utf-8");
        //简单的形式，设置编码，是在获取流之前设置
        response.setContentType("text/html;charset=utf-8");
        ```

  3. 服务器输出字节数据到浏览器

     步骤

     1. 获取字节输出流：`ServletOutputStream sos = response.getOutputStream();`
     2. 输出数据：`sos.write("你好".getBytes("utf-8"));`

  4. 验证码

     1. 本质：图片
     2. 目的：防止恶意表单注册

### 5.4.6 ServletContext对象

1. 概念：代表整个web应用，可以和程序的容器(服务器)来通信

2. 获取

   1. 通过request对象获取

      request.getServletContext();

   2. 通过HttpServlet获取

      this.getServletContext();

3. 功能

   1. 获取MIME类型：

      - MIME类型:在互联网通信过程中定义的一种文件数据类型
        - 格式： 大类型/小类型   text/html		image/jpeg
      - 获取：String getMimeType(String file)

   2. 域对象：共享数据

      1. setAttribute(String name,Object value)

      2. getAttribute(String name)

      3. removeAttribute(String name)

         > ServletContext对象范围：所有用户所有请求的数据

   3. 获取文件的真实(服务器)路径

      1. 方法：String getRealPath(String path)

         ```
         String b = context.getRealPath("/b.txt");//web目录下资源访问
         System.out.println(b);
         
         String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
         System.out.println(c);
         
         String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
         System.out.println(a);
         ```

         

### 5.4.7 案例：文件下载

- 文件下载需求

  1. 页面显示超链接
  2. 点击超链接后弹出下载提示框
  3. 完成图片文件下载

- 分析：

  1. 超链接指向的资源如果能够被浏览器解析，则在浏览器中展示，如果不能解析，则弹出下载提示框。不满足需求

  2. 任何资源都必须弹出下载提示框

  3. 使用响应头设置资源的打开方式：

     content-disposition:attachment;filename=xxx

- 步骤：

  1. 定义页面，编辑超链接href属性，指向Servlet，传递资源名称filename
  2. 定义Servlet
     1. 获取文件名称
     2. 使用字节输入流加载文件进内存
     3. 指定response的响应头： content-disposition:attachment;filename=xxx
     4. 将数据写出到response输出流

- 问题：中文文件问题

  解决思路：

  1. 获取客户端使用的浏览器版本信息
  2. 根据不同的版本信息，设置filename的编码方式不同

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <a href="/day15/img/1.jpg">图片1</a>

    <a href="/day15/img/1.avi">视频</a>
    <hr>

    <a href="/day15/downloadServlet?filename=九尾.jpg">图片1</a>

    <a href="/day15/downloadServlet?filename=1.avi">视频</a>


</body>
</html>
```

```java
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数，文件名称
        String filename = request.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2用字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        //3.设置response的响应头
        //3.1设置响应头类型：content-type
        String mimeType = servletContext.getMimeType(filename);//获取文件的mime类型
        response.setHeader("content-type",mimeType);
        //3.2设置响应头打开方式:content-disposition

        //解决中文文件名问题
        //1.获取user-agent请求头、
        String agent = request.getHeader("user-agent");
        //2.使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFileName(agent, filename);

        response.setHeader("content-disposition","attachment;filename="+filename);
        //4.将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while((len = fis.read(buff)) != -1){
            sos.write(buff,0,len);
        }

        fis.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
```

```java
public class DownLoadUtils {

    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
```

