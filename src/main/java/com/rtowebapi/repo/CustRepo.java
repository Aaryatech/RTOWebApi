package com.rtowebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rtowebapi.model.Cust;
 
public interface CustRepo extends JpaRepository<Cust, Integer> {

	Cust findByCustId(int custId);

	List<Cust> findByIsUsed(int i);

	@Transactional
	@Modifying
	@Query("UPDATE Cust SET isUsed=0  WHERE cust_id=:custId")
	int deleteCust(@Param("custId") int custId);

	Cust findByCustIdAndIsUsed(int custId, int i);

	List<Cust> findByIsUsedOrderByCustIdDesc(int i);

	Cust findByCustMobileAndCustPasswordAndIsUsed(String custMobile, String custPassword, int i);

	Cust findByCustMobileAndIsUsed(String custMobile, int i);
	
	
	//Sachin 2 Nov
	@Transactional
	@Modifying
	@Query("UPDATE Cust SET exStr1=:token   WHERE custId=:custId")
	int updateToken(@Param("custId") int custId,@Param("token") String token);
	
	//Sachin 2 Nov
	@Transactional
	@Modifying
	@Query("UPDATE Cust SET custPassword=:newPass  WHERE custId=:custId")
	int changePass(@Param("custId") int custId, @Param("newPass") String newPass);

}
