package com.br.JunitMockito.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.br.JunitMockito.dtos.UserDto;
import com.br.JunitMockito.model.UserModel;
import com.br.JunitMockito.service.UserService;

@SpringBootTest
@ActiveProfiles("test")
public class ControllerTest {

	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	UserModel userModel;
	
	UserDto userDto;
	
	@Test
	void createUser() {
		when(userService.create(Mockito.any(UserDto.class))).thenReturn(userModel);
		ResponseEntity<UserModel> response = userController.createuser(userDto);
		Assertions.assertEquals(ResponseEntity.class, response.getClass());
		Assertions.assertEquals(UserModel.class, response.getBody().getClass());
	}
	
	@Test
	void update() {
		when(userService.update(Mockito.any(UserDto.class),Mockito.any(UUID.class))).thenReturn(userModel);
		ResponseEntity<UserModel> response = userController.update(userModel.getId(),userDto);
		Assertions.assertEquals(ResponseEntity.class, response.getClass());
		Assertions.assertEquals(UserModel.class, response.getBody().getClass());
		Assertions.assertEquals(userModel.getId(), response.getBody().getId());
		Assertions.assertEquals(userModel.getLogin(), response.getBody().getLogin());
		Assertions.assertEquals(userModel.getPassword(), response.getBody().getPassword());
		Assertions.assertEquals(userModel.getEmail(), response.getBody().getEmail());
	}
	@Test
	void userId() {
		when(userService.findById(Mockito.any(UUID.class))).thenReturn(userModel);
		ResponseEntity<UserModel> response = userController.findById(userModel.getId());
		Assertions.assertEquals(ResponseEntity.class, response.getClass());
		Assertions.assertEquals(userModel.getId(), response.getBody().getId());
		Assertions.assertEquals(userModel.getLogin(), response.getBody().getLogin());
		Assertions.assertEquals(userModel.getPassword(), response.getBody().getPassword());
		Assertions.assertEquals(userModel.getEmail(), response.getBody().getEmail());
	}
	
	
	@BeforeEach
	private void startUser() {
		MockitoAnnotations.openMocks(this);
		userModel = new UserModel(UUID.fromString("e1d7d27a-c28c-408d-ae80-9ff8873f2d64"),"username","password","email");
		userDto = new UserDto("username","password","email");
	}
	
}
