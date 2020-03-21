package myspring.dao.impl;

import myspring.dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {


    public void saveAccount() {
        System.out.println("保存了账户");

    }
}
