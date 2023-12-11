package com.br.JunitMockito.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.JunitMockito.dtos.UserDto;
import com.br.JunitMockito.model.UserModel;
import com.br.JunitMockito.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<UserModel>> getAll() {
		
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
	}
	
	@GetMapping("/userId")
	public ResponseEntity<UserModel> findById(@RequestParam(name = "id")UUID id) {
		
		return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<UserModel> createuser(@RequestBody UserDto userDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userDto));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<UserModel> delete(@RequestParam(name = "id") UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.delete(id));
	}
	
	@PutMapping("/update")
	public ResponseEntity<UserModel> update(@RequestParam (name = "id") UUID id, @RequestBody UserDto user) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.update(user,id));
	}
}
