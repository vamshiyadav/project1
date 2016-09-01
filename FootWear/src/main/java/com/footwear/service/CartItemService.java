package com.footwear.service;

import java.util.List;

import com.footwear.model.CartItem;

public interface CartItemService 
{
	void addCartItem(CartItem cartItem);
	List<CartItem> getCartItemByCartId(int cartId);

}
