# 二、 JAVA语言开发环境

- 2.1 [Java虚拟机——JVM](#2.1-Java虚拟机——JVM)
- 2.2 [JRE和JDK](#2.2-JRE和JDK)
- 2.3 [jdk的安装与环境变量的配置](#2.3-jdk的安装与环境变量的配置)

## 2.1 Java虚拟机——JVM

- **JVM**（Java Virtual Machine ）：Java虚拟机，简称JVM，是运行所有Java程序的假想计算机，是Java程序的 运行环境，是Java 最具吸引力的特性之一。我们编写的Java代码，都运行在 `JVM `之上。
- **跨平台**：任何软件的运行，都必须要运行在操作系统之上，而我们用Java编写的软件可以运行在任何的操作系 统上，这个特性称为**Java语言的跨平台特性**。该特性是由JVM实现的，我们编写的程序运行在JVM上，而JVM 运行在操作系统上。

![](../pics/03-JVM.png)

如图所示，Java的虚拟机本身不具备跨平台功能的，每个操作系统下都有不同版本的虚拟机。

## 2.2 JRE和JDK

- JRE (Java Runtime Environment) ：是Java程序的运行时环境，包含`JVM`和运行时所需要的`核心类库` 。
- JDK (Java Development Kit)：是Java程序开发工具包，包含`JRE`和开发人员使用的工具。

我们想要运行一个已有的Java程序，那么只需安装`JRE`即可。 

我们想要开发一个全新的Java程序，那么必须安装`JDK`。

![](../pics/04-jdk.png)

> 小贴士： 
>
> 三者关系： JDK > JRE > JVM

## 2.3 jdk的安装与环境变量的配置

**oracle官方jdk[下载地址](https://www.oracle.com/technetwork/java/javase/downloads/index.html)**

**配置环境变量的作用**

开发Java程序，需要使用JDK中提供的工具，工具在JDK9安装目录的`bin`目录下。

怎么配置百度吧，好烦。。。。

**程序开发步骤**

开发环境已经搭建完毕，可以开发我们第一个Java程序了。 Java程序开发三步骤：编写、编译、运行。

![](../pics/05-程序开发步骤.png)

