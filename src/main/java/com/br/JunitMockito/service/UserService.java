package com.br.JunitMockito.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.JunitMockito.dtos.UserDto;
import com.br.JunitMockito.exceptions.AppException;
import com.br.JunitMockito.model.UserModel;
import com.br.JunitMockito.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	UserRepository userRepository;
	
	public List<UserModel> getAll() {
		return userRepository.findAll();
	}
	
	public UserModel create(UserDto userDto) {
		var userModel = new UserModel();
		BeanUtils.copyProperties(userDto, userModel);
		return userRepository.save(userModel);
	}
	
	public UserModel findById(UUID id) {
		return userRepository.findById(id).orElseThrow( () -> new AppException("User not found"));
		
	}
	public UserModel delete(UUID id) {
		UserModel userModel = userRepository.findById(id).orElseThrow( () -> new AppException("User not found to delete"));
		userRepository.deleteById(id);;
		return userModel;
	}
	
	
	public UserModel update(UserDto user, UUID id) {
		UserModel userModel = userRepository.findById(id).orElseThrow( () -> new AppException("User not found to Update"));
		BeanUtils.copyProperties(user, userModel);
		return userRepository.save(userModel);
	}
}
