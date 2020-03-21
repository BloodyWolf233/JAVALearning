package test;


import factory.BeanFactory;
import factory.BeanFactory2;
import org.junit.Test;
import service.AccountService;
import service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    @Test
    public void test1(){

        AccountService service = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            System.out.println(service);
            service.saveAccount();
        }
    }

    @Test
    public void test2(){
        for (int i = 0; i < 5; i++) {
            AccountService service = (AccountService) BeanFactory.getBean("accountService");
            System.out.println(service);
            service.saveAccount();
        }
    }

    @Test
    public void test3(){
        for (int i = 0; i < 5; i++) {
            AccountService service = (AccountService) BeanFactory2.getBean("accountService");
            System.out.println(service);
            service.saveAccount();
        }
    }
}
