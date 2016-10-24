package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;

public interface CartDAO {
	
	public List<Cart> list(String id);

	public Cart get(String id);

	public void saveOrUpdate(Cart cart);

	public String delete(int id);
	
	public long getTotalAmount(String id);
	
	public Cart getByUserId(String uId);
	

}
