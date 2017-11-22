package com.collaborate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.type.TrueFalseType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

//import com.collaboration.model.BlogComment;

@Entity
@Table
public class Users 
{
	@Id
	private String userId;
	
	@NotEmpty(message="Enter the FirstName")
	private String firstName;
	
	@NotEmpty(message="Enter the LastName")
	private String lastName;
	
	@NotEmpty(message="Enter the Role")
	private String role;
	
	private boolean status;
	private String isOnline;
	
	@Pattern(regexp="[\\d]{10}",message="Please enter 10 digits")			//regexp=regular expression is an object that describes a pattern of characters.
	@NotNull
	@Size(min=8,max=10,message="Enter Correct Phone no.")
	private String phonenumber;
	
	@NotNull(message="Password is Null")
	private String password;
	
	@Email(message="Enter valid Email")			//@Email,@NotEmpty=hibernate validation
	@NotEmpty(message="Enter the Email")
	@Column(nullable=false,unique=true)
	private String email;
	
	private String rejectReason;
	
	

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
