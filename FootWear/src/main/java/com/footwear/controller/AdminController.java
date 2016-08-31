package com.footwear.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.jpa.criteria.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.footwear.model.Customer;
import com.footwear.model.Item;
import com.footwear.service.AddProductService;
import com.footwear.service.CustomerService;

@Controller
public class AdminController {
	@Autowired
	AddProductService addProductService;
	@Autowired
	CustomerService cs;
	@RequestMapping("/addItem")
	public ModelAndView addItem(){
		Item item=new Item();
		return new ModelAndView("addItem","item",item);
	}

	
	@RequestMapping("/ViewCustomers")
	public ModelAndView vs() throws JsonGenerationException, JsonMappingException, IOException
	{
		List<Customer> list=cs.viewCustomers();
		System.out.println("List is:"+list);	
		ObjectMapper mapper=new ObjectMapper();
		String listJSON=mapper.writeValueAsString(list);
		System.out.println(listJSON);
		return new ModelAndView("/ViewCustomers","listOfCustomers",listJSON);
		
	}
	
	@RequestMapping("/addProduct")
	public String ai(@Valid@ModelAttribute("item") Item item,BindingResult br,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException
	{
		if (br.hasErrors()){
			System.out.println("has errors");
			return "redirect:/addItem";
		}
		System.out.println("i am in register");
		addProductService.addProduct(item);
		MultipartFile itemImage=item.getFile();
		Path path=Paths.get("E://fresh new//FootWear//src//main//webapp//WEB-INF//resources//images//"+item.getItemId()+".jpg");
		if(itemImage !=null && !itemImage.isEmpty()){
			itemImage.transferTo(new File(path.toString()));
			System.out.println("Image added");	
		}
		System.out.println("Item added");
		return "redirect:/ViewProducts";
	}
	@RequestMapping("/ViewProducts")
	public ModelAndView viewAllProducts() throws JsonGenerationException,JsonMappingException,IOException{
		List<Item> items=addProductService.viewItem();
		ObjectMapper mapper=new ObjectMapper();
		String jsonData=mapper.writeValueAsString(items);
		System.out.println("Json data:"+jsonData);
		return new ModelAndView("viewProducts","items",jsonData);
		
	}
	
	@RequestMapping("/deleteItem")
	public String deleteItem(@RequestParam("id")int id)
	{
		addProductService.deletItem(id);
		return "redirect:/ViewProducts";
		
	}
	@RequestMapping("/updateItem")
	public ModelAndView updateItem(@RequestParam("id")int id){
		System.out.println("id:"+id);
		Item item=addProductService.getItemById(id);
		return new ModelAndView("singleItem","item",item);
		
	}
	
	@RequestMapping("/updateThisItem")
	public String updateThisItem(@RequestParam("itemId")String itemId,@RequestParam("itemName") String itemName,@RequestParam("description") String description,@RequestParam("category") String category,@RequestParam("price")String price){
		int itemid=Integer.parseInt(itemId);
		Item item=addProductService.getItemById(itemid);		
		System.out.println("Item Name:"+item.getItemName());
		item.setItemName(itemName);
		item.setDescription(description);
		item.setCategory(category);
		item.setPrice(Float.parseFloat(price));
		addProductService.updateItem(item);
		System.out.println("item updated");
		return "redirect:/ViewProducts";
		
	}
	


}
