package com.footwear.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.footwear.model.Item;
import com.footwear.service.FootServiceImpl;

@Controller
public class FootController 
{
	@Autowired
	FootServiceImpl footServiceImpl;
	@RequestMapping("/toViewCategoryWise")
	public ModelAndView disCategory(String category) throws JsonGenerationException, JsonMappingException, IOException
	{
		List<Item> list = footServiceImpl.getElementByCategory(category);
		ObjectMapper mapper=new ObjectMapper();
		String listJSON=mapper.writeValueAsString(list);
		return new ModelAndView("CategoryView","categoryWiseList",listJSON);
	}
	
}
