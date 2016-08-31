package com.footwear.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.footwear.model.Customer;
import com.footwear.model.Item;
import com.footwear.service.AddProductService;
import com.footwear.service.CustomerService;

@Controller
public class HomeController {
	@Autowired
	AddProductService aservice;
	
	@Autowired
	CustomerService customerService;
	//this is first home page request mapping
	@RequestMapping("/")
	public ModelAndView vs()
	{
		System.out.println("home() method called");
		return new ModelAndView("homePage");
	}
	// this is for sign in page ,if user click the button
	@RequestMapping("/signIn")
	public ModelAndView bs()
	{
		System.out.println("signIn() method called");
		return new ModelAndView("login");
	}
	//this is for signup, it goes to controller with a spring forms
	@RequestMapping("/signUp")
	public ModelAndView bd()
	{
		Customer customer=new Customer();
		System.out.println("signup() method called");
		return new ModelAndView("signUp","customerObj",customer);
	}
	//in this the obj frst map with the obj name
	@RequestMapping("/CustomerCheck")
	public ModelAndView CustomerCheck(Principal principal) throws JsonGenerationException, JsonMappingException, IOException
	{
		System.out.println("username:"+principal.getName());
		List<Item> items=aservice.viewItem();
		ObjectMapper mapper=new ObjectMapper();
		String jsonData=mapper.writeValueAsString(items);
		System.out.println("Json data:"+jsonData);
		return new ModelAndView("customerHome","items",jsonData);
		
	}
	@RequestMapping("/AdminCheck")
	public ModelAndView AdminCheck(Principal principal)
	{
		System.out.println("username:"+principal.getName());
		return new ModelAndView("AdminHome");
	}
	
	@RequestMapping("viewSelectedItem")
	public ModelAndView vsi(@RequestParam("id")String id){
		Item item=aservice.getItemById(Integer.parseInt(id));
		return new ModelAndView("viewSelectedItem","item",item);
		
	}
	
	@RequestMapping("/Register")
	public ModelAndView gd(@Valid@ModelAttribute("customerObj") Customer customer,BindingResult br)
	{
		
		if(br.hasErrors())
		{
			return new ModelAndView("signUp");
		}
		System.out.println("Username:"+customer.getUsername());
		System.out.println("Password:"+customer.getPassword());
		customerService.addCustomer(customer);
		return new ModelAndView("signUp");
		
	}
	@RequestMapping("/login")
	public String loginMethod()
	{
		System.out.println("login page called");
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		request.getSession().invalidate();
		System.out.println("logout page called");

		return "logout";
		
	}
	@RequestMapping("/contactUs")
	public ModelAndView contactUs()
	{
		System.out.println("contact page called");
		return new ModelAndView("contactUs");
		
	}
	@RequestMapping("/aboutUs")
	public ModelAndView aboutUs()
	{
		System.out.println("about page called");
		return new ModelAndView("aboutUs");
		
	}
	

}
