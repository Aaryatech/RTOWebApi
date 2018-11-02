package com.rtowebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_cust")
public class Cust {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cust_id")
	private int custId;

	@Column(name = "cust_name")
	private String custName;

	@Column(name = "cust_mobile")
	private String custMobile;

	@Column(name = "cust_password")
	private String custPassword;

	@Column(name = "cust_dob")
	private String custDob;

	@Column(name = "cust_email")
	private String custEmail;

	@Column(name = "last_update_time")
	private String lastUpdateTime;

	@Column(name = "is_used")
	private int isUsed;

	@Column(name = "ex_str1")//used for cust device token 
	private String exStr1; //used for cust device token 

	@Column(name = "ex_str2")
	private String exStr2;

	@Column(name = "ex_int1")
	private int exInt1;

	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "date1")
	private String date1;

	@Column(name = "date2")
	private String date2;

	@Column(name = "add_pincode")
	private String addPincode;

	@Column(name = "sut_time")
	private String sutTime;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	public String getCustDob() {
		return custDob;
	}

	public void setCustDob(String custDob) {
		this.custDob = custDob;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public String getExStr1() {
		return exStr1;
	}

	public void setExStr1(String exStr1) {
		this.exStr1 = exStr1;
	}

	public String getExStr2() {
		return exStr2;
	}

	public void setExStr2(String exStr2) {
		this.exStr2 = exStr2;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getAddPincode() {
		return addPincode;
	}

	public void setAddPincode(String addPincode) {
		this.addPincode = addPincode;
	}

	public String getSutTime() {
		return sutTime;
	}

	public void setSutTime(String sutTime) {
		this.sutTime = sutTime;
	}

	@Override
	public String toString() {
		return "Cust [custId=" + custId + ", custName=" + custName + ", custMobile=" + custMobile + ", custPassword="
				+ custPassword + ", custDob=" + custDob + ", custEmail=" + custEmail + ", lastUpdateTime="
				+ lastUpdateTime + ", isUsed=" + isUsed + ", exStr1=" + exStr1 + ", exStr2=" + exStr2 + ", exInt1="
				+ exInt1 + ", exInt2=" + exInt2 + ", date1=" + date1 + ", date2=" + date2 + ", addPincode=" + addPincode
				+ ", sutTime=" + sutTime + "]";
	}

}
