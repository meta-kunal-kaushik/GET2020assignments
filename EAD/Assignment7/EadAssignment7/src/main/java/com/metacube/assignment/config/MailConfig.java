package com.metacube.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.assignment.mail.MockMailSender;
import com.metacube.assignment.mail.SmtpMailSender;

/*
 * This is configuration class  
 */
@Configuration
public class MailConfig {

	@Bean("mockmail")
	public MockMailSender mockSend() {
		return new MockMailSender();
	}

	@Bean("smtpmail")
	public SmtpMailSender smtpSend() {
		return new SmtpMailSender();
	}

}