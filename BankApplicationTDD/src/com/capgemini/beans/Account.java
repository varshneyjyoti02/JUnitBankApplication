package com.capgemini.beans;

public class Account implements AccountRepo {
	private int accNo;
	private int amount;
	/* (non-Javadoc)
	 * @see com.capgemini.beans.AccountRepo#getAccNo()
	 */
	@Override
	public int getAccNo() {
		return accNo;
	}
	/* (non-Javadoc)
	 * @see com.capgemini.beans.AccountRepo#setAccNo(int)
	 */
	@Override
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	/* (non-Javadoc)
	 * @see com.capgemini.beans.AccountRepo#getAmount()
	 */
	@Override
	public int getAmount() {
		return amount;
	}
	/* (non-Javadoc)
	 * @see com.capgemini.beans.AccountRepo#setAmount(int)
	 */
	@Override
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accNo;
		result = prime * result + amount;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accNo != other.accNo)
			return false;
		if (amount != other.amount)
			return false;
		return true;
	}
	

}
