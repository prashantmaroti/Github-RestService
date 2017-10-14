package com.stackroute.gitapp.Github.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.gitapp.Github.Domain.UserModel;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserDetails extends CrudRepository<UserModel, String> {
	
}

