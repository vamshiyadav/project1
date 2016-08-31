package com.footwear.dao;

import java.util.List;

import com.footwear.model.Item;

public interface FootDao
{
	List<Item> getElementByCategory(String category);

}
