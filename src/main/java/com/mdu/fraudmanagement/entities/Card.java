package com.mdu.fraudmanagement.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "CARDS")
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int cardNo;
    private String cardHolderName;
    private String accNo;
    private String cardType;
    private Date expiryDate;
    private Date dateTime;
    private int fraudLevel;
    private boolean isBlocked;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    public Card() {
        super();
    }

    public Card(int id, int cardNo, String cardHolderName, String accno, String cardType, Date expiryDate,
                Date dateTime, int fraudLevel, boolean isBlocked, String accNo, User user) {
        super();
        this.id = id;
        this.cardNo = cardNo;
        this.cardHolderName = cardHolderName;
        this.accNo = accNo;
        this.cardType = cardType;
        this.expiryDate = expiryDate;
        this.dateTime = dateTime;
        this.fraudLevel = fraudLevel;
        this.isBlocked = isBlocked;
        this.user = user;
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

    public Date getdateTime() {
        return dateTime;
    }

    public void setdateTime(Date dateTime) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Card [id=" + id + ", cardNo=" + cardNo + ", cardHolderName=" + cardHolderName + ", accNo=" + accNo
                + ", cardType=" + cardType + ", expiryDate=" + expiryDate + ", dateTime=" + dateTime + ", fraudLevel="
                + fraudLevel + ", isBlocked=" + isBlocked + ", user=" + user + "]";
    }

}
