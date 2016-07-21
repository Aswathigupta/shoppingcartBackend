package com.niit.shoppingcart.model;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;

public class UserTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingcart");
		context.refresh();

		UserDAO userDAO = (UserDAO) context.getBean("userDAO");

		User user = (User) context.getBean("user");
		
		user.setId("U1");
		user.setUsername("RAJ");
		user.setPassword("password");
		user.setEmailid("emailid");
		user.setAddress("address");
		user.setMobilenumber(1234);
		
		userDAO.saveOrUpdate(user);

		if (userDAO.get("U1") == null) {
			System.out.println("User does not exist");
		} else {
			System.out.println("User exists..");
		}
	}
}
