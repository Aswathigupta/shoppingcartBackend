package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Cart;

public class CartTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingcart");
		context.refresh();

		CartDAO cartDAO = (CartDAO) context.getBean("cartDAO");

		Cart cart = (Cart) context.getBean("cart");
		
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		
//		cart.setId("01");
		cart.setPrice(49999);
		cart.setQuantity(1);
		cart.setStatus('N');
	
		cart.setUser(userDAO.get("US001"));
		cart.setProduct(productDAO.get("PRD1"));
		
		cartDAO.saveOrUpdate(cart);
		
		
		System.out.println("updated");
		System.out.println("Total : " + cartDAO.getTotalAmount("US001"));
		

//		if (cartDAO.get("01")== null) {
//			System.out.println("Cart does not exist");
//		} else {
//			System.out.println("Cart exists..");
//		}
	}
	

}
