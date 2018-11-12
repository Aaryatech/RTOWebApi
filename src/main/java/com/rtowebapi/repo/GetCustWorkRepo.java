package com.rtowebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rtowebapi.model.GetCustWork;

public interface GetCustWorkRepo extends JpaRepository<GetCustWork, Integer>{
	
	@Query(value = " SELECT t_work.* , m_cust.cust_name,m_cust.cust_mobile,m_cust.cust_email,m_cust.add_pincode,m_work_type.work_type_name " + 
			"	FROM t_work,m_cust,m_work_type " + 
			"	WHERE t_work.cust_id=m_cust.cust_id AND t_work.work_type_id=m_work_type.work_type_id AND " + 
			"	t_work.ex_str1=:userId AND t_work.status=:status " + 
			"	", nativeQuery = true)
	List<GetCustWork> getCustWorkByUserIdAndStatus(@Param("userId") int userId, @Param("status") int status);
	
	
	@Query(value = " SELECT t_work.* , m_cust.cust_name,m_cust.cust_mobile,m_cust.cust_email,m_cust.add_pincode,m_work_type.work_type_name " + 
			"	FROM t_work,m_cust,m_work_type " + 
			"	WHERE t_work.cust_id=m_cust.cust_id AND t_work.work_type_id=m_work_type.work_type_id AND " + 
			"	t_work.ex_str1=:userId AND t_work.date1 BETWEEN :fromDate AND :toDate " + 
			"	", nativeQuery = true)
	List<GetCustWork> getCustWorkByUserIdAndDate(@Param("userId") int userId,@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	
	
	
	
	
	

}
