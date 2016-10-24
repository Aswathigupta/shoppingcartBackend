package com.niit.shoppingcart.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Cart;

@Repository("cartDAO")

public class CartDAOImpl implements CartDAO {

	Logger log = LoggerFactory.getLogger(CartDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public Cart get(String id) {
		log.debug("start : calling get");
		String hql = "from Cart where id=" + "'" + id + "'  and status = " + "'N'";

		Query<Cart> query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> listCart = query.getResultList();
		if (listCart != null && !listCart.isEmpty()) {
			return listCart.get(0);
		}
		log.debug("end : calling get");
		return null;

	}

	@Transactional
	public void saveOrUpdate(Cart cart) {
		log.debug("starting of the method saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("ending of the method saveOrUpdate");
	}

	@Transactional
	public String delete(int id) {
		Cart cart = new Cart();
		cart.setId(id);
		
		
		try {
			sessionFactory.getCurrentSession().delete(cart);
		} catch (HibernateException e) {
			e.printStackTrace();
			return e.getMessage();
		}

		return null;

	}



	@Transactional
	public List<Cart> list(String id) {
		log.debug("start : calling list");
		String hql = "from Cart where user_id=" + "'" + id + "' and status = " + "'N'";

		Query<Cart> query = sessionFactory.getCurrentSession().createQuery(hql);

		List<Cart> list = (List<Cart>) query.list();
		log.debug("end : calling list");

		return list;
	}
	


	@SuppressWarnings("unchecked")
	@Transactional
	public Cart getByUserId(String uId) {
		log.debug("start : calling getByUserId");
		String hql = "from Cart where user_id=" + "'" + uId + "'  and status = " + "'N'";

		Query<Cart> query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> listCart = query.getResultList();
		if (listCart != null && !listCart.isEmpty()) {
			return listCart.get(0);
		}
		log.debug("end : calling getByUserId");
		return null;
	}


	@Transactional
	public long getTotalAmount(String id) {
		String hql = "select sum(price) from Cart where user=" + "'" + id + "' and status = 'N'";
		System.out.println("&&&&&&&&&&&&&&&&&&&&"+id);
		Query<Cart> query = sessionFactory.getCurrentSession().createQuery(hql);

		List listCart=(List) query.getResultList();
		long total = (Long) listCart.get(0);
		/*List<Cart> c=query.list();
		Cart mysum=null;
		for(Cart i : c)
		{
			
			mysum=i;
		}*/
		if(listCart!=null && !listCart.isEmpty() ) {
			return total;
		}
		System.out.println("**********"+listCart.get(0));

		

		return  0 ;
		
	}
	

	
	
}
