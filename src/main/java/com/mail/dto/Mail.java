package com.mail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Mail {

	private String name;
	private String email;
	private String message;
	private String phone;
}
