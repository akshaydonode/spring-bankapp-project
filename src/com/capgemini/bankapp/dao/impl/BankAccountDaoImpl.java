package com.capgemini.bankapp.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.model.BankAccount;;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {

	Logger logger = Logger.getLogger(BankAccountDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public BankAccountDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;

	}

	@Override
	public double getBalance(long accountId) throws AccountNotFoundException {
		String query = "SELECT account_balance FROM bankaccounts WHERE account_id = " + accountId;
		Double balance = -1.0;
		try {
			balance = jdbcTemplate.queryForObject(query, Double.class);
		} catch (Exception e) {
			throw new AccountNotFoundException("account doesn't exist");
		}
		return balance;
	}

	@Override
	public void updateBalance(long accountId, double newBalance) throws AccountNotFoundException {
		String query = "UPDATE bankaccounts SET account_balance = " + newBalance + " WHERE account_id = " + accountId;
		try {
			jdbcTemplate.update(query);
		} catch (Exception e) {
			throw new AccountNotFoundException("account doesn't exist");
		}

	}

	@Override
	public boolean deleteBankAccount(long accountId) throws AccountNotFoundException {
		String query = "DELETE FROM bankaccounts WHERE account_id = " + accountId;
		try {
			int result = jdbcTemplate.update(query);
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			throw new AccountNotFoundException("account doesn't exist");
		}

		return false;
	}

	@Override
	public boolean addNewBankAccount(BankAccount account) {
		String query = "INSERT INTO bankaccounts (customer_name, account_type, account_balance) VALUES (?, ?, ?)";
		Object[] params = { account.getAccountHolderName(), account.getAccountType(), account.getAccountBalance() };

		int result = jdbcTemplate.update(query, params);
		if (result == 1) {
			return true;
		}

		return false;
	}

	@Override
	public List<BankAccount> findAllBankAccounts() {
		String query = "SELECT * FROM bankaccounts";
		List<BankAccount> accounts = jdbcTemplate.query(query, (result, rowNum) -> {
			BankAccount account = new BankAccount(result.getLong(1), result.getString(2), result.getString(3),
					result.getDouble(4));

			return account;
		});

		return accounts;
	}

	@Override
	public BankAccount searchAccount(long accountId) throws AccountNotFoundException {
		String query = "SELECT * FROM bankaccounts WHERE account_id = " + accountId;
		BankAccount account = null;
		try {
			account = jdbcTemplate.queryForObject(query, (result, rowNum) -> {
				BankAccount accounts = new BankAccount(result.getLong(1), result.getString(2), result.getString(3),
						result.getDouble(4));
				return accounts;
			});
		} catch (Exception e) {
			throw new AccountNotFoundException("account doesn't exist");
		}
		return account;
	}

	@Override
	public boolean updateAccountDetails(BankAccount account) throws AccountNotFoundException {
		String query = "UPDATE bankaccounts SET customer_name = ?, account_type = ? WHERE account_id = ?";
		Object[] params = { account.getAccountHolderName(), account.getAccountType(), account.getAccountId() };
		try {
			int result = jdbcTemplate.update(query, params);
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			throw new AccountNotFoundException("account doesn't exist");
		}
		return false;
	}

}
