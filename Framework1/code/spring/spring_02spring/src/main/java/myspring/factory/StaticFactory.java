package myspring.factory;

import myspring.service.AccountService;
import myspring.service.impl.AccountServiceImpl;


/**
 * 模拟一个工厂类（该类可能是存在于jar包中，无法通过修改源码的方式来提供默认构造函数）
 */
public class StaticFactory {

    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
