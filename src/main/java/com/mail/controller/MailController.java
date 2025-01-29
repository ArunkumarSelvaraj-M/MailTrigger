package com.mail.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.dto.Mail;
import com.mail.service.MailService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MailController {

	private Map<String, String> response = new HashMap<>();

	private MailService mailService;

	public MailController(MailService mailService) {
		super();
		this.mailService = mailService;
	}
    @PostMapping("/mailSend")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Mail mail) {
    	
    	try {
			mailService.sendResetPasswordEmail(mail);
			response.put("status", "success");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block

            response.put("status", "error");
			e.printStackTrace();
		}
    	 // Merge the result map into the response
        return ResponseEntity.ok(response);
    }
}
