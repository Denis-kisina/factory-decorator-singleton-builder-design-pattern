package bank.dao;

import bank.domain.Account;
import java.util.Collection;

public class Logger extends LoggingDecorator{

  public Logger(IAccountDAO iAccountDAO) {
    super(iAccountDAO);
  }

  @Override
  public void saveAccount(Account account) {
    iAccountDAO.saveAccount(account);
    System.out.println("logging.....saving");
  }

  @Override
  public void updateAccount(Account account) {
    iAccountDAO.updateAccount(account);
    System.out.println("logging.....update");
  }

  @Override
  public Account loadAccount(long accountNumber) {
    System.out.println("logging.....account load");
    return iAccountDAO.loadAccount(accountNumber);
  }

  @Override
  public Collection<Account> getAccounts() {
    System.out.println("logging.....get accounts");
    return iAccountDAO.getAccounts();
  }
}
