package com.mdu.fraudmanagement.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

import javax.annotation.Generated;
import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;

@Data
@Table(name = "USERS")
@Entity
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//	@Generated("assigned")
    @Column(updatable = false)
    private int id;

    @Column(unique = true)
    private String userId;
    private String firstName;
    private String lastName;
    private Date dob;
    private String gender;

    @Column(unique = true)
    private String contactNo;

    @Column(unique = true)
    private String email;
    private String password;
    private boolean isAdmin;
    @Column(nullable = true)
    private int isAuthorized;

    private String ans1;
    private String ans2;
    private String ans3;

    /*
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "user")
    private List<Card> cards;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "user")
    private List<Claim> claim;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "user")
    private List<Transaction> transaction;
    */

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(int id, String userId, String firstName, String lastName, Date dob, String gender, String contactNo,
                String email, String password, boolean isAdmin, int isAuthorized, String token, String ans1,
                String ans2,
                String ans3) {
        super();
        this.id = id;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.contactNo = contactNo;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isAuthorized = isAuthorized;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getIsAuthorized() {
        return isAuthorized;
    }

    public void setIsAuthorized(int isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", dob=" + dob + ", gender=" + gender + ", contactNo=" + contactNo + ", email=" + email
                + ", password=" + password + ", isAdmin=" + isAdmin + ", isAuthorized=" + isAuthorized + ", ans1=" +
                ans1 + ", ans2=" + ans2 + ", ans3=" + ans3 + "]";
    }

}