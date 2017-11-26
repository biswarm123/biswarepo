package com.example.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UserModel;
import com.example.service.UserService;
import com.example.util.ApiResponse;

/**
 * @author biswa
 *
 */
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(path="createuser")
	public ApiResponse createUser(@RequestBody UserModel user) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate localDate = LocalDate.parse(user.getBirthDate(), formatter);
		String userId = userService.createUser(user);
		if(userId.equals("userexist")) {
			return new ApiResponse("User Already Exist", user.getfName()+""+localDate, HttpStatus.OK, true);
		}else {
			return new ApiResponse("User Created Successfully", userId, HttpStatus.OK, true);
		}
		
		
	}
	
	@PutMapping(path="updateuser")
	public String updateUser(@RequestParam("userid") String userid,@RequestParam("pincode") Integer pincode, @RequestParam("birthdate") String birthdate) {
		String ret = userService.updateUser(userid, pincode, birthdate);
		
		return ret;
	}	
	@DeleteMapping(path="deleteuser")
	public String deleteUser(@RequestParam("userid") String userid) {
		Boolean ret = userService.deleteUser(userid);
		if(ret==false) {
			return "User Not Found";
		}else {
			return "User Deactivate Successfully";
		}
		
		
	}
}
