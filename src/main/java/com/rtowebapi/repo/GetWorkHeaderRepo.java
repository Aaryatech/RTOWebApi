package com.rtowebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rtowebapi.model.GetWorkHeader;

public interface GetWorkHeaderRepo extends JpaRepository<GetWorkHeader, Integer> {

	@Query(value = "SELECT w.work_id,w.work_type_id,w.cust_id,w.vehical_no,w.date1,sum(w.ex_int1) AS ex_int1,sum(w.ex_int2) "
			+ "AS ex_int2 ,c.cust_name,c.cust_mobile ,t.work_type_name FROM t_work w ,m_cust c,m_work_type t WHERE  w.is_used=1 "
			+ "AND w.cust_id=c.cust_id AND t.work_type_id=w.work_type_id AND w.date1 BETWEEN :fromDate AND :toDate"
			+ " AND w.ex_str1=:userId group by w.ex_str1", nativeQuery = true)
	List<GetWorkHeader> getWorkBetDateAndUserId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("userId") int userId);
	
	@Query(value = "SELECT w.work_id,w.work_type_id,w.cust_id,w.vehical_no,w.date1,sum(w.ex_int1) AS ex_int1,sum(w.ex_int2) "
			+ "AS ex_int2 ,c.cust_name,c.cust_mobile ,t.work_type_name FROM t_work w ,m_cust c,m_work_type t WHERE  w.is_used=1 "
			+ "AND w.cust_id=c.cust_id AND t.work_type_id=w.work_type_id AND w.date1 BETWEEN :fromDate AND :toDate"
			+ "  group by w.ex_str1", nativeQuery = true)
	List<GetWorkHeader> getWorkBetDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
