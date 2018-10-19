package com.rtowebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rtowebapi.model.WorkDetail;

public interface WorkDetailRepo extends JpaRepository<WorkDetail, Integer> {

	List<WorkDetail> findByWorkId(int workId);

	@Transactional
	@Modifying
	@Query("UPDATE WorkDetail SET isUsed=0  WHERE work_detail_id=:workDetailId")
	int deleteWorkDetail(@Param("workDetailId") int workDetailId);

}
