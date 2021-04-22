package com.mdu.fraudmanagement.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.persistence.Table;


@Entity
@Table(name="CARDS")
public class Card implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private int cardNo;
	private String cardHolderName;
	private String accNo;
	private String cardType;
	private Date expiryDate;
	private String dateTime;
	private int fraudLevel;
	private boolean isBlocked;
	private String Cardcol;
	private int analysisPersonel;
	
	@ManyToOne
	private User user;
	
	
	
	
	public Card(int id, int cardNo, String cardHolderName, String accno, String cardType, Date expiryDate, String dateTime, int fraudLevel, boolean isBlocked,
			String Cardcol, int analysisPersonel) 
	{
		super();
		this.id=id;
		this.cardNo=cardNo;
		this.cardHolderName=cardHolderName;
		this.accNo=accNo;
		this.cardType=cardType;
		this.expiryDate=expiryDate;
		this.dateTime=dateTime;
		this.fraudLevel=fraudLevel;
		this.isBlocked=isBlocked;
		this.Cardcol=Cardcol;
		this.analysisPersonel=analysisPersonel;
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getdateTime() {
		return dateTime;
	}

	public void setdateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public int getFraudLevel() {
		return fraudLevel;
	}

	public void setFraudLevel(int fraudLevel) {
		this.fraudLevel = fraudLevel;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public String getCardcol() {
		return Cardcol;
	}

	public void setCardcol(String cardcol) {
		Cardcol = cardcol;
	}

	public int getAnalysisPersonel() {
		return analysisPersonel;
	}

	public void setAnalysisPersonel(int analysisPersonel) {
		this.analysisPersonel = analysisPersonel;
	}


	@Override
	public String toString() {
		return "Card [id=" + id + ", cardNo=" + cardNo + ", cardHolderName=" + cardHolderName + ", accNo=" + accNo
				+ ", cardType=" + cardType + ", expiryDate=" + expiryDate + ", dateTime=" + dateTime
				+ ", fraudLevel=" + fraudLevel + ", isBlocked=" + isBlocked + ", Cardcol=" + Cardcol
				+ ", analysisPersonel=" + analysisPersonel + "]";
	}
	
	
}
