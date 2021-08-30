package bank.service;

public class MockEmailServiceImpl implements EmailService {

  @Override
  public void send(double amount) {
    System.out.println("Emailing.....Account changed by " + amount);
  }
}
