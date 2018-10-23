package com.rtowebapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_task_desc")
public class TaskDesc {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int taskId;
	private int innerTaskId;
	private String taskDesc;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getInnerTaskId() {
		return innerTaskId;
	}

	public void setInnerTaskId(int innerTaskId) {
		this.innerTaskId = innerTaskId;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	@Override
	public String toString() {
		return "TaskDesc [taskId=" + taskId + ", innerTaskId=" + innerTaskId + ", taskDesc=" + taskDesc + "]";
	}

}
