package com.footwear.dao;

import java.util.List;

import com.footwear.model.Item;

public interface AddProductDao {
	void addProduct(Item item);
	List<Item> viewItems();
	void deleteItem(int id);
	Item getItemById(int id);
	void updateItem(Item item);

}
