package bank.dao;

import bank.service.EmailService;
import bank.service.MockEmailServiceImpl;

public class MockFactory implements MyFactory {

  @Override
  public IAccountDAO getAccountDAO() {
    return new MockIAccountDAOImpl();
  }

  @Override
  public EmailService getEmailService() {
    return new MockEmailServiceImpl();
  }
}
