package com.mdu.fraudmanagement.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name = "Transaction")
@Table(name = "Transaction")
public class Transaction implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private int accNo;
	private int fraudLevel;
	private boolean isLocked; // user updated object not the, while post

	@ManyToOne()
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;

	public Transaction(int id, int accNo, int fraudLevel, boolean isLocked, User user) {
		super();
		Id = id;
		this.accNo = accNo;
		this.fraudLevel = fraudLevel;
		this.isLocked = isLocked;

		this.user = user;
	}

	public Transaction() {
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

	public int getFraudLevel() {
		return fraudLevel;
	}

	public void setFraudLevel(int fraudLevel) {
		this.fraudLevel = fraudLevel;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Transaction [Id=" + Id + ", accNo=" + accNo + ", fraudLevel=" + fraudLevel + ", isLocked=" + isLocked
				+ ", user=" + user + "]";
	}

}
