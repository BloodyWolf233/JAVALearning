package ssm.service;

import ssm.domain.Account;

import java.util.List;

/**
 * 业务层
 */
public interface AccountService {

    public List<Account> findAll();

    public void saveAccount(Account account);
}
