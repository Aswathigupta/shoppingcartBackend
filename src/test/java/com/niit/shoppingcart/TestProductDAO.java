package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class TestProductDAO {

	@Autowired
	static ProductDAO productDAO;

	@Autowired
	static Product product;

	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		product = (Product) context.getBean("product");
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	@Test
	public void ProductIdTest() {
		product = productDAO.get("PRD1");
		String id = product.getId();
		assertEquals("product name test", "PRD1", id);
	}
}
