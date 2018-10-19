package com.rtowebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rtowebapi.model.Right;

public interface RightRepo extends JpaRepository<Right, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Right SET isUsed=0  WHERE right_id=:rightId")
	int deleteRight(@Param("rightId") int rightId);

	Right findByRightId(int rightId);

	List<Right> findByIsUsed(int i);

	Right findByRightIdAndIsUsed(int rightId, int i);

	List<Right> findByIsUsedOrderByRightIdDesc(int i);

}
