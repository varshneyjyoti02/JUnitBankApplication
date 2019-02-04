package com.capgemini.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.beans.Account;
import com.capgemini.beans.InsufficientOpeningBalanceException;
import com.capgemini.beans.InvalidAccountNumberException;
import com.capgemini.repo.AccountRepo;
import com.capgemini.service.AccountServiceImplementation;

public class AccountServiceImplement {

	@Mock
	AccountRepo accRepo;
	AccountServiceImplementation accService;
	@Before
	public void setUp()throws Exception
	{
		MockitoAnnotations.initMocks(this);
		accService=new AccountServiceImplementation(accRepo);
	}

	@Test(expected =com.capgemini.beans.InsufficientOpeningBalanceException.class)
	public void whenTheAmountIsLessThan500SystemShouldThrowException() throws InsufficientOpeningBalanceException
	{
		accService.createAccount(101, 400);
	}
	
	@Test
	public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InsufficientOpeningBalanceException
	{
		Account account =new Account();
		account.setAccNo(101);
		account.setAmount(5000);
		when(accRepo.save(account)).thenReturn(true);
		assertEquals(account, accService.createAccount(101, 5000));
	}

	@Test(expected =com.capgemini.beans.InvalidAccountNumberException.class)
	public void whenTheInvalidAccountNoShouldThrowException() throws InvalidAccountNumberException
	{
		Account account =new Account();
		account.setAccNo(101);
		account.setAmount(5000);
		when(accRepo.save(account)).thenReturn(true);
		assertEquals(account, accService.deposite(101,5000));
	}

}
