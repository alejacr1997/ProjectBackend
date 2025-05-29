package com.project.springboot.users.commons.utils;

import java.util.Base64;
import java.util.regex.Pattern;

public class Utils {

	public boolean validatePassword(String passBase64) {
		String password = decodePassword(passBase64);
		return validatePatternPassword(password);
	}
	
	public String decodePassword(String passBase64) {
		byte[] decodedPasswordBytes = Base64.getDecoder().decode(passBase64);
		return new String(decodedPasswordBytes);
	}
	
	public boolean validatePatternPassword(String password) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&._#])[A-Za-z\\d@$!%*?&._#]{8,}$"; 
		return Pattern.matches(regex, password);
	}
	
	public String getFullName(String firstname, String middlename) {
		if(middlename != null) {
			return firstname + " " +middlename;
		}
		return firstname;
	}
	
}
