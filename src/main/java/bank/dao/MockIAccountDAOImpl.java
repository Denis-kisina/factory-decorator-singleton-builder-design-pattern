package bank.dao;

import bank.domain.Account;
import java.util.ArrayList;
import java.util.Collection;

public class MockIAccountDAOImpl implements IAccountDAO {
  Collection<Account> accountList = new ArrayList<Account>();

  @Override
  public void saveAccount(Account account) {
    System.out.println("MockIAccountDAOImpl save account");
    accountList.add(account); // add the new
  }

  @Override
  public void updateAccount(Account account) {
    System.out.println("MockIAccountDAOImpl update account");
    Account accountExist = loadAccount(account.getAccountNumber());
    if (accountExist != null) {
      accountList.remove(accountExist); // remove the old
      accountList.add(account); // add the new
    }
  }

  @Override
  public Account loadAccount(long accountNumber) {
    System.out.println("MockIAccountDAOImpl load account");
    for (Account account : accountList) {
      if (account.getAccountNumber() == accountNumber) {
        return account;
      }
    }
    return null;
  }

  @Override
  public Collection<Account> getAccounts() {
    System.out.println("MockIAccountDAOImpl get account");
    return accountList;
  }
}
