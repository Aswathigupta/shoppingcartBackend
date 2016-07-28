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
		user.setAdmin(true);

		userDAO.saveOrUpdate(user);

		if (userDAO.isValidUser("niit", "niit", true)) {
			System.out.println("welcome admin");
		} else {
			System.out.println("invalid crdentials");
		}
	}

}