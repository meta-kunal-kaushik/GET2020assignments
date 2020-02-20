package com.metacube.assignment.mail;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("sendsmtp")
@Primary
public class SmtpMailSender implements MailSender {

	/*
	 * This function is used to show print smtp mail
	 */
	@Override
	public void send() {
		System.out.print("Smtp mail");
	}
}