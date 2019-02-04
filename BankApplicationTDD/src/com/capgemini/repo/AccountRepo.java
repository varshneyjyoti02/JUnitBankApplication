package com.capgemini.repo;

public interface AccountRepo {
	boolean save(com.capgemini.beans.AccountRepo acc);
	com.capgemini.beans.AccountRepo searchAccount(int accNo);
	

}
