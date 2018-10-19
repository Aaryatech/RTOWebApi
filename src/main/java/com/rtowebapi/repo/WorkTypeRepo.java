package com.rtowebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rtowebapi.model.WorkType;

public interface WorkTypeRepo extends JpaRepository<WorkType, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE WorkType SET isUsed=0  WHERE work_type_id=:workTypeId")
	int deleteWorkType(@Param("workTypeId") int workTypeId);

	WorkType findByWorkTypeId(int workTypeId);

	List<WorkType> findByIsUsed(int i);

	WorkType findByWorkTypeIdAndIsUsed(int workTypeId, int i);

	List<WorkType> findByIsUsedOrderByWorkTypeIdDesc(int i);

}
