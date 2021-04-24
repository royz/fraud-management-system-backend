package com.mdu.fraudmanagement.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Transaction")
public class Transaction implements Serializable {
	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private int accNo;
	private int fraudLevel;
	private int isLocked;
	private int analysisPersonel;

	public Transaction() {
		super();
	}

	public Transaction(int id, int accNo, int fraudLevel, int isLocked, int analysisPersonel) {
		super();
		Id = id;
		this.accNo = accNo;
		this.fraudLevel = fraudLevel;
		this.isLocked = isLocked;
		this.analysisPersonel = analysisPersonel;
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

	public int getFraudLevel() {
		return fraudLevel;
	}

	public void setFraudLevel(int fraudLevel) {
		this.fraudLevel = fraudLevel;
	}

	public int getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(int isLocked) {
		this.isLocked = isLocked;
	}

	public int getAnalysisPersonel() {
		return analysisPersonel;
	}

	public void setAnalysisPersonel(int analysisPersonel) {
		this.analysisPersonel = analysisPersonel;
	}

	@Override
	public String toString() {
		return "Transaction [Id=" + Id + ", accNo=" + accNo + ", fraudLevel=" + fraudLevel + ", isLocked=" + isLocked
				+ ", analysisPersonel=" + analysisPersonel + "]";
	}

}

