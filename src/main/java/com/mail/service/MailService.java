package com.mail.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mail.dto.Mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

	    private JavaMailSender mailSender;

	    public MailService(JavaMailSender mailSender) {
			super();
			this.mailSender = mailSender;
		}

		public void sendResetPasswordEmail(Mail mail) throws MessagingException {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);

	        helper.setTo("arunkumarselvaraj.m@gmail.com");
	        helper.setSubject("Reset Your Password");

	        String htmlContent = "<!DOCTYPE html>"
	                + "<html lang=\"en\">"
	                + "<head>"
	                + "<meta charset=\"UTF-8\">"
	                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
	                + "<style>"
	                + "body {"
	                + "font-family: Arial, sans-serif;"
	                + "background-color: #f9f9f9;"
	                + "margin: 0;"
	                + "padding: 0;"
	                + "}"
	                + ".email-container {"
	                + "max-width: 600px;"
	                + "margin: 20px auto;"
	                + "background-color: #ffffff;"
	                + "border: 1px solid #dddddd;"
	                + "border-radius: 8px;"
	                + "box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);"
	                + "overflow: hidden;"
	                + "}"
	                + ".email-header {"
	                + "background-color: #007BFF;"
	                + "color: #ffffff;"
	                + "text-align: center;"
	                + "padding: 20px;"
	                + "font-size: 20px;"
	                + "}"
	                + ".email-body {"
	                + "padding: 20px;"
	                + "color: #333333;"
	                + "}"
	                + ".email-body p {"
	                + "margin: 10px 0;"
	                + "font-size: 16px;"
	                + "}"
	                + ".email-footer {"
	                + "background-color: #f1f1f1;"
	                + "text-align: center;"
	                + "padding: 15px;"
	                + "font-size: 14px;"
	                + "color: #666666;"
	                + "}"
	                + "</style>"
	                + "</head>"
	                + "<body>"
	                + "<div class=\"email-container\">"
	                + "<div class=\"email-header\">"
	                + "New Contact Form Submission"
	                + "</div>"
	                + "<div class=\"email-body\">"
	                + "<p><strong>Name:</strong> "+mail.getName()+"</p>"
	                + "<p><strong>Email:</strong> "+mail.getEmail()+"</p>"
	                + "<p><strong>Phone:</strong> "+mail.getPhone()+"</p>"
	                + "<p><strong>Message:</strong></p>"
	                + "<p>"+mail.getMessage()+"</p>"
	                + "</div>"
	                + "<div class=\"email-footer\">"
	                + "This message was sent via your website contact form."
	                + "</div>"
	                + "</div>"
	                + "</body>"
	                + "</html>";



	        helper.setText(htmlContent, true);  // true indicates the message is in HTML

	        mailSender.send(message);
	    }
}
