package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.beans.InsufficientBalanceException;
import com.capgemini.beans.InsufficientOpeningBalanceException;
import com.capgemini.beans.InvalidAccountNumberException;
import com.capgemini.repo.AccountRepo;

public class AccountServiceImplementation {
	AccountRepo accRepo;
	public com.capgemini.beans.AccountRepo createAccount(int accNo,int amount) throws InsufficientOpeningBalanceException 
	
	{
		if(amount<500)
		{
			throw new InsufficientOpeningBalanceException();
		}
		com.capgemini.beans.AccountRepo account=new Account();
		account.setAccNo(accNo);
		account.setAmount(amount);
		if(accRepo.save(account))
		{
			return account;
		}
		return null;
	}
	public AccountServiceImplementation(AccountRepo accRepo) {
		super();
		this.accRepo = accRepo;
	}
	
	public com.capgemini.beans.AccountRepo deposite(int accNo,int amount) throws InvalidAccountNumberException
	{
		com.capgemini.beans.AccountRepo account=new Account();
		
			if(account.getAccNo()==accNo)
			{
		account.setAmount(account.getAmount()+amount);
		return account;
	}
			throw new  InvalidAccountNumberException();
		
	}
	public com.capgemini.beans.AccountRepo withDrawAmount(int accNo,int amount) throws InsufficientBalanceException, InvalidAccountNumberException
	{
		com.capgemini.beans.AccountRepo account=new Account();
		if((account.getAmount()-amount)>=0)
		{
			account.setAmount(account.getAmount()-amount);
			return account;
		}
		
		throw new InsufficientBalanceException();
	
}
		
	}
	


