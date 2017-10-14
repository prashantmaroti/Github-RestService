package com.stackroute.gitapp.Github.Services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stackroute.gitapp.Github.Domain.UserModel;


public interface GitService {
	
	public @ResponseBody UserModel addUser(@RequestBody UserModel user);
	
	public @ResponseBody UserModel getUserbyId(String id);
	
	public @ResponseBody void updateUserbyId(String id,String name);	
	
	public @ResponseBody Iterable<UserModel> allUser();
	
	public @ResponseBody void DeletebyId(String id);

}
