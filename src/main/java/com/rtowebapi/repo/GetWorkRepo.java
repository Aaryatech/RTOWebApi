package com.rtowebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rtowebapi.model.GetWork;

public interface GetWorkRepo extends JpaRepository<GetWork, Integer> {

	@Query(value = "SELECT w.*,c.cust_name,c.cust_mobile ,t.work_type_name FROM t_work w ,m_cust c,m_work_type t WHERE "
			+ "w.status=:status AND w.is_used=1 AND w.cust_id=c.cust_id AND t.work_type_id=w.work_type_id", nativeQuery = true)
	List<GetWork> getWorkByStatus(@Param("status") int status);

	@Query(value = "SELECT w.*,c.cust_name,c.cust_mobile ,t.work_type_name FROM t_work w ,m_cust c,m_work_type t WHERE "
			+ "w.work_id=:workId AND w.is_used=1 AND w.cust_id=c.cust_id AND t.work_type_id=w.work_type_id", nativeQuery = true)
	GetWork getWorkByWorkId(@Param("workId") int workId);

}
