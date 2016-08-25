package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

public class UserTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingcart");
		context.refresh();

		UserDAO userDAO = (UserDAO) context.getBean("userDAO");

		User user = (User) context.getBean("user");
		user.setId("niit");
		user.setPassword("niit");
		user.setName("Aswathi");
		user.setEmailID("ash@gmail.com");
		user.setAddress("Kerala");
		user.setContactNumber("123");
		user.setAdmin(true);
	

		userDAO.saveOrUpdate(user);

		if (userDAO.isValidUser("niit", "niit")) {
			System.out.println("welcome admin");
		} else {
			System.out.println("invalid crdentials");
		}
	}

}