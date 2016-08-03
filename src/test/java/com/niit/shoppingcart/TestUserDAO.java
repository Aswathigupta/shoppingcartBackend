package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.UserDetails;

public class TestUserDAO {

	@Autowired
	UserDAO userDAO;

	@Autowired
	UserDetails userDetails;

	AnnotationConfigApplicationContext context;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
 
		userDAO = (UserDAO) context.getBean("userDAO");
		userDetails = (UserDetails) context.getBean("userDetails");

	}
	@Test
	public void UserTestCase() {
		int size = userDAO.list().size();
		assertEquals("user list test case", 1, size);
	}

}
