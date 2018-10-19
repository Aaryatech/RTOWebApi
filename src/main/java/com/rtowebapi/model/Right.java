package com.rtowebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_right")
public class Right {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "right_id")
	private int rightId;

	@Column(name = "right_name")
	private String rightName;

	@Column(name = "is_for_mobile")
	private int isForMobile;

	@Column(name = "last_update_time")
	private String lastUpdateTime;

	@Column(name = "is_used")
	private int isUsed;

	@Column(name = "ex_str1")
	private String exStr1;

	@Column(name = "ex_str2")
	private String exStr2;

	@Column(name = "ex_int1")
	private String exInt1;

	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "date1")
	private String date1;

	@Column(name = "date2")
	private String date2;

	public int getRightId() {
		return rightId;
	}

	public void setRightId(int rightId) {
		this.rightId = rightId;
	}

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public int getIsForMobile() {
		return isForMobile;
	}

	public void setIsForMobile(int isForMobile) {
		this.isForMobile = isForMobile;
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

	public String getExInt1() {
		return exInt1;
	}

	public void setExInt1(String exInt1) {
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

	@Override
	public String toString() {
		return "Right [rightId=" + rightId + ", rightName=" + rightName + ", isForMobile=" + isForMobile
				+ ", lastUpdateTime=" + lastUpdateTime + ", isUsed=" + isUsed + ", exStr1=" + exStr1 + ", exStr2="
				+ exStr2 + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", date1=" + date1 + ", date2=" + date2 + "]";
	}

}
