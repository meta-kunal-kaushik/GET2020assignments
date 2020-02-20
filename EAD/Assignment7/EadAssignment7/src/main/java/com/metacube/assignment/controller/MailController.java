package com.metacube.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.assignment.mail.MailSender;

@RestController
public class MailController {

	/*
	 * This is used for setter injection
	 */
	private MailSender sender;

	@Autowired
	@Qualifier("sendmockmiail")
	public void setSender(MailSender sender) {
		this.sender = sender;
	}

	@GetMapping("/send")
	public String test() {
		sender.send();
		return "mail sent";
	}

	/*
	 * This is used for constructor injection
	 */
//	private MailSender sender;
//
//	 @Autowired
//	public MailController(MailSender sender) {
//	
//		this.sender = sender;
//	}
//	 @GetMapping("/send")
//		public String test() {
//			sender.send();
//			return "mail sent";
//		}

	/*
	 * This is Using Dependency injection by name
	 */

//	@Autowired
//	@Qualifier("sendmockmiail")
//	private MailSender sender;
//	
//		 
//		
//		 @GetMapping("/send")
//			public String test() {
//				sender.send();
//				return "mail sent";
//			}

	/*
	 * This is used to perform bean operation
	 */
//	private MailSender mockmail;
//
//	public MailController(MailSender mockmail) {
//
//		this.mockmail = mockmail;
//	}
//
//	@GetMapping("/send")
//	public String test() {
//		mockmail.send();
//		return "mail sent";
//	}

}