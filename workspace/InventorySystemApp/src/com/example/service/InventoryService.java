package com.example.service;

import com.example.business.Inventory;
import com.example.business.Item;
import com.example.dao.InventoryDao;
import com.example.exceptions.DaoException;

public class InventoryService {
	
	//the Inventory dao class
	InventoryDao inventorydao = new InventoryDao();

	/**
	 * This method is used to display the full inventory
	 * @throws DaoException
	 * @return the inventory object
	 */
	public Inventory DisplayInventory(){
		Inventory inventory = new Inventory();
		try {
			inventory = inventorydao.getInventory();
		} catch (DaoException e) {
			e.printStackTrace();
		}

		return inventory;
	}

	/**
	 * This method is used to add the item to the inventory
	 * @throws DaoException
	 * @param item The item object
	 * @return true if the item is added successfully
	 */
	public boolean addItem(Item item){
		boolean result = false;
		try {
			result = inventorydao.addItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * This method is used to delete the item in the inventory
	 * using the item id
	 * @throws DaoException
	 * @param id The item id
	 * @return true if the item is deleted successfully
	 */
	public boolean deleteItemUsingItemID(int id){
		boolean result = false;
		try {
			result = inventorydao.deleteItem(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * This method is used to update the item in the inventory
	 * using the item
	 * @throws DaoException
	 * @param item The item object
	 * @return true if the item is updated successfully
	 */
	public boolean updateItem(Item item){
		boolean result = false;
		try {
			result = inventorydao.updateItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return result;
	} 

	
	/**
	 * return max id of item in inventory
	 * @return max id of item in inventory
	 */
	public int getMaxItemId() {
		int maxItemId = 0;
		try {
			maxItemId = inventorydao.getMaxItemId();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return maxItemId;
	}

	/**
	 * This method is used to get the item in the inventory
	 * using the item id
	 * @throws DaoException
	 * @param itemId
	 * @return the item object
	 */
	public Item getItemUsingItemID(int itemId) {
		Item item = new Item();
		try {
			item = inventorydao.getItem(itemId);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return item;
	}
}