package com.br.JunitMockito.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class StandardError {

	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String path;
}
