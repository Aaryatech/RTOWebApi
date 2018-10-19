package com.rtowebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_work_detail")
public class WorkDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "work_detail_id")
	private int workDetailId;

	@Column(name = "work_id")
	private int workId;

	@Column(name = "work_desc")
	private String workDesc;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "inner_task_id")
	private int innerTaskId;

	@Column(name = "date")
	private String date;

	@Column(name = "date_time")
	private String dateTime;

	@Column(name = "is_used")
	private int isUsed;

	@Column(name = "ex_str1")
	private String exStr1;

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

	public int getWorkDetailId() {
		return workDetailId;
	}

	public void setWorkDetailId(int workDetailId) {
		this.workDetailId = workDetailId;
	}

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public String getWorkDesc() {
		return workDesc;
	}

	public void setWorkDesc(String workDesc) {
		this.workDesc = workDesc;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getInnerTaskId() {
		return innerTaskId;
	}

	public void setInnerTaskId(int innerTaskId) {
		this.innerTaskId = innerTaskId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
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

	@Override
	public String toString() {
		return "WorkDetail [workDetailId=" + workDetailId + ", workId=" + workId + ", workDesc=" + workDesc
				+ ", userId=" + userId + ", innerTaskId=" + innerTaskId + ", date=" + date + ", dateTime=" + dateTime
				+ ", isUsed=" + isUsed + ", exStr1=" + exStr1 + ", exStr2=" + exStr2 + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", date1=" + date1 + ", date2=" + date2 + "]";
	}

}
