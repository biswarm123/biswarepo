/**
 * 
 */
package com.example.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

/**
 * @author biswa
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, String>{
	
	Optional<User> findByEmailAndIsActive(String email, Boolean isActive);

}
