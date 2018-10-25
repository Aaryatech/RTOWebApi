package com.rtowebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rtowebapi.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE User SET isUsed=0  WHERE user_id=:userId")
	int deleteUser(@Param("userId") int userId);

	List<User> findByIsUsed(int i);

	User findByUserId(int userId);

	User findByUserIdAndIsUsed(int userId, int i);

	List<User> findByIsUsedOrderByUserIdDesc(int i);

	User findByUserMobileAndUserPasswordAndIsUsed(String userMobile, String userPassword, int i);

	User findByUserMobileAndIsUsed(String userMobile, int i);

}
