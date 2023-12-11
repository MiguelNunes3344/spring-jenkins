package com.br.JunitMockito.repository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.br.JunitMockito.dtos.UserDto;
import com.br.JunitMockito.exceptions.AppException;
import com.br.JunitMockito.model.UserModel;
import com.br.JunitMockito.service.UserService;


@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

	@InjectMocks
	UserService service;
	
	@Mock
	UserRepository userRepository;
	
	UserModel userModel;
	
	UserDto userDto;
	
	Optional<UserModel> optionalUserModel;
	
	List<UserModel> users;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		this.startUser();
	}
	
	@Test
	void WhenCreateReturnAnInstanceOfUserModel() {
		
		when(userRepository.save(Mockito.any(UserModel.class))).thenReturn(userModel);
		UserModel user = service.create(userDto);
		Assertions.assertEquals(UserModel.class, user.getClass());
		Assertions.assertEquals(userDto.login(), user.getLogin());
		Assertions.assertEquals(userDto.password(), user.getPassword());
		Assertions.assertEquals(userDto.email(), user.getEmail());
		verify(userRepository).save((Mockito.any(UserModel.class)));
		
	}
	@Test
	@DisplayName("When get an UserById return UserModel")
	void UserById() {
		when(userRepository.findById(UUID.fromString("e1d7d27a-c28c-408d-ae80-9ff8873f2d64"))).thenReturn(optionalUserModel);
		UserModel user = service.findById(UUID.fromString("e1d7d27a-c28c-408d-ae80-9ff8873f2d64"));
		Assertions.assertEquals(UserModel.class,user.getClass());
	}
	@Test
	@DisplayName("When not found a UserById throw Exception")
	void UserByIdFail() {
		when(userRepository.findById(UUID.fromString("e1d7d27a-c28c-408d-ae80-9ff8873f2d64"))).thenReturn(null);
		
		Exception thrown = Assertions.assertThrows(AppException.class, ()->{
			service.findById(UUID.fromString("e1d7d27a-c28c-408d-ae80-9ff8873f2d63"));
		});
		Assertions.assertEquals("User not found", thrown.getMessage());
	}
	
	
	
	@Test
	@DisplayName("When send data should return a UserModel of User Updated")
	void update() {		
		when(userRepository.findById(Mockito.any(UUID.class))).thenReturn(optionalUserModel);
		when(userRepository.save(Mockito.any(UserModel.class))).thenReturn(userModel);
		UserModel user =service.update(userDto, UUID.fromString("e1d7d27a-c28c-408d-ae80-9ff8873f2d64"));
		Assertions.assertEquals(UserModel.class,user.getClass());
	}
	@Test
	@DisplayName("When not found a user to update throw a exception")
	void updateFail() {		
		when(userRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.empty());
		when(userRepository.save(Mockito.any(UserModel.class))).thenReturn(null);
		Exception thrown = Assertions.assertThrows(AppException.class, () -> {
			service.update(userDto, UUID.fromString("e1d7d27a-c28c-408d-ae80-9ff8873f2d64"));
		});
		
		Assertions.assertEquals("User not found to Update",thrown.getMessage());
		verify(userRepository).findById(Mockito.any(UUID.class));
		verifyNoMoreInteractions(userRepository);
	}
	
	
	
	@Test
	void delete() {		
		when(userRepository.findById(Mockito.any(UUID.class))).thenReturn(optionalUserModel);
		UserModel user =service.delete(UUID.fromString("e1d7d27a-c28c-408d-ae80-9ff8873f2d64"));
		Assertions.assertEquals(UserModel.class, user.getClass());
		verify(userRepository).deleteById(Mockito.any(UUID.class));
	}
	@Test
	void deleteFail() {		
		when(userRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.empty());
		Exception thrown =Assertions.assertThrows(AppException.class, () -> {
			service.delete(UUID.fromString("e1d7d27a-c28c-408d-ae80-9ff8873f2d64"));
		});
		Assertions.assertEquals("User not found to delete", thrown.getMessage());
		
	}
	
	@Test
	void getAll() {		
		when(userRepository.findAll()).thenReturn(users);
		List<UserModel> usersList =service.getAll();
		Assertions.assertEquals(UserModel.class, usersList.get(0).getClass());
		Assertions.assertEquals(ArrayList.class, usersList.getClass());
		verify(userRepository).findAll();
		
	}
	private void startUser() {
		users = new ArrayList<UserModel>();
		
		userModel = new UserModel(UUID.fromString("e1d7d27a-c28c-408d-ae80-9ff8873f2d64"),"username","password","email");
		userDto = new UserDto("username","password","email");
		optionalUserModel = Optional.of(new UserModel(UUID.randomUUID(),"usernameOptional","passwordOptional","emailOptional"));
		users.add(userModel);
	}
	
}
