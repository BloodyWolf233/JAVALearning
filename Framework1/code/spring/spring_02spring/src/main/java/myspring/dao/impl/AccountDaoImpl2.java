package myspring.dao.impl;

import myspring.dao.AccountDao;

import java.util.Date;

public class AccountDaoImpl2 implements AccountDao {
    //如果是经常变换的数据，并不适合用于注入方式
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("保存了账户");
        System.out.println(name+","+age+","+birthday);
    }
}
