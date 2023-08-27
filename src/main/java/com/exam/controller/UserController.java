package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	//creating User
	@PostMapping("/")
	public User craeteUser(@RequestBody User user ) throws Exception {
		
		//set containing userRoles
		Set<UserRole>setUserRole=new HashSet<UserRole>()
;
		Role role=new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		UserRole userRole=new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		setUserRole.add(userRole);
		
		
		return this.userService.createUser(user, setUserRole);
		
	}
	
	//get user
	@GetMapping("/{userName}")
	public User getUser(@PathVariable("userName") String userName) {
		
		return this.userService.getUser(userName);
		
	}
	
	//delete user by id
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id")Long id) {
		this.userService.deleteUser(id);
		
	}
}
