package com.mdu.fraudmanagement.repos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mdu.fraudmanagement.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
//	
//	@Query(value="SELECT email from users where email=?1",nativeQuery = true)
//  public String findEmailAvailability(String email);

	
//	@Query(value="SELECT user_id from users where user_id=?1",nativeQuery = true)
//	public String findUserIdAvailability(String userId);
	


	public User findByEmail(String email);
	
	public User findByUserId(String userId);

	public User findByContactNo(String contactNo);
	
	
	@Query(value="SELECT * from users u WHERE u.user_id=?1 AND u.ans1=?2 AND u.ans2=?3 AND u.ans3=?4 ",nativeQuery = true)
	public User findByUserIdAndAns(String userId, String ans1, String ans2, String ans3);

	@Query(value="SELECT * from users u WHERE u.contact_no=?1 AND u.ans1=?2 AND u.ans2=?3 AND u.ans3=?4 ",nativeQuery = true)
	public User findByContactNoAndAns(String contactNo, String ans1, String ans2, String ans3);

//	@Modifying
//	@Query(value="UPDATE users u SET u.password=?2  WHERE u.user_id=?1 ",nativeQuery = true)
//	public void upadatePasswordByUserId(@Param("user_id") String userId, @Param("password")   String password);
	

	
//	@Query(value="INSERT INTO USERS (id, firstName, lastName,dob,gender,contactNo,email,password,isAdmin,isAuthorized) VALUES (?,?,?,?,?,?,?,?,?,?)",nativeQuery = true)
//	public void registerUser(Users user);
//
}
