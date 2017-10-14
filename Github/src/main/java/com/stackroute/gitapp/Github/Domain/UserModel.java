package com.stackroute.gitapp.Github.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "github")
@Component
public class UserModel {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)	
	@ApiModelProperty(notes = "The database generated user ID")
	private String id;
	@ApiModelProperty(notes = "The database generated user name")
	private String name;
	
//	public UserModel() {
//		super();
//	}
//	public UserModel(String id, String name) {
//		super();
//		this.id = id;
//		this.name = name;
	//}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return id;
	}
	public void setUserid(String id) {
		this.id = id;
	}
	

}

