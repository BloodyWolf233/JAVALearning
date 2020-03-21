package myspring.dao.impl;

import myspring.dao.AccountDao;

import java.util.Date;

public class AccountDaoImpl1 implements AccountDao {
    //如果是经常变换的数据，并不适合用于注入方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountDaoImpl1(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("保存了账户");
        System.out.println(name+","+age+","+birthday);
    }
}
