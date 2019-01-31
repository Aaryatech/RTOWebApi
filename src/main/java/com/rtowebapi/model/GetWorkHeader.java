package com.rtowebapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetWorkHeader {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int workId;

	private int workTypeId;

	private int custId;

	private String vehicalNo;

	private int exInt1;
	private int exInt2;

	private String custMobile;
	private String custName;
	private String workTypeName;

	private String date1;
	private int status;

	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getVehicalNo() {
		return vehicalNo;
	}

	public void setVehicalNo(String vehicalNo) {
		this.vehicalNo = vehicalNo;
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

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getWorkTypeName() {
		return workTypeName;
	}

	public void setWorkTypeName(String workTypeName) {
		this.workTypeName = workTypeName;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public int getWorkTypeId() {
		return workTypeId;
	}

	public void setWorkTypeId(int workTypeId) {
		this.workTypeId = workTypeId;
	}

	@Override
	public String toString() {
		return "GetWorkHeader [workId=" + workId + ", workTypeId=" + workTypeId + ", custId=" + custId + ", vehicalNo="
				+ vehicalNo + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", custMobile=" + custMobile + ", custName="
				+ custName + ", workTypeName=" + workTypeName + ", date1=" + date1 + ", status=" + status + "]";
	}

	
}
