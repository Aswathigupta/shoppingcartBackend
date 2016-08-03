package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class TestSupplierDAO {


	@Autowired
	static SupplierDAO supplierDAO;

	@Autowired
	static Supplier supplier;

	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		supplier = (Supplier) context.getBean("supplier");
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		
	}

	@Test
	public void SupplierIdTest() {
		supplier = supplierDAO.get("SUP1");
		String id = supplier.getId();
		assertEquals("Supplier id test", "SUP1", id);
	}
}
