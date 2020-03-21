package test;


import myspring.dao.AccountDao;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import myspring.service.AccountService;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * 获取spring的IoC核心容器，并根据id获取对象
     * <p>
     * ApplicationContext的三个常用实现类：
     * ClassPathXmlApplicationContext：它可以加载类路径下的配置文件
     * FileSystemXmlApplicationContext: 它可以加载磁盘任意路径下的配置文件（必须要有访问权限）
     * AnnotationConfigApplicationContext: 它是用于读取注解创建容器的
     * <p>
     * 核心容器的两个接口引发的问题：
     * ApplicationContext： 适用单例对象
     * 他在构建核心容器时，创建对象采取的策略是采用立即加载的方式。
     * BeanFactory: 适用多例对象
     * 它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。
     */
    @Test
    public void test1() {
        //1. 获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2. 根据id获取Bean对象
        AccountService service = (AccountService) ac.getBean("accountService");
        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);

        System.out.println(service);
        service.saveAccount();
    }

    public void test2() {
        Resource resource = new ClassPathResource("bean2.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        AccountService service = (AccountService) factory.getBean("accountService");

        System.out.println(service);
    }

    //构造注入
    @Test
    public void test3() {
        Resource resource = new ClassPathResource("bean3.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        AccountDao service = (AccountDao) factory.getBean("accountDao");

        System.out.println(service);
        service.saveAccount();
    }

    //set注入
    @Test
    public void test4(){
        Resource resource = new ClassPathResource("bean3.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        AccountDao service = (AccountDao) factory.getBean("accountDao2");

        System.out.println(service);
        service.saveAccount();
    }

    //复杂类型注入
    @Test
    public void test5(){
        Resource resource = new ClassPathResource("bean3.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        AccountDao service = (AccountDao) factory.getBean("accountDao3");

        System.out.println(service);
        service.saveAccount();
    }


    //注解
    @Test
    public void test6(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean4.xml");
        AccountService service = (AccountService) ac.getBean("accountService");

        System.out.println(service);
        service.saveAccount();
    }

}
