package com.mdu.fraudmanagement.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "CLAIM")
public class Claim implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int idProofNo;
	private boolean isDuplicate;

	@ManyToOne()
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;

	public Claim(int id, int idProofNo, boolean isDuplicate, User user) {
		super();
		this.id = id;
		this.idProofNo = idProofNo;
		this.isDuplicate = isDuplicate;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProofNo() {
		return idProofNo;
	}

	public void setIdProofNo(int idProofNo) {
		this.idProofNo = idProofNo;
	}

	public boolean isDuplicate() {
		return isDuplicate;
	}

	public void setDuplicate(boolean isDuplicate) {
		this.isDuplicate = isDuplicate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Claim() {
		super();
	}

	
	
	@Override
	public String toString() {
		return "Claim [id=" + id + ", idProofNo=" + idProofNo + ", isDuplicate=" + isDuplicate + ", user=" + user + "]";
	}
}
