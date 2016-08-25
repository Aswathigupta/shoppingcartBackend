package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Product;

public class ProductTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingcart");
		context.refresh();

		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");

		Product product = (Product) context.getBean("product");

		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		
		product.setId("PRD1");
		product.setName("Mobile");
		product.setDescription("PRDdesc101");
		product.setPrice(20000);
		System.out.println("****************************"+ "\n" +categoryDAO.get("CG1") + "\n" + supplierDAO.get("SUP1")+ "\n" +"****************************"+ "\n");
//		product.setCategory(categoryDAO.get("CG1")); 
//		product.setSupplier(supplierDAO.get("SUP1"));
		product.setCategory_id("CG1");
		product.setSupplier_id("SUP1");
		System.out.println("****************************"+ "\n" +product.getCategory() + "\n" + product.getSupplier()+ "\n" +"****************************"+ "\n");

		productDAO.saveOrUpdate(product);

		System.out.println("NO of products:" + productDAO.list().size());

		if (productDAO.get("PRD1") == null) {
			System.out.println("Product does not exist");
		} else {
			System.out.println("Product exists..");
		}
	}

}
