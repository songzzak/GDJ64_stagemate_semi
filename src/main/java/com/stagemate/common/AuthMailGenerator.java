package com.stagemate.common;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;

public class AuthMailGenerator extends Authenticator {
	private PasswordAuthentication pa;
	
	public AuthMailGenerator(String email, String password) {
		pa = new PasswordAuthentication(email, password);
	}
	
	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}
