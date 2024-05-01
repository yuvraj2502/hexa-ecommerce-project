package com.utility;

import java.util.regex.Pattern;

public class LoginValidation {
	public static boolean passIsValid(String password) {
		if (password.length() > 5)
			return true;
		return false;
	}

	public static boolean isValidEmail(String email) {

		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

		Pattern pattern = Pattern.compile(emailRegex);

		return pattern.matcher(email).matches();
	}
}
