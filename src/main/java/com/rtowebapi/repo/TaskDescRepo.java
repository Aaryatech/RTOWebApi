package com.rtowebapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtowebapi.model.TaskDesc;

public interface TaskDescRepo extends JpaRepository<TaskDesc, Integer> {

	TaskDesc findByInnerTaskId(int innerTaskId);

}
