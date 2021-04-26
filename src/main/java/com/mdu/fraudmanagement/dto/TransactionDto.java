package com.mdu.fraudmanagement.dto;

public class TransactionDto {
	private int Id;
	private int accNo;
	private int userId;

	public TransactionDto(int id, int accNo, int userId) {
		super();
		Id = id;
		this.accNo = accNo;
		this.userId = userId;
	}

	public TransactionDto() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "TransactionDto [Id=" + Id + ", accNo=" + accNo + ", userId=" + userId + "]";
	}

}
