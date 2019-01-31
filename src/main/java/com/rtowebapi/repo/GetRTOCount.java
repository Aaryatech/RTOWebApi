package com.rtowebapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rtowebapi.model.GetCount;

public interface GetRTOCount extends JpaRepository<GetCount, Integer>{

	
	@Query(value = "SELECT \n"
            + "coalesce (( SELECT COUNT(*)  FROM t_work w,m_cust c,m_work_type t WHERE w.status=1 and w.is_used=1 AND w.cust_id=c.cust_id AND t.work_type_id=w.work_type_id ORDER BY w.work_id DESC,w.date1),0) AS no_document,"
            + "coalesce (( SELECT COUNT(*)  FROM t_work w,m_cust c,m_work_type t WHERE w.status=2 and w.is_used=1 AND w.cust_id=c.cust_id AND t.work_type_id=w.work_type_id ORDER BY w.work_id DESC,w.date1),0) AS no_cost,"
            + "coalesce (( SELECT COUNT(*)  FROM t_work w,m_cust c,m_work_type t WHERE w.status=3 and w.is_used=1 AND w.cust_id=c.cust_id AND t.work_type_id=w.work_type_id ORDER BY w.work_id DESC,w.date1),0) AS no_payment,"
            + "coalesce (( SELECT COUNT(*)  FROM t_work w,m_cust c,m_work_type t WHERE w.status=4 and w.is_used=1 AND w.cust_id=c.cust_id AND t.work_type_id=w.work_type_id ORDER BY w.work_id DESC,w.date1),0) AS no_allocate,"
            + "coalesce (( SELECT COUNT(*)  FROM t_work w,m_cust c,m_work_type t WHERE w.status=5 and w.is_used=1 AND w.cust_id=c.cust_id AND t.work_type_id=w.work_type_id ORDER BY w.work_id DESC,w.date1),0) AS no_office,"
            + "coalesce (( SELECT COUNT(*)  FROM t_work w,m_cust c,m_work_type t WHERE w.status=6 and w.is_used=1 AND w.cust_id=c.cust_id AND t.work_type_id=w.work_type_id ORDER BY w.work_id DESC,w.date1),0) AS no_rto,"
            + "coalesce (( SELECT COUNT(*)  FROM t_work w,m_cust c,m_work_type t WHERE w.status=7 and w.is_used=1 AND w.cust_id=c.cust_id AND t.work_type_id=w.work_type_id ORDER BY w.work_id DESC,w.date1),0) AS no_handover,"
            + "coalesce (( SELECT COUNT(*)  FROM t_work w  WHERE w.is_used=1 ),0) AS no_total_handover"
         , nativeQuery = true)
			GetCount getDashboardCount();
}
