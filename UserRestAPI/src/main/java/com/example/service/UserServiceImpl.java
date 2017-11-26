/**
 * 
 */
package com.example.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.entity.UserModel;
import com.example.repo.UserRepository;

/**
 * @author biswa
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public String createUser(UserModel user) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate localDate = LocalDate.parse(user.getBirthDate(), formatter);
		User usr = new User(user.getfName()+""+localDate, user.getfName(), user.getlName(), user.getEmail(), user.getPinCode(), localDate, user.getIsActive());
		Optional<User> objPresent = userRepo.findByEmailAndIsActive(user.getEmail(), true);
		if(objPresent.isPresent()) {
			return objPresent.get().getId();
		}else {
			userRepo.save(usr);
			return usr.getId();
		}
	}

	@Override
	public String updateUser(String userId, Integer pincode, String birthDate) {
		User user = userRepo.findOne(userId);
		if(user != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			LocalDate localDate = LocalDate.parse(birthDate, formatter);
			user.setBirthDate(localDate);
			user.setPinCode(pincode);
			userRepo.save(user);
			return "User Updated Successfully";
		}else {
			return "No User Found";
		}
	}

	@Override
	public boolean deleteUser(String userId) {
		User user = userRepo.findOne(userId);
		boolean ret = false;
		if(user != null) {
			user.setIsActive(false);
			userRepo.save(user);
			return true;
		}
		return ret;
	}

}
