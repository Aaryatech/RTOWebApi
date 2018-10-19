package com.rtowebapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rtowebapi.model.UpdateStatus;

public interface UpdateStatusRepo extends JpaRepository<UpdateStatus, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Work SET status=:status,workCost=:workCost WHERE workId=:workId")
	int updateWorkHeaderStatusAndCost(@Param("status") int status, @Param("workId") int workId,
			@Param("workCost") float workCost);

}
