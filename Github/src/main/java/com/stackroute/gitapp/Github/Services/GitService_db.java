package com.stackroute.gitapp.Github.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stackroute.gitapp.Github.Domain.UserModel;
import com.stackroute.gitapp.Github.Repository.UserDetails;


@Service
public class GitService_db implements GitService {

	@Autowired
	private UserDetails userDetails;
		
	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public UserModel addUser(@RequestBody UserModel user){
		userDetails.save(user);	
		return user;
	}
	
	public UserModel getUserbyId(String id){
		return userDetails.findOne(id);
	}

	public Iterable<UserModel> allUser(){
		return userDetails.findAll();
	}
	
	public void updateUserbyId(String id, String name) {
		UserModel user = userDetails.findOne(id);
		user.setName(name);
		userDetails.save(user);
	}
	

	public void DeletebyId(String id) {
		userDetails.delete(id);
	}
}
