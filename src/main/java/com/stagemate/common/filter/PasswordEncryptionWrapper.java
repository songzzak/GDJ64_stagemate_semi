package com.stagemate.common.filter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class PasswordEncryptionWrapper extends HttpServletRequestWrapper {
	private static final String ALGORITHM = "SHA-512";
	
	public PasswordEncryptionWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		final String dataBinded = super.getParameter(name);
		
		// 비밀번호 name 통일하기
		if (name.equals("password") || name.equals("passwordToConfirm")) {
			return getSHA512(dataBinded);
		}
		return dataBinded;
	}
	
	public static String getSHA512(String pwOriginal) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		byte[] pwOriginalToBytes = pwOriginal.getBytes();
		md.update(pwOriginalToBytes);
		byte[] bytesEncrypted = md.digest();
		return Base64.getEncoder().encodeToString(bytesEncrypted);
	}
}
