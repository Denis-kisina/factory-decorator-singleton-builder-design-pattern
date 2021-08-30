package bank.service;

public final class EmailServiceImpl implements EmailService {

  private static EmailServiceImpl INSTANCE;

  private EmailServiceImpl() {
  }

  @Override
  public void send(double amount) {
    System.out.println("Emailing.....Account changed by " + amount);
  }

  public static EmailService getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new EmailServiceImpl();
    }
    return INSTANCE;
  }
}
