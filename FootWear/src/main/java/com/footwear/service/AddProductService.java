package com.footwear.service;

import java.util.List;

import com.footwear.model.Item;


public interface AddProductService {
	void addProduct(Item item);
	List<Item> viewItem();
	void deletItem(int id);
	Item getItemById(int id);
	void updateItem(Item item);
}
