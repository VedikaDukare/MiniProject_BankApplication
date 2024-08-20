package com.techlabs.servlet;

import java.util.Date;

public class Transaction {
    private String customerId;  // Updated to match the database column name
    private String senderAccNo;
    private String receiverAccNo;
    private String transactionType;
    private double amount;
    private Date date;

    // Getters and Setters
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getSenderAccNo() { return senderAccNo; }
    public void setSenderAccNo(String senderAccNo) { this.senderAccNo = senderAccNo; }

    public String getReceiverAccNo() { return receiverAccNo; }
    public void setReceiverAccNo(String receiverAccNo) { this.receiverAccNo = receiverAccNo; }

    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
	@Override
	public String toString() {
		return "Transaction [customerId=" + customerId + ", senderAccNo=" + senderAccNo + ", receiverAccNo="
				+ receiverAccNo + ", transactionType=" + transactionType + ", amount=" + amount + ", date=" + date
				+ ", getCustomerId()=" + getCustomerId() + ", getSenderAccNo()=" + getSenderAccNo()
				+ ", getReceiverAccNo()=" + getReceiverAccNo() + ", getTransactionType()=" + getTransactionType()
				+ ", getAmount()=" + getAmount() + ", getDate()=" + getDate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
