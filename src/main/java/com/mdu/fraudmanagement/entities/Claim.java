package com.mdu.fraudmanagement.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;


@Entity
@Table(name="CLAIM")
public class Claim implements Serializable {



@Id
// @Column(name="userId")
@GeneratedValue(strategy= GenerationType.IDENTITY)
private int id;

private int idProofNo;
private boolean isDuplicate;
private int analysisPersonel;





public Claim(int id, int idProofNo, boolean isDuplicate, int analysisPersonel) {
super();
this.id = id;
this.idProofNo = idProofNo;
this.isDuplicate = isDuplicate;
this.analysisPersonel = analysisPersonel;
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





public int getAnalysisPersonel() {
	return analysisPersonel;
}





public void setAnalysisPersonel(int analysisPersonel) {
	this.analysisPersonel = analysisPersonel;
}





@Override
public String toString() {
	return "Claim [id=" + id + ", idProofNo=" + idProofNo + ", isDuplicate=" + isDuplicate + ", analysisPersonel="
			+ analysisPersonel + "]";
}




}

