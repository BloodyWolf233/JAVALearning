# 七、 企业权限管理系统

## 7.1 AdminLTE

AdminLTE是一款建立在bootstrap和jquery之上的开源的模板主题工具，它提供了一系列响应的、可重复使用的组件，并内置了多个模板页面；同时自适应多种屏幕分辨率，兼容PC和移动端。通过AdminLTE，我们可以快速的创建一个响应式的Html5网站。AdminLTE框架在网页架构与设计上，有很大的辅助作用，尤其是前端架构设计师，用好AdminLTE不但美观，而且可以免去写很大CSS与JS的工作量。

[github源码](https://github.com/almasaeed2010/AdminLTE)

### 7.1.1 adminLTE结构

```
AdminLTE/
├── dist/
│   ├── CSS/
│   ├── JS
│   ├── img
├── build/
│   ├── less/
│   │   ├── AdminLTE's Less files
│   └── Bootstrap-less/ (Only for reference. No modifications have been made)
│       ├── mixins/
│       ├── variables.less
│       ├── mixins.less
└── plugins/
├── All the customized plugins CSS and JS files
```

AdminLTE依赖于两个框架Bootstrap3与JQuery1.11+

### 7.1.2 布局与皮肤

- 布局
  - .wrapper包住了body下的所有代码
  - .main-header里是网站的logo和导航栏的代码
  - .main-sidebar里是用户面板和侧边栏菜单的代码
  - .content-wrapper里是页面的页面和内容区域的代码
  - .main-footer里是页脚的代码
  - .control-sidebar里是页面右侧侧边栏区域的代码
- 布局选项
  - fixed：固定
  - layout-boxed：盒子布局
  - layout-top-nav：顶部隐藏
  - sidebar-collapse：侧边栏隐藏
  - sidebar-mini：侧边栏隐藏时有小图标
- 皮肤
  - skin-blue：蓝色
  - skin-black：黑色
  - skin-purple：紫色
  - skin-yellow：黄色
  - skin-red：红色
  - skin-green：绿色

以上项我们可以查看start.html页面中查看。

### 7.1.3 中文定制版

传智播客研究院针对英文版本AdminLTE进行了汉化，并优化与定制了部分页面，方便我们的学习与使用。

[github源码](https://github.com/itheima2017/adminlte2-itheima)

由于AdminLTE2-IT黑马-定制版是基于FIS3进行开发，在目录结构中assets、modules、pages、 plugins都是前端开发时所使用到的，最终发布的就是release。所以对于我们使用AdminLTE2-IT黑马-定制版来说，我们只需要关注release目录下的结构就可以。

在release目录下有css、img、pages、plugins目录。前两者就不在解决pages是产生的一些定制的页面，而plugins中是相关的插件，例如jquery、bootstrap等相关的css与js文件。

## 7.2 前端界面

本次入门案例我们基于AdminLTE2-IT黑马-定制版来完成

将AdminLTE2-IT黑马-定制版下的release目录下的css、img、plugins目录导入到我们自己的工程中

### 7.2.1 案例

编写index.html页面

本章节主要介绍使用AdminLTE2-IT黑马-定制版来完成SSM综合练习中首页、登录页面、用户管理、角色管理、资源权限管理、产品管理、订单管理页面的创建，由于定制版本(pages目录)中提供了常用的基本页面，我们只需要在此基础上进行简单修改就可以满足我们的需求。

查看pages目录中页面

其中有两种文件,一种是以all开头的html页面，一种不是。例如admin-404.html与all-admin-404.html页面，这两个文件的区别在于all开头的文件可以直接运行显示页面全部信息，而未以all开头的文件它是需要与其它文件进行组合而展示页面全部信息。

#### 首页

all-admin-index.html

#### 登录页面

all-admin-login.html

#### 用户管理页面

1. 用户查询
2. 用户添加
3. 用户详情
4. 用户添加角色

#### 用户管理页面

1. 角色查询
2. 角色添加
3. 角色添加权限

#### 资源权限管理页面

1. 权限查询
2. 权限添加

#### 产品管理页面

1. 产品查询
2. 产品详情
3. 产品添加
4. 产品修改

#### 订单管理页面

1. 订单查询
2. 订单详情

## 7.3 ssm综合练习

### 7.3.1 功能介绍

1. 商品查询

   基于SSM整合基础上完成商品查询，要掌握主面页面main.jsp及商品显示页面product-list.jsp页面的创建。

2. 商品添加

   进一步巩固SSM整合，并完成商品添加功能，要注意事务操作以及product-add.jsp页面生成。

3. 订单查询

   订单的查询操作，它主要完成简单的多表查询操作，查询订单时，需要查询出与订单关联的其它表中信息，所以一定要了解订单及其它表关联关系

4. 订单分页查询

   订单分页查询，我们使用的是mybatis分页插件PageHelper，要掌握PageHelper的基本使用。

5. 订单详情查询

   订单详情是用于查询某一个订单的信息，主要考核对复杂的多表查询操作的掌握。

6. Spring Security概述

    Spring Security是 Spring 项目组中用来提供安全认证服务的框架，它的使用很复杂，至少需要掌握spring Security框架的配置及基本的认证与授权操作。

7. 用户管理

   用户管理中我们会介绍基于spring Security的用户登录、退出操作。以及用户查询、添加、详情有等操作

8. 角色管理

   角色管理主要完成角色查询、角色添加

9. 资源权限管理

   资源权限管理主要完成查询、添加操作，它的操作与角色管理类似，角色管理以及资源权限管理都是对权限管理的 补充。

10. 权限关联与控制

    主要会讲解用户角色关联、角色权限关联，这两个操作是为了后续我们完成授权操作的基础

11. AOP日志处理

    AOP日志处理，我们使用spring AOP切面来完成系统级别的日志收集。

### 7.3.2 数据库介绍

产品表

| 序号 | 字段名称      | 字段类型      | 字段描述               |
| ---- | ------------- | ------------- | ---------------------- |
| 1    | id            | varchar2(32)  | 无意义，主键uuid       |
| 2    | productNum    | varchar2(50)  | 产品编号，唯一，不为空 |
| 3    | productName   | varchar2(50)  | 产品名称（路线名称）   |
| 4    | cityName      | varchar2(50)  | 出发城市               |
| 5    | DepartureTime | timestamp     | 出发时间               |
| 6    | productPrice  | number        | 产品价格               |
| 7    | productDesc   | varchar2(500) | 产品描述               |
| 8    | productStatus | int           | 状态（0关闭1开启）     |

订单表

| 序号 | 字段名称    | 字段类型      | 字段描述                        |
| ---- | ----------- | ------------- | ------------------------------- |
| 1    | id          | varchar2(32)  | 无意义、主键uuid                |
| 2    | orderNum    | varchar2(50)  | 订单编号 不为空 唯一            |
| 3    | orderTime   | timestamp     | 下单时间                        |
| 4    | peopleCount | int           | 出行人数                        |
| 5    | orderDesc   | varchar2(500) | 订单描述（其他信息）            |
| 6    | payType     | int           | 支付方式（0支付宝 1微信 2其他） |
| 7    | orderStatus | int           | 订单状态（0未支付 1已支付）     |
| 8    | productId   | int           | 产品id 外键                     |
| 9    | memberId    | int           | 会员（联系人）id 外键           |

会员表

| 序号 | 字段名称 | 字段类型     | 字段描述         |
| ---- | -------- | ------------ | ---------------- |
| 1    | id       | varchar2(32) | 无意义、主键uuid |
| 2    | name     | varchar2(20) | 姓名             |
| 3    | nickName | varchar2(20) | 昵称             |
| 4    | phoneNum | varchar2(20) | 电话号码         |
| 5    | email    | varchar2(20) | 邮箱             |

旅客表

| 序号 | 字段名称        | 字段类型     | 字段描述                       |
| ---- | --------------- | ------------ | ------------------------------ |
| 1    | id              | varchar2(32) | 无意义、主键uuid               |
| 2    | name            | varchar2(20) | 姓名                           |
| 3    | sex             | varchar2(20) | 性别                           |
| 4    | phoneNum        | varchar2(20) | 电话号码                       |
| 5    | credentialsType | int          | 证件类型 0身份证 1护照 2军官证 |
| 6    | credentialsNum  | varchar2(50) | 证件号码                       |
| 7    | travellerType   | int          | 旅客类型（人群） 0成人 1儿童   |

用户表

| 序号 | 字段名称 | 字段类型 | 字段描述           |
| ---- | -------- | -------- | ------------------ |
| 1    | id       | varchar2 | 无意义、主键uuid   |
| 2    | email    | varchar2 | 非空，唯一         |
| 3    | username | varchar2 | 用户名             |
| 4    | password | varchar2 | 密码（加密）       |
| 5    | phoneNum | varchar2 | 电话               |
| 6    | status   | int      | 状态 0未开启 1开启 |

角色表

| 序号 | 字段名称 | 字段类型 | 字段描述         |
| ---- | -------- | -------- | ---------------- |
| 1    | id       | varchar2 | 无意义，主键uuid |
| 2    | roleName | varchar2 | 角色名           |
| 3    | roleDesc | varchar2 | 角色描述         |

资源权限表

| 序号 | 字段名称       | 字段类型 | 字段描述         |
| ---- | -------------- | -------- | ---------------- |
| 1    | id             | varchar2 | 无意义，主键uuid |
| 2    | permissionName | varchar2 | 权限名           |
| 3    | url            | varchar2 | 资源路径         |

日志表

| 序号 | 字段名称      | 字段类型  | 字段描述         |
| ---- | ------------- | --------- | ---------------- |
| 1    | id            | varchar2  | 主键，无意义uuid |
| 2    | visitTime     | timestamp | 访问时间         |
| 3    | username      | varchar2  | 操作者用户名     |
| 4    | ip            | varchar2  | 访问ip           |
| 5    | url           | varchar2  | 访问资源url      |
| 6    | executionTime | int       | 执行时长         |
| 7    | method        | varchar2  | 访问方法         |

## 7.4 环境准备

### 7.4.1 数据库

数据库我们使用Oracle

Oracle 为每个项目创建单独user，oracle数据表存放在表空间下，每个用户有独立表空间

创建用户及密码：

```
语法[创建用户]： create user 用户名 identified by 口令[即密码]；
例子： create user test identified by test;
```

授权

```
语法： grant connect, resource to 用户名;
例子： grant connect, resource to test;
```

创建产品表：

```
CREATE TABLE product(
    id varchar2(32) default SYS_GUID() PRIMARY KEY,
    productNum VARCHAR2(50) NOT NULL,
    productName VARCHAR2(50),
    cityName VARCHAR2(50),
    DepartureTime timestamp,
    productPrice Number,
    productDesc VARCHAR2(500),
    productStatus INT,
    CONSTRAINT product UNIQUE (id, productNum)
)
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice,
productdesc, productstatus)
values ('676C5BD1D35E429A8C2E114939C5685A', 'test-002', '北京三日游', '北京', to_timestamp('10-
10-2018 10:10:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1200, '不错的旅行', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice,
productdesc, productstatus)
values ('12B7ABF2A4C544568B0A7C69F36BF8B7', 'test-003', '上海五日游', '上海', to_timestamp('25-
04-2018 14:30:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1800, '魔都我来了', 0);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice,
productdesc, productstatus)
values ('9F71F01CB448476DAFB309AA6DF9497F', 'test-001', '北京三日游', '北京', to_timestamp('10-
10-2018 10:10:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1200, '不错的旅行', 1);
```

### 7.4.2 maven工程

子模块：ssm-web ssm-domain ssm-service ssm-dao ssm-utils，其中创建ssm-web 时注意我们选择一个web工程

编写代码并测试

## 7.5 订单操作

### 7.5.1 表结构创建与分析

### 7.5.2 订单查询

### 7.5.3 订单分页查询

#### PageHelper

PageHelper是国内非常优秀的一款开源的mybatis分页插件，它支持基本主流与常用的数据库，例如mysql、oracle、mariaDB、DB2、SQLite、Hsqldb等。

本项目在 github 的项目地址：https://github.com/pagehelper/Mybatis-PageHelper

本项目在 gitosc 的项目地址：http://git.oschina.net/free/Mybatis_PageHelper

maven坐标

```
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper</artifactId>
    <version>最新版本</version>
</dependency>
```

#### 配置

特别注意，新版拦截器是`com.github.pagehelper.PageInterceptor`。`com.github.pagehelper.PageHelper`现在是一个特殊的`dialect`实现类，是分页插件的默认实现类，提供了和以前相同的用法。

在MyBatis配置xml中配置拦截器插件

```xml
<!--
    plugins在配置文件中的位置必须符合要求，否则会报错，顺序如下:
    properties?, settings?,
    typeAliases?, typeHandlers?,
    objectFactory?,objectWrapperFactory?,
    plugins?,
    environments?, databaseIdProvider?, mappers?
-->
<plugins>
    <!-- com.github.pagehelper为PageHelper类所在包名 -->
    <plugin interceptor="com.github.pagehelper.PageInterceptor">
        <!-- 使用下面的方式配置参数，后面会有所有的参数介绍 -->
        <property name="param1" value="value1"/>
    </plugin>
</plugins>
```

 在Spring配置文件中配置拦截器插件

使用spring的属性配置方式，可以使用`plugins`属性像下面这样配置：

```xml
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <!-- 注意其他配置 -->
    <property name="plugins">
        <array>
            <bean class="com.github.pagehelper.PageInterceptor">
                <property name="properties">
                    <!--使用下面的方式配置参数，一行配置一个 -->
                    <value>
                        params=value1
                    </value>
                </property>
            </bean>
        </array>
    </property>
</bean>
```

#### 分页插件参数介绍

1. `helperDialect`：分页插件会自动检测当前的数据库链接，自动选择合适的分页方式。你可以配置`helperDialect`属性来指定分页插件使用哪种方言。配置时，可以使用下面的缩写值：`oracle`,`mysql`,`mariadb`,`sqlite`,`hsqldb`,`postgresql`,`db2`,`sqlserver`,`informix`,`h2`,`sqlserver2012`,`derby`

   特别注意：使用SqlServer2012数据库时，需要手动指定为`sqlserver2012`，否则会使用SqlServer2005的方式进行分页。

   你也可以实现`AbstractHelperDialect`，然后配置该属性为实现类的全限定名称即可使用自定义的实现方法。

2. `offsetAsPageNum`：默认值为`false`，该参数对使用`RowBounds`作为分页参数时有效。当该参数设置为`true`时，会将`RowBounds`中的`offset`参数当成`pageNum`使用，可以用页码和页面大小两个参数进行分页。

3. `rowBoundsWithCount`：默认值为`false`，该参数对使用`RowBounds`作为分页参数时有效。当该参数设置为`true`时，使用`RowBounds`分页会进行`count`查询。

4. `pageSizeZero`：默认值为`false`，当该参数设置为`true`时，如果`pageSize=0`或者`RowBounds.limit=0`就会查询出全部的结果（相当于没有执行分页查询，但是返回结果仍然是`Page`类型）。

5. `reasonable`：分页合理化参数，默认值为`false`。当该参数设置为`true`时，`pageNum<=0`时会查询第一页，`pageNum>pages`（超过总数时），会查询最后一页。默认`false`时，直接根据参数进行查询。

6. `params`：为了支持`startPage(Object params)`方法，增加了该参数来配置参数映射，用于从对象中根据属性名取值，可以配置`pageNum,pageSize,count,pageSizeZero,reasonable`，不配置映射的用默认值，默认值为`pageNum=pageNum;pageSize=pageSize;count=countSql;reasonable=reasonable;pageSizeZero=pageSizeZero`。

7. `supportMethodsArguments`：支持通过`Mapper`接口参数来传递分页参数，默认值`false`，分页插件会从查询方法的参数值中，自动根据上面`params`配置的字段中取值，查找到合适的值时就会自动分页。使用方法可以参考测试代码中的`com.github.pagehelper.test.basic`包下的`ArgumentsMapTest`和`ArgumentsObjTest`。

8. `autoRuntimeDialect`：默认值为`false`。设置为`true`时，允许在运行时根据多数据源自动识别对应方言的分页（不支持自动选择`sqlserver2012`，只能使用`sqlserver`），用法和注意事项参考下面的场景五。

9. `closeConn`：默认值为`true`。当使用运行时动态数据源或没有设置`helperDialect`属性自动获取数据库类型时，会自动获取一个数据库连接，通过该属性来设置是否关闭获取的这个连接，默认`true`关闭，设置为`false`后，不会关闭获取的连接，这个参数的设置要根据自己选择的数据源来决定。

#### 基本使用

PageHelper的基本使用有6种，最常用的有两种

. RowBounds方式的调用

```
List list = sqlSession.selectList("x.y.selectIf", null, new RowBounds(1, 10));
```

使用这种调用方式时，你可以使用RowBounds参数进行分页，这种方式侵入性最小，我们可以看到，通过RowBounds方式调用只是使用了这个参数，并没有增加其他任何内容。

分页插件检测到使用了RowBounds参数时，就会对该查询进行**物理分页**。

关于这种方式的调用，有两个特殊的参数是针对`RowBounds`的，可以参看上面的分页插件参数介绍

注：不只有命名空间方式可以用RowBounds，使用接口的时候也可以增加RowBounds参数，例如：

```
//这种情况下也会进行物理分页查询
List<Country> selectAll(RowBounds rowBounds);
```

注意： 由于默认情况下的`RowBounds`无法获取查询总数，分页插件提供了一个继承自`RowBounds`的`PageRowBounds`，这个对象中增加了`total`属性，执行分页查询后，可以从该属性得到查询总数。

 PageHelper.startPage 静态方法调用

这种方式是我们要掌握的，在你需要进行分页的MyBatis查询方法前调用PageHelper.startPage 静态方法即可，紧跟在这个方法后的第一个MyBatis 查询方法会被进行分页。

```
//获取第1页，10条内容，默认查询总数count
PageHelper.startPage(1, 10);
//紧跟着的第一个select方法会被分页
List<Country> list = countryMapper.selectIf(1);
```

### 7.5.3 订单详情

## 7.6 权限操作

### 7.6.1 数据库与表结构

### 7.6.2 Spring Security

Spring Security 的前身是 Acegi Security ，是 Spring 项目组中用来提供安全认证服务的框架。

(https://projects.spring.io/spring-security/) Spring Security 为基于J2EE企业应用软件提供了全面安全服务。特别是使用领先的J2EE解决方案-Spring框架开发的企业软件项目。人们使用Spring Security有很多种原因，不过通常吸引他们的是在J2EE Servlet规范或EJB规范中找不到典型企业应用场景的解决方案。 特别要指出的是他们不能再 WAR 或 EAR 级别进行移植。这样，如果你更换服务器环境，就要，在新的目标环境进行大量的工作，对你的应用系统进行重新配置安全。使用Spring Security 解决了这些问题，也为你提供很多有用的，完全可以指定的其他安全特性。 安全包括两个主要操作。

- “认证”，是为用户建立一个他所声明的主体。主题一般式指用户，设备或可以在你系统中执行动作的其他系统。
- “授权”指的是一个用户能否在你的应用中执行某个操作，在到达授权判断之前，身份的主题已经由身份验证过程建立了。

这些概念是通用的，不是Spring Security特有的。在身份验证层面，Spring Security广泛支持各种身份验证模式，这些验证模型绝大多数都由第三方提供，或则正在开发的有关标准机构提供的，例如 Internet Engineering Task Force.作为补充，Spring Security 也提供了自己的一套验证功能。

Spring Security 目前支持认证一体化如下认证技术： HTTP BASIC authentication headers (一个基于IEFT RFC 的标准) HTTP Digest authentication headers (一个基于IEFT RFC 的标准) HTTP X.509 client certificate exchange (一个基于IEFT RFC 的标准) LDAP (一个非常常见的跨平台认证需要做法，特别是在大环境) Form-based authentication (提供简单用户接口的需求) OpenID authentication Computer Associates Siteminder JA-SIG Central Authentication Service (CAS，这是一个流行的开源单点登录系统) Transparent authentication context propagation for Remote Method Invocation and HttpInvoker (一个Spring远程调用协议)

Maven依赖

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-web</artifactId>
        <version>5.0.1.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-config</artifactId>
        <version>5.0.1.RELEASE</version>
    </dependency>
</dependencies>
```

#### 入门

web.xml

```xml
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:spring-security.xml</param-value>
</context-param>
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
<filter>
    <filter-name>springSecurityFilterChain</filter-name>
    <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
</filter>
<filter-mapping>
    <filter-name>springSecurityFilterChain</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

spring security配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:security="http://www.springframework.org/schema/security"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd
http://www.springframework.org/schema/security
http://www.springframework.org/schema/security/spring-security.xsd">
    <security:http auto-config="true" use-expressions="false">
        <!-- intercept-url定义一个过滤规则 pattern表示对哪些url进行权限控制，ccess属性表示在请求对应
        的URL时需要什么权限，
        默认配置时它应该是一个以逗号分隔的角色列表，请求的用户只需拥有其中的一个角色就能成功访问对应
        的URL -->
        <security:intercept-url pattern="/**" access="ROLE_USER" />
        <!-- auto-config配置后，不需要在配置下面信息 <security:form-login /> 定义登录表单信息
        <security:http-basic
        /> <security:logout /> -->
    </security:http>
    <security:authentication-manager>
        <security:authentication-provider>
            <security:user-service>
                <security:user name="user" password="{noop}user"
                               authorities="ROLE_USER" />
                <security:user name="admin" password="{noop}admin"
                               authorities="ROLE_ADMIN" />
            </security:user-service>
        </security:authentication-provider>
    </security:authentication-manager>
</beans>
```

测试

在webapp下创建一个index.html页面，在页面中任意写些内容。

当我们访问index.html页面时发现会弹出登录窗口，可能你会奇怪，我们没有建立下面的登录页面，为什么Spring Security会跳到上面的登录页面呢？这是我们设置http的auto-config=”true”时Spring Security自动为我们生成的。

#### 数据库认证

在Spring Security中如果想要使用数据进行认证操作，有很多种操作方式，这里我们介绍使用UserDetails、UserDetailsService来完成操作。

- UserDetails

  ```java
  public interface UserDetails extends Serializable {
      Collection<? extends GrantedAuthority> getAuthorities();
      String getPassword();
      String getUsername();
      boolean isAccountNonExpired();
      boolean isAccountNonLocked();
      boolean isCredentialsNonExpired();
      boolean isEnabled();
  }
  ```

  UserDetails是一个接口，我们可以认为UserDetails作用是于封装当前进行认证的用户信息，但由于其是一个接口，所以我们可以对其进行实现，也可以使用Spring Security提供的一个UserDetails的实现类User来完成操作

  以下是User类的部分代码

  ```java
  public class User implements UserDetails, CredentialsContainer {
      private String password;
      private final String username;
      private final Set<GrantedAuthority> authorities;
      private final boolean accountNonExpired; //帐户是否过期
      private final boolean accountNonLocked; //帐户是否锁定
      private final boolean credentialsNonExpired; //认证是否过期
      private final boolean enabled; //帐户是否可用
  ｝
  ```

- UserDetailsService

  ```java
  public interface UserDetailsService {
      UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
  }
  ```


### 7.6.3 SpringSecurity源码分析

#### 在web.xml文件中配置

问题:为什么DelegatingFilterProxy的filter-name必须是springSecurityFilterChain?

DelegatingFilterProxy并不是真正的Filter，在其initFilterBean方法中会从WebApplicationContext根据delegate 来获取到

```java
protected void initFilterBean() throws ServletException {
    synchronized (this.delegateMonitor) {
        if (this.delegate == null) {
            // If no target bean name specified, use filter name.
            if (this.targetBeanName == null) {
                this.targetBeanName = getFilterName();
            }
            // Fetch Spring root application context and initialize the delegate early,
            // if possible. If the root application context will be started after this
            // filter proxy, we'll have to resort to lazy initialization.
            WebApplicationContext wac = findWebApplicationContext();
            if (wac != null) {
                this.delegate = initDelegate(wac);
            }
        }
    }
}
```

在上这代码中this.targetBeanName=getFilterName()就是获取名称叫做springSecurityFilterChain

通过在doFilter就去中我们会发现真正干活的其实是delegate这个Filter,而delegate其实就是FilterChainProxy

```java
public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    // Lazily initialize the delegate if necessary.
    Filter delegateToUse = this.delegate;
    if (delegateToUse == null) {
        synchronized (this.delegateMonitor) {
            delegateToUse = this.delegate;
            if (delegateToUse == null) {
                WebApplicationContext wac = findWebApplicationContext();
                if (wac == null) {
                    throw new IllegalStateException("No WebApplicationContext found: " +
                    "no ContextLoaderListener or DispatcherServlet registered?");
                }
                delegateToUse = initDelegate(wac);
            }
            this.delegate = delegateToUse;
        }
    }
    // Let the delegate perform the actual doFilter operation.
    invokeDelegate(delegateToUse, request, response, filterChain);
}
```

FilterChainProxy是spring在解析配置文件时装配到上下文中，并且beanName为springSecurityFilterChain，

因此在web.xml中需要配置filter-name为springSecurityFilterChain

#### 在spring-security.xml文件中配置

在配置文件中我们主要使用标签来过多成配置

```xml
<!-- 配置不拦截的资源 -->
<security:http pattern="/login.jsp" security="none"/>
<security:http pattern="/failer.jsp" security="none"/>
<security:http pattern="/css/**" security="none"/>
<security:http pattern="/img/**" security="none"/>
<security:http pattern="/plugins/**" security="none"/>
<security:http auto-config="true" use-expressions="false">
<security:intercept-url pattern="/**" access="ROLE_USER,ROLE_ADMIN"/>
<security:form-login
        login-page="/login.jsp"
        login-processing-url="/login.do"
        default-target-url="/index.jsp"
        authentication-failure-url="/failer.jsp"
        authentication-success-forward-url="/pages/main.jsp"
/>
</security:http>
```

http标签是自定义标签，我们可以在spring-security-config包中查看

```
http\://www.springframework.org/schema/security=org.springframework.security.config.SecurityName
spaceHandler
```

继续查看SecurityNamespaceHandler类，在其init方法

```
public void init() {
    loadParsers();
}
```

在loadParsers()方法中，指定由HttpSecurityBeanDefinitionParser进行解析

```
parsers.put(Elements.HTTP, new HttpSecurityBeanDefinitionParser());
```

在HttpSecurityBeanDefinitionParser完成具体解析的parse方法中

```
registerFilterChainProxyIfNecessary(pc, pc.extractSource(element));
```

这里就是注册了名为springSecurityFilterChain的filterChainProxy类

接下我们在看一下注册一系列Filter的地方createFilterChain，在这个方法中我们重点关注

```
AuthenticationConfigBuilder authBldr = new AuthenticationConfigBuilder(element,
        forceAutoConfig, pc, httpBldr.getSessionCreationPolicy(),
        httpBldr.getRequestCache(), authenticationManager,
        httpBldr.getSessionStrategy(), portMapper, portResolver,
        httpBldr.getCsrfLogoutHandler());
```

我们可以查看AuthenticationConfigBuilder创建代码

```
public AuthenticationConfigBuilder(Element element, boolean forceAutoConfig,
        ParserContext pc, SessionCreationPolicy sessionPolicy,
        BeanReference requestCache, BeanReference authenticationManager,
        BeanReference sessionStrategy, BeanReference portMapper,
        BeanReference portResolver, BeanMetadataElement csrfLogoutHandler) {
    this.httpElt = element;
    this.pc = pc;
    this.requestCache = requestCache;
    autoConfig = forceAutoConfig | "true".equals(element.getAttribute(ATT_AUTO_CONFIG));
    this.allowSessionCreation = sessionPolicy != SessionCreationPolicy.NEVER && sessionPolicy != SessionCreationPolicy.STATELESS;
    this.portMapper = portMapper;
    this.portResolver = portResolver;
    this.csrfLogoutHandler = csrfLogoutHandler;
    createAnonymousFilter();
    createRememberMeFilter(authenticationManager);
    createBasicFilter(authenticationManager);
    createFormLoginFilter(sessionStrategy, authenticationManager);
    createOpenIDLoginFilter(sessionStrategy, authenticationManager);
    createX509Filter(authenticationManager);
    createJeeFilter(authenticationManager);
    createLogoutFilter();
    createLoginPageFilterIfNeeded();
    createUserDetailsServiceFactory();
    createExceptionTranslationFilter();
}
```

### 7.6.4 用户管理

### 7.6.5 角色管理

### 7.6.6 资源权限管理

### 7.6.7 权限关联与控制

## 7.7 AOP日志

### 7.7.1 数据库与表结构

### 7.7.2 基于AOP日志处理

