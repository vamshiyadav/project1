package com.footwear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footwear.dao.FootDao;
import com.footwear.model.Item;
@Service
public class FootServiceImpl implements FootService
{
	@Autowired
	FootDao footDao;
	public List<Item> getElementByCategory(String category)
	{
		List<Item> list = footDao.getElementByCategory(category);
		return list;
	}

}
