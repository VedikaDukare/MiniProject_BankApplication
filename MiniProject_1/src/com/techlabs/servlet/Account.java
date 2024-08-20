package com.techlabs.servlet;

	public class Account {
		private  int customerId;
	    private String accountNumber;
	    private double balance;
	    
	    public Account(String accountNumber, double balance) {
			this.accountNumber = accountNumber;
			this.balance = balance;
		}    

	    public String getAccountNumber() {
	        return accountNumber;
	    }


		public void setAccountNumber(String accountNumber) {
	        this.accountNumber = accountNumber;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void setBalance(double balance) {
	        this.balance = balance;
	    }

		@Override
		public String toString() {
			return "Account [accountNumber=" + accountNumber + ", balance=" + balance + "]";
		}

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
	}



