package com.rtowebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rtowebapi.model.Work;

public interface WorkRepo extends JpaRepository<Work, Integer> {

	Work findByWorkId(int workId);

	@Transactional
	@Modifying
	@Query("UPDATE Work SET isUsed=0  WHERE work_id=:workId")
	int deleteWork(@Param("workId") int workId);

	Work findByStatus(int status);

	@Transactional
	@Modifying
	@Query("UPDATE Work SET status=:status WHERE workId IN(:workId)")
	int updateWorkStatus(@Param("status") int status, @Param("workId") List<Integer> workId);

}
