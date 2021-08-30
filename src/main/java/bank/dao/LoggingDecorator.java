package bank.dao;

import bank.domain.Account;
import java.util.Collection;

public abstract class LoggingDecorator implements IAccountDAO {
  protected IAccountDAO iAccountDAO;

  public LoggingDecorator(IAccountDAO iAccountDAO) {
    this.iAccountDAO = iAccountDAO;
  }

  @Override
  public void saveAccount(Account account) {
    iAccountDAO.saveAccount(account);
  }

  @Override
  public void updateAccount(Account account) {
iAccountDAO.updateAccount(account);
  }

  @Override
  public Account loadAccount(long accountNumber) {
    return iAccountDAO.loadAccount(accountNumber);
  }

  @Override
  public Collection<Account> getAccounts() {
    return iAccountDAO.getAccounts();
  }
}
