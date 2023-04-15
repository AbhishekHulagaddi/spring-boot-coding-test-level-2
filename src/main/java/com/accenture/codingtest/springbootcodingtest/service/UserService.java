package com.accenture.codingtest.springbootcodingtest.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.accenture.codingtest.springbootcodingtest.model.UserModel;

public interface UserService {
	
	public UserModel user (UserModel UserModel)throws Exception;
	
	public String updateUserIdempotent (UserModel UserModel)throws Exception;
	
	public String updateUser(UserModel UserModel, Map<String, Object> updates) throws Exception;
	
	public String deleteUserById (UUID id)throws Exception;
	
	public UserModel getUserById (UUID id)throws Exception;
	
	public List<UserModel>  getAllUsers ()throws Exception;

}