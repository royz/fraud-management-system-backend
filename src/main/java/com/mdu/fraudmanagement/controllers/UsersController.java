package com.mdu.fraudmanagement.controllers;

import java.util.Map;
import java.util.Optional;
import javax.jws.soap.SOAPBinding.Use;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdu.fraudmanagement.dto.Login;
import com.mdu.fraudmanagement.dto.RegistrationDto;
import com.mdu.fraudmanagement.entities.User;
import com.mdu.fraudmanagement.services.UserService;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UserService userService;

    // User login (Complete only have change token)
    @PostMapping("/user/login")
    public ResponseEntity<Map<String, Object>> loginUser(@Valid @RequestBody Login login) {
        if (!userService.validateUser(login).isEmpty()) {
            return new ResponseEntity<>(userService.validateUser(login), HttpStatus.OK);
        }
        return new ResponseEntity<>(userService.validateUser(login), HttpStatus.BAD_REQUEST);
    }


    // new users registration with (userId,contactNo,email) validation + security
    // ans
    @PostMapping("/user/register")
    private ResponseEntity<Map<String, Object>> registerUser(@Valid @RequestBody RegistrationDto regUser) {
        return new ResponseEntity<>(userService.validateUserReg(regUser), HttpStatus.OK);
    }

    // forgot password authentication (userId, ans1,2,3)
    @PostMapping("/user/forgot-password")
    private ResponseEntity<Map<String, Object>> forgotPassword(@RequestParam(name = "userId") String userId,
                                                               @RequestParam(name = "ans1") String ans1,
                                                               @RequestParam(name = "ans2") String ans2,
                                                               @RequestParam(name = "ans3") String ans3) {

        if (!userService.validatePassword(userId, ans1, ans2, ans3).isEmpty()) {
            return new ResponseEntity<>(userService.validatePassword(userId, ans1, ans2, ans3), HttpStatus.OK);
        }
        return new ResponseEntity<>(userService.validatePassword(userId, ans1, ans2, ans3), HttpStatus.BAD_REQUEST);
    }

    // forgot userId authentication (contactNo, ans1,2,3)
    @PostMapping("/user/forgot-userid")
    private ResponseEntity<Map<String, Object>> forgotUserId(@RequestParam(name = "contactNo") String contactNo,
                                                             @RequestParam(name = "ans1") String ans1,
                                                             @RequestParam(name = "ans2") String ans2,
                                                             @RequestParam(name = "ans3") String ans3) {
        if (!userService.validateUserId(contactNo, ans1, ans2, ans3).isEmpty()) {
            return new ResponseEntity<>(userService.validateUserId(contactNo, ans1, ans2, ans3), HttpStatus.OK);
        }
        return new ResponseEntity<>(userService.validateUserId(contactNo, ans1, ans2, ans3), HttpStatus.BAD_REQUEST);
    }

    // update password using userId
    @PutMapping("/user/update-password")
    private ResponseEntity<?> updatePasswordByUserId(@RequestParam(name = "userId") String userId,
                                                     @RequestParam(name = "password") String password) {
        userService.updatePassword(userId, password);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //isAuthorized status check
    @GetMapping("/user/not-authorized")
    private ResponseEntity<List<User>> getAuthorizedStatus() {
        List<User> user = userService.getAllUserByAuthStatus();
        if (!user.isEmpty()) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    //isAuthorized status change(0 means nothing ,1=approved,2=reject)
    @PostMapping("/changeAuthStatus")
    private ResponseEntity<Map<String, Boolean>> changeAuthStatus(
            @RequestParam(name = "userId") String userId,
            @RequestParam(name = "isAuthorized") int isAuthorized
    ) {
        return new ResponseEntity<>(userService.changeAuthStatus(userId, isAuthorized), HttpStatus.ACCEPTED);
    }
}
