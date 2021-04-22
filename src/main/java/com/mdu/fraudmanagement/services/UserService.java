package com.mdu.fraudmanagement.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdu.fraudmanagement.dto.Login;
import com.mdu.fraudmanagement.dto.RegistrationDto;
import com.mdu.fraudmanagement.entities.User;
import com.mdu.fraudmanagement.exceptions.UserNotFoundException;
import com.mdu.fraudmanagement.repos.UserRepository;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	

	public List<User> findAllEmp() {
		// TODO Auto-generated method stub
		 return userRepository.findAll();
	}
	
	
	
	//login
	public Map<String,Object> validateUser(Login login) {
		
		User user=	userRepository.findByUserId(login.getUserId());
		
		 Map<String,Object> validation=new HashMap<>();
		
		if(user!=null) {
			
			if(user.getPassword().equals(login.getPassword())) {
				
				validation.put("email", user.getEmail());
				validation.put("isAdmin", user.getIsAdmin());
				validation.put("isAuthorized", user.getIsAuthorized());
				
			}
		}
		
		return validation;
			
		}

	
	
	//new registration of user with email,contact,userId validation
		public Map<String, String> validateUserReg(RegistrationDto regUser) {
			
			User idUser=new User();
			idUser=userRepository.findByUserId(regUser.getUserId());
			
			User emailUser=new User();
			emailUser=userRepository.findByEmail(regUser.getEmail());
			
			User contactUser=new User();
			 contactUser=userRepository.findByContactNo(regUser.getContactNo());

			
			
			 Map<String,String> validation=new HashMap<>();
				
				if(idUser==null) {
					validation.put("userId","success");
					
				}else validation.put("userId","User id all ready exist");
				
				
				if(emailUser==null) {
					validation.put("email","success");
					
				}else validation.put("email","Email id all ready exist");
				
				if(contactUser==null) {
					validation.put("contactNo","success");
					
				}else validation.put("contactNo","Contact no all ready exist");
				
				if(idUser==null && emailUser==null && contactUser==null) {
					
					User user=new User(0, regUser.getUserId(),regUser.getFirstName(),regUser.getLastName(),
							regUser.getDob(), regUser.getGender(),regUser.getContactNo() ,
							regUser.getEmail(), regUser.getPassword(), false, 
							false,null,regUser.getAns1(),regUser.getAns2(),regUser.getAns3());
					
					
					userRepository.save(user);
				}
				
				
				return validation;
			
		}


		//forgot password  authentication (userId, ans1,2,3)
		public  Map<String, Object> validatePassword(String userId, String ans1, String ans2, String ans3) {
			
			User user=userRepository.findByUserIdAndAns(userId,ans1,ans2,ans3);
			Map<String,Object> validation=new HashMap<>();
			
			
			if(user!=null) {
				
				validation.put("userId", user.getUserId());
			}
			else validation.put("userId", null);
			
			
			
			return validation;
			
		}

		
		//forgot UserID authentication (contactNo, ans1,2,3)
				public  Map<String, Object> validateUserId(String contactNo, String ans1, String ans2, String ans3) {
					
					User user=userRepository.findByContactNoAndAns(contactNo,ans1,ans2,ans3);
					Map<String,Object> validation=new HashMap<>();
					
					
					if(user!=null) {
						
						validation.put("userId", user.getUserId());
					}
					else validation.put("userId", null);
					
					
					
					return validation;
					
				}
		
		

		//update password using userId
		public void updatePassword(String userId, String password) {
			
			
			User user =userRepository.findByUserId(userId);
			
			if(user!=null) {
				
				user.setPassword(password);
				
				userRepository.save(user);
			}
	
			
		}



		
	
	
		
}