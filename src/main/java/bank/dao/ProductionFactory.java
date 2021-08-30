package bank.dao;

import bank.service.EmailService;
import bank.service.EmailServiceImpl;

public class ProductionFactory implements MyFactory {

  @Override
  public AccountDAOImpl getAccountDAO() {
    return new AccountDAOImpl();
  }

  @Override
  public EmailService getEmailService() {
    return EmailServiceImpl.getInstance();
  }
}
