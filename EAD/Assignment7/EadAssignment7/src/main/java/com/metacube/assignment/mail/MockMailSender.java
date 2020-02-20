package com.metacube.assignment.mail;

import org.springframework.stereotype.Component;

@Component("sendmockmiail")
public class MockMailSender implements MailSender {

	/*
	 * This function is used to show print mock mail
	 */
	@Override
	public void send() {
		System.out.print("Mock mail");
	}
}