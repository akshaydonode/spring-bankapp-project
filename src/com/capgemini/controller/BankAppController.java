package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.service.BankAccountService;

@Controller
@RequestMapping("/bank")
public class BankAppController {

	@Autowired
	private BankAccountService service;

	@RequestMapping("/new")
	public String addNew() {
	
		return "newAccount";
	}

	@RequestMapping("/newAccount")
	public String addNewAccount(@RequestParam("name") String name, @RequestParam("account_type") String accountType,
			@RequestParam("account_balance") double amount) {
		BankAccount account = new BankAccount(name,accountType,amount);
		service.addNewBankAccount(account);
		return "index";
	}
	
	@RequestMapping("/withdraw")
	public String withdraw() {
		
		return "withdraw";
	}
	
	@RequestMapping("/withdrawAccount")
	public String withdrawAccount(@RequestParam("account_id") long id,@RequestParam("account_amount") double amount) {
		
		try {
			service.withdraw(id, amount);
		} catch (AccountNotFoundException | LowBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/deposit")
	public String deposit() {
		
		return "deposit";
	}
	@RequestMapping("/depositAccount")
	public String depositAccount(@RequestParam("account_id") long id,@RequestParam("account_amount") double amount) {
		
		
		try {
			service.deposit(id, amount);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/fundtransfer")
	public String fundTransfer() {
		
		return "fundTransfer";
	}
	
	
	@RequestMapping("/fundtransferAccount")
	public String fundTransferAccount(@RequestParam("fromAccount") long fromAccount,@RequestParam("toAccount") long toAccount,@RequestParam("amount") double amount) {
	try {
		service.fundTransfer(fromAccount, toAccount, amount);
	} catch (AccountNotFoundException | LowBalanceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return "index";
	}
	
	
	@RequestMapping("/search")
	public String search() {
		
		return "searchAccount";
	}
	
	@RequestMapping("/searchAccount")
	public String searchAccount(@RequestParam("account_id") long id,Model model) {
		BankAccount account = null;
		try {
			account = service.searchAccount(id);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(account==null) {
			return "index";
		}
		model.addAttribute("accountDetails", account);
	return "displaySearchAccountDetails";
	}
	
	
	@RequestMapping("/checkBalance")
	public String checkBalance() {
		
		return "check_balance";
	}
	
	@RequestMapping("/checkBalanceAccount")
	public String checkBalanceAccount(@RequestParam("account_id") long id,Model model) {
		/*
		 * double balance= service.checkBalance(id); model.addAttribute("balance",
		 * balance); return "displayBalance";
		 */
		double balance = 0;
		try {
			balance = service.checkBalance(id);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("balance",balance);
		return "displayBalance";
	}
	
	
	@RequestMapping("/displayAllAccountDetails")
	public String displayAllBankDetails(Model model) {
		List<BankAccount> accountsList = service.findAllBankAccounts();
		model.addAttribute("accountsList",accountsList);
		return "displayAllBankAccountDetails";
	}
	
	@RequestMapping("/delete")
	public String deleteAccount() {
		
		return "delete";
	}
	
	@RequestMapping("/deleteAccount")
	public String delete(@RequestParam("account_id") long id) {
		try {
			service.deleteBankAccount(id);
		} catch (AccountNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "index";
	}
	
	@RequestMapping("/update")
	public String update() {
		
		return "update";
	}
	
	@RequestMapping("/updateAccount")
	public String updatePage(@RequestParam("account_id") long id, Model model) {
		BankAccount account = null;
		try {
			account = service.searchAccount(id);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(account==null)
			return "index";
		model.addAttribute("accountDetails", account);
		return "accountInfo";
	}
	
	@RequestMapping("/updateAccountDetails")
	public RedirectView update(@RequestParam("AccNo") long id, @RequestParam("name1") String name, @RequestParam("account_type") String type, @RequestParam("account_balance") double balance) {
		BankAccount account = new BankAccount(id, name, type, balance);
		try {
			service.updateAccountDetails(account);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("displayAllAccountDetails");
	    return redirectView;
	}
	
}
