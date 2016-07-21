package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingcart");
		context.refresh();

		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

		Category category = (Category) context.getBean("category");
		category.setId("CG1");
		category.setName("Design");
		category.setDescription("Designing");

		categoryDAO.saveOrUpdate(category);

		if (categoryDAO.get("CG01") == null) {
			System.out.println("Category does not exist");
		} else {
			System.out.println("Category exists..");
		}
	}

}