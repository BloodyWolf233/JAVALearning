package ssm.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.service.AccountService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSpring {

    @Test
    public void run1() {
        //加载配置文件
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取对象
        AccountService as = (AccountService) ac.getBean("accountService");
        //调用方法
        as.findAll();
    }


}
