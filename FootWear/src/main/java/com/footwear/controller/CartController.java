package com.footwear.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.footwear.model.Cart;
import com.footwear.model.CartItem;
import com.footwear.model.Customer;
import com.footwear.model.Item;
import com.footwear.service.AddProductService;
import com.footwear.service.CartItemService;
import com.footwear.service.CustomerService;


@Controller
public class CartController {
	@Autowired
	CartItemService cartItemService;
	@Autowired
	AddProductService addProductService;
	@Autowired
	CustomerService customerService;
	@RequestMapping("/addtocart")
	public String addItem(@RequestParam("id")String id)
	{
		String loggedInUserName=SecurityContextHolder.getContext().getAuthentication().getName();
		Customer customer=customerService.getCustomerByName(loggedInUserName);
		Cart cart=customer.getCart();
		Item item = addProductService.getItemById(Integer.parseInt(id));
		CartItem cartItem=new CartItem();
		cartItem.setItem(item);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(item.getPrice());
		cartItemService.addCartItem(cartItem);
		System.out.println("item is added");
		return "redirect:/customerHome";
	}
	
}
