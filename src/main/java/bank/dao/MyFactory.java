package bank.dao;

import bank.service.EmailService;

public interface MyFactory {

  IAccountDAO getAccountDAO();

  EmailService getEmailService();
}
