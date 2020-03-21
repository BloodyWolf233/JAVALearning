package service.impl;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    private int i = 1;

    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
