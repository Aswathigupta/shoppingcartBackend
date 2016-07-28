package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.UserDetails;

public class UserDetailstest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingcart");
		context.refresh();

		UserDAO userDAO = (UserDAO) context.getBean("userDAO");

		UserDetails userDetails = (UserDetails) context.getBean("userDetails");
		userDetails.setId("US1");
		userDetails.setName("EFilla");
		userDetails.setMailID("xyz@gmail.com");
		userDetails.setAddress("Mumbai");
		userDetails.setContactNumber("1234");
		userDetails.setAdmin((byte) 1);

		userDAO.saveOrUpdate(userDetails);

		if (userDetails.getAdmin() == 0) {
			System.out.println("Welcome User");
		}

		else if (userDetails.getAdmin() == 1) {
			System.out.println("Welcome admin");

		} else {
			System.out.println("UserDetails exists..");

		}

	}

}