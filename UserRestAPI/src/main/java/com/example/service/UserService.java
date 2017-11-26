/**
 * 
 */
package com.example.service;

import com.example.entity.UserModel;

/**
 * @author biswa
 *
 */
public interface UserService {
	
	String createUser(UserModel user);
	String updateUser(String userId, Integer pincode, String birthDate);
	boolean deleteUser(String userId);// Deactivate / Dont delete the record

}
