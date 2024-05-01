package com.test;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.exception.InvalidCredentialsException;
import com.exception.InvalidLoginInput;
import com.model.User;
import com.service.UserService;

//Author = Yuvraj
public class UserServiceTest {
	UserService userService = new UserService();

	@Test
	public void login()  {
		// Use case 1: Valid Credentials
		String email="yuvraj@gmail.com";
		String password="345opq^";
		
		User actualUser;
		try {
			actualUser = userService.login(email, password);
			User expectedUser=new User(1, "yuvraj@gmail.com", "345opq^", "Customer");
			System.out.println(actualUser);
			System.out.println(expectedUser);
			Assert.assertEquals(expectedUser, actualUser);
		} catch (SQLException | InvalidCredentialsException | InvalidLoginInput e) {
			System.out.println(e.getMessage());
		}
		
		
		//UseCase 2 , Invalid Credentials/
		email="yuvraj@gmail.com";
		password="345ghopq^";
		
		try {
			actualUser = userService.login(email, password);
			User expectedUser=new User(1, "yuvraj@gmail.com", "345opq^", "Customer");
			System.out.println(actualUser);
			System.out.println(expectedUser);
			Assert.assertEquals(expectedUser, actualUser);
		} catch (SQLException | InvalidCredentialsException| InvalidLoginInput e) {
			System.out.println("Test case 2");
			System.out.println(e.getMessage());
		}
		
		
		email="yuvi@gmail.com";
		password="342";
		
		try {
			actualUser = userService.login(email, password);
			User expectedUser=new User(1, "yuvraj@gmail.com", "345opq^", "Customer");
			System.out.println(actualUser);
			System.out.println(expectedUser);
			Assert.assertEquals(expectedUser, actualUser);
		} catch (SQLException | InvalidCredentialsException| InvalidLoginInput e) {
			System.out.println("Test case 2");
			System.out.println(e.getMessage());
		}
		
		
		
	}
}
