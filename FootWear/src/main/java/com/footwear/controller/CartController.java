package com.footwear.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		return "redirect:/CustomerCheck";
	}
	@RequestMapping("/viewCart")
	public ModelAndView displayCart() throws JsonGenerationException, JsonMappingException, IOException
	{
		String loggedInUserName=SecurityContextHolder.getContext().getAuthentication().getName();
		Customer customer=customerService.getCustomerByName(loggedInUserName);
		Cart cart=customer.getCart();
		int cartId = cart.getCartId();
		List<CartItem> list = cartItemService.getCartItemByCartId(cartId);
		ObjectMapper mapper = new ObjectMapper();
		String listJSON = mapper.writeValueAsString(list);
		return new ModelAndView("cartProducts","CartItemsKey",listJSON);
	}
	
}
