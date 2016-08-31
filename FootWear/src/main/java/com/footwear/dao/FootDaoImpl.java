package com.footwear.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footwear.model.Item;
@Repository
public class FootDaoImpl implements FootDao
{
	@Autowired
	SessionFactory sessionFactory;
	public List<Item> getElementByCategory(String category) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Item> list = session.createCriteria(Item.class).add(Restrictions.like("category",category)).list();
		return list;
	}

}
