package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class ProductTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingcart");
		context.refresh();

		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");

		Product product = (Product) context.getBean("product");
		product.setId("PRD1");
		product.setName("Mobile");
		product.setDescription("PRDdesc101");
		product.setPrice(20000);

		productDAO.saveOrUpdate(product);

		if (productDAO.get("PRD") == null) {
			System.out.println("Product does not exist");
		} else {
			System.out.println("Product exists..");
		}
	}


}
