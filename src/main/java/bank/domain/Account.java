package bank.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Account {

  long accountNumber;
  Collection<AccountEntry> entryList = new ArrayList<>();
  Customer customer;

  public Account(long accountnr) {
    this.accountNumber = accountnr;
  }

  public long getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public double getBalance() {
    double balance = 0;
    for (AccountEntry entry : entryList) {
      balance += entry.getAmount();
    }
    return balance;
  }

  public void deposit(double amount) {
    AccountEntry entry = new AccountEntry.Builder()
        .withDate(new Date())
        .withAmount(amount)
        .withDescription("deposit")
        .build();
    entryList.add(entry);
  }

  public void withdraw(double amount) {
    AccountEntry entry = new AccountEntry.Builder()
        .withDate(new Date())
        .withAmount(-amount)
        .withDescription("withdraw")
        .build();
    entryList.add(entry);
  }

  private void addEntry(AccountEntry entry) {
    entryList.add(entry);
  }

  public void transferFunds(Account toAccount, double amount, String description) {
    AccountEntry fromEntry = new AccountEntry.Builder()
        .withDate(new Date())
        .withAmount(-amount)
        .withDescription(description)
        .withFromAccountNumber(toAccount.getAccountNumber())
        .withFromPersonName(toAccount.getCustomer().getName())
        .build();

    AccountEntry toEntry = new AccountEntry.Builder()
        .withDate(new Date())
        .withAmount(amount)
        .withDescription(description)
        .withFromAccountNumber(toAccount.getAccountNumber())
        .withFromPersonName(toAccount.getCustomer().getName())
        .build();
    entryList.add(fromEntry);
    toAccount.addEntry(toEntry);

  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Collection<AccountEntry> getEntryList() {
    return entryList;
  }
}
