package com.footwear.dao;

import java.util.List;

import com.footwear.model.CartItem;


public interface CartItemDao
{
	void addCartItem(CartItem cartItem);
	List<CartItem> getCartItemByCartId(int cartId);

}
