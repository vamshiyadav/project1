package com.footwear.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footwear.dao.CartItemDao;
import com.footwear.model.CartItem;


@Service
public class CartItemServiceImpl implements CartItemService{
    @Autowired
    CartItemDao cartItemDao;
	public void addCartItem(CartItem cartItem) {
		cartItemDao.addCartItem(cartItem);
		
	}

}
