package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "user")
@Component
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@NotNull(message="Name cannot be null")
	@Size(min=2, max=30)
	private String Name;

	 @NotNull(message="Password cannot be null")
	 @Size(min=4)
	private String password;

	 @NotNull(message="EmailID cannot be null")
	private String EmailID;

	@NotNull(message="Address cannot be null")
	private String Address;

	@NotNull(message="ContactNumber cannot be null")
	@Size(max=10)
	private String ContactNumber;

	private boolean isAdmin;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Set<Cart> cart;

	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailID() {
		return EmailID;
	}

	public void setEmailID(String emailID) {
		EmailID = emailID;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}