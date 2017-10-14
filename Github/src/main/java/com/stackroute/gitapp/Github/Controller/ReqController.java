package com.stackroute.gitapp.Github.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.stackroute.gitapp.Github.Domain.UserModel;
import com.stackroute.gitapp.Github.Services.GitService;
import com.stackroute.gitapp.Github.Services.GitService_db;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/home/user")
@Api(value="github" ,description="operations perfdlsflsdfjlsdjfsdjflds")
public class ReqController {
	

	@Autowired
	private GitService_db service;
	

//    @ApiOperation(value = "View a list of available products",response = Iterable.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
//    }
//    )
    

	@PostMapping(value="/add",produces = "application/json")
    @ApiOperation(value = "Add a user",response=String.class)

	public ResponseEntity<String> add_user(@RequestBody UserModel user){
		service.addUser(user);
		 return new ResponseEntity<>("User saved successfully",HttpStatus.OK);
	}
	
	@GetMapping(value="/list",produces = "application/json")
	@ApiOperation(value = "View a list of available Users", response = Iterable.class)	
	public @ResponseBody Iterable<UserModel> getAllUser(){
		return service.allUser();
	}
	
	@ApiOperation(value = "Search a User with an ID",response = UserModel.class)
	@GetMapping(value="/userbyId/{userid}",produces = "application/json")
	public ResponseEntity<UserModel> getUserby_Id(@PathVariable("userid") String id){
		return new ResponseEntity<UserModel>(service.getUserbyId(id),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update a user")
	@PutMapping(value="/updatename/{userid}", produces = "application/json")
	public ResponseEntity<String> updateName(@PathVariable("userid") String id, @RequestParam("name") String name){
		service.updateUserbyId(id,name);
		return new ResponseEntity<>("User Updated Successfully",HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete a user")
	@DeleteMapping(value="/delete/{userid}", produces = "application/json")
	public ResponseEntity<String> DeleteUser(@PathVariable("userid") String id){
		service.DeletebyId(id);
		return new ResponseEntity<>("User with "+id+" deleted successfully",HttpStatus.OK);
		
	}

}
