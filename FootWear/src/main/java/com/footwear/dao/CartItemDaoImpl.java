package com.footwear.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footwear.model.CartItem;
@Repository
public class CartItemDaoImpl implements CartItemDao{

	@Autowired
	SessionFactory sessionFactory;
	public void addCartItem(CartItem cartItem) {
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.save(cartItem);
		transaction.commit();
		
	}

}
