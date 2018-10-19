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

	@Override
	public String toString() {
		return "UpdateStatus [workId=" + workId + ", workCost=" + workCost + ", status=" + status + "]";
	}

}
