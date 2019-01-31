package com.rtowebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rtowebapi.model.GetWork;

public interface GetWorkRepo extends JpaRepository<GetWork, Integer> {

	@Query(value = "SELECT w.*,c.cust_name,c.cust_mobile ,t.work_type_name FROM t_work w ,m_cust c,m_work_type t WHERE "
			+ "w.status=:status AND w.is_used=1 AND w.cust_id=c.cust_id AND t.work_type_id=w.work_type_id ORDER BY w.work_id DESC,w.date1", nativeQuery = true)
	List<GetWork> getWorkByStatus(@Param("status") int status);

	@Query(value = "SELECT w.*,c.cust_name,c.cust_mobile ,t.work_type_name FROM t_work w ,m_cust c,m_work_type t WHERE "
			+ "w.work_id=:workId AND w.is_used=1 AND w.cust_id=c.cust_id AND t.work_type_id=w.work_type_id ORDER BY w.date1 DESC", nativeQuery = true)
	GetWork getWorkByWorkId(@Param("workId") int workId);

	@Query(value = "SELECT w.*,c.cust_name,c.cust_mobile ,t.work_type_name FROM t_work w ,m_cust c,m_work_type t WHERE "
			+ " w.is_used=1 AND w.cust_id=c.cust_id AND t.work_type_id=w.work_type_id AND w.date1 BETWEEN :fromDate AND :toDate ORDER BY w.date1 DESC", nativeQuery = true)
	List<GetWork> getWorkBetweenDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT w.*,c.cust_name,c.cust_mobile ,t.work_type_name FROM t_work w ,m_cust c,m_work_type t WHERE "
			+ " w.is_used=1 AND w.cust_id=c.cust_id AND t.work_type_id=w.work_type_id AND w.date1 BETWEEN :fromDate AND :toDate AND w.status=:status ORDER BY w.date1 DESC", nativeQuery = true)
	List<GetWork> getWorkBetDateAndStatus(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("status") int status);

	@Query(value = "SELECT w.*,c.cust_name,c.cust_mobile ,t.work_type_name FROM t_work w ,m_cust c,m_work_type t WHERE "
			+ " w.is_used=1 AND w.cust_id=c.cust_id AND t.work_type_id=w.work_type_id AND w.date1 BETWEEN :fromDate AND :toDate AND w.Work_type_id=:workTypeId ORDER BY w.date1 DESC", nativeQuery = true)
	List<GetWork> getWorkBetDateAndWorkTypeId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("workTypeId") int workTypeId);
	
	/*
	SELECT t_work.* , m_cust.cust_name,m_cust.cust_mobile,m_work_type.work_type_name 
	FROM t_work,m_cust,m_work_type
	WHERE t_work.cust_id=: custId AND t_work.work_type_id=m_work_type.work_type_id AND
	t_work.cust_id=m_cust.cust_id
	*/
	
	@Query(value = "SELECT t_work.* , m_cust.cust_name,m_cust.cust_mobile,m_work_type.work_type_name \n" + 
			"	FROM t_work,m_cust,m_work_type\n" + 
			"	WHERE t_work.cust_id=:custId AND t_work.work_type_id=m_work_type.work_type_id AND\n" + 
			"	t_work.cust_id=m_cust.cust_id ORDER BY t_work.date1 DESC\n" + 
			"	", nativeQuery = true)
	List<GetWork> getWorkByCustId(@Param("custId") int custId);
	
	@Query(value = "SELECT w.*,c.cust_name,c.cust_mobile ,t.work_type_name FROM t_work w ,m_cust c,m_work_type t WHERE \n" + 
			"	 w.is_used=:i AND w.cust_id=c.cust_id AND t.work_type_id=w.work_type_id ORDER BY w.work_id DESC,w.date1", nativeQuery = true)
	List<GetWork> findByIsUsed(@Param("i") int i);
	
	 
	
}
