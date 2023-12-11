package com.br.JunitMockito.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ActiveProfiles;

import com.br.JunitMockito.exceptions.AppException;
import com.br.JunitMockito.exceptions.ResourceExceptionHandler;
import com.br.JunitMockito.exceptions.StandardError;


@ActiveProfiles("test")
@SpringBootTest
public class ExceptionHandlerTest {

	@InjectMocks
	ResourceExceptionHandler exception;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void exceptionHandlerTest() {
		ResponseEntity<StandardError> response= exception.userNotFound(new AppException("User not found"), new MockHttpServletRequest());
		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getBody());
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		Assertions.assertEquals(ResponseEntity.class, response.getClass());
		Assertions.assertEquals(StandardError.class, response.getBody().getClass());
		Assertions.assertEquals("User not found", response.getBody().getError());
	}
}
