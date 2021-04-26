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
        return userRepository.findAll();
    }

    //login
    public Map<String, Object> validateUser(Login login) {
        User user = userRepository.findByUserId(login.getUserId());
        Map<String, Object> validation = new HashMap<>();

        if (user != null) {
            if (user.getPassword().equals(login.getPassword())) {
                validation.put("userId", user.getUserId());
                validation.put("name", user.getFirstName() + " " + user.getLastName());
                validation.put("contactNo", user.getContactNo());
                validation.put("email", user.getEmail());
                validation.put("isAdmin", user.getIsAdmin());
                validation.put("isAuthorized", user.getIsAuthorized());
            }
        }
        return validation;
    }

    // registration
    public Map<String, Object> validateUserReg(RegistrationDto regUser) {
        User idUser = userRepository.findByUserId(regUser.getUserId());
        User emailUser = userRepository.findByEmail(regUser.getEmail());
        User contactUser = userRepository.findByContactNo(regUser.getContactNo());

        Map<String, Object> validation = new HashMap<>();
        Map<String, String> errors = new HashMap<>();

        boolean isValid = true;
        if (idUser != null) {
            errors.put("userId", "User Id already exists");
            isValid = false;
        }
        if (emailUser != null) {
            errors.put("email", "Email already exists");
            isValid = false;
        }
        if (contactUser != null) {
            errors.put("contactNo", "Contact already exists");
            isValid = false;
        }

        validation.put("isValid", isValid);
        validation.put("errors", errors);

        if (idUser == null && emailUser == null && contactUser == null) {
            User user = new User(0, regUser.getUserId(), regUser.getFirstName(),
                    regUser.getLastName(), regUser.getDob(), regUser.getGender(),
                    regUser.getContactNo(), regUser.getEmail(), regUser.getPassword(),
                    false, 0, null, regUser.getAns1(),
                    regUser.getAns2(), regUser.getAns3());

            userRepository.save(user);
        }
        return validation;
    }

    //forgot password  authentication (userId, ans1,2,3)
    public Map<String, Object> validatePassword(String userId, String ans1, String ans2, String ans3) {
        User user = userRepository.findByUserIdAndAns(userId, ans1, ans2, ans3);
        Map<String, Object> validation = new HashMap<>();
        if (user != null) {
            validation.put("userId", user.getUserId());
        } else {
            validation.put("userId", null);
        }
        return validation;
    }


    //forgot UserID authentication (contactNo, ans1,2,3)
    public Map<String, Object> validateUserId(String contactNo, String ans1, String ans2, String ans3) {

        User user = userRepository.findByContactNoAndAns(contactNo, ans1, ans2, ans3);
        Map<String, Object> validation = new HashMap<>();
        if (user != null) {
            validation.put("userId", user.getUserId());
        } else {
            validation.put("userId", null);
        }
        return validation;
    }


    //update password using userId
    public void updatePassword(String userId, String password) {
        User user = userRepository.findByUserId(userId);
        if (user != null) {
            user.setPassword(password);
            userRepository.save(user);
        }
    }

    //find by authorization value where value =0 means not authorized;
    public List<User> getAllUserByAuthStatus() {
        return userRepository.findByisAuthstatus();
    }

    //change auth status(reject=2/accept=1/null=0)
    public Map<String, Boolean> changeAuthStatus(String userId, int isAuthorized) {
        User user = userRepository.findByUserId(userId);
        Map<String, Boolean> authResponse = new HashMap<>();
        if (user != null) {
            user.setIsAuthorized(isAuthorized);
            userRepository.save(user);
            authResponse.put("updated", true);
        } else {
            authResponse.put("updated", false);
        }
        return authResponse;
    }
}
