package bank.dao;

import java.util.*;
import bank.domain.Account;

public class AccountDAOImpl implements IAccountDAO {
	Collection<Account> accountList = new ArrayList<>();

	public void saveAccount(Account account) {
		accountList.add(account); // add the new
	}

	public void updateAccount(Account account) {
		Account accountExist = loadAccount(account.getAccountNumber());
		if (accountExist != null) {
			accountList.remove(accountExist); // remove the old
			accountList.add(account); // add the new
		}
	}

	public Account loadAccount(long accountNumber) {
		for (Account account : accountList) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return null;
	}

	public Collection<Account> getAccounts() {
		return accountList;
	}
}
