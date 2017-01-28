package com.app.dao;

import java.util.List;

import com.app.model.Item;

public interface IItemDao {

	public int saveItem(Item item);
	public List<Item> getAllItems();	
}
