package com.footwear.service;

import java.util.List;

import com.footwear.model.Item;

public interface FootService 
{
	List<Item> getElementByCategory(String category);

}
