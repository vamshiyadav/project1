package com.footwear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footwear.dao.AddProductDao;

import com.footwear.model.Item;


@Service
public class AddProductServiceImpl implements AddProductService{
 
	@Autowired
	AddProductDao addProductDao;
	public void addProduct(Item item) {
		System.out.println("i am in service now");
		addProductDao.addProduct(item);
		
	}

	public List<Item> viewItem() {
		List<Item> list=addProductDao.viewItems();
		return list;
	}

	public void deletItem(int id) {
		addProductDao.deleteItem(id);
		
	}

	public Item getItemById(int id) {
		return addProductDao.getItemById(id);
	}

	public void updateItem(Item item) {
		addProductDao.updateItem(item);
		
	}

	

}
