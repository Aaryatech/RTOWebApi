package com.rtowebapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UpdateStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int workId;

	private float workCost;

	private int status;

	private int exInt1;
	private int exInt2;

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public float getWorkCost() {
		return workCost;
	}

	public void setWorkCost(float workCost) {
		this.workCost = workCost;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "UpdateStatus [workId=" + workId + ", workCost=" + workCost + ", status=" + status + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + "]";
	}

}
