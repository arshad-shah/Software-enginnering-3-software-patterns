
package com.example.business;

import java.util.ArrayList;

/**
 *  this class is used to create the inventory of the store
 */
public class Inventory {

	ArrayList<Item> inventory;
	/**
	 * constructor of the inventory class
	 * @return	the inventory object
	 */
	public Inventory() {
		inventory = new ArrayList<Item>();
	}

	/**
	 * return the full array list of the inventory
	 * @return	the array list of the inventory
	 */
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	

	/**
	 * Add an item to the inventory
	 * 
	 * @param item
	 */
	public void addItem(Item item) {
		inventory.add(item);
	}

	/**
	 * Get the item with the given name
	 * 
	 * @param name
	 * @return Item
	 */
	public Item getItem(String name) {
		for (Item item : inventory) {
			if (item.getItemName().equals(name)) {
				return item;
			}
		}
		return null;
	}

	/**
	 * delete the item with the given id
	 * 
	 * @param id
	 * @return true if the item was deleted, false otherwise
	 */
	public boolean deleteItem(int id) {
		for (Item item : inventory) {
			if (item.getItemId() == id) {
				inventory.remove(item);
				return true;
			}
		}
		return false;
	}

	/**
	 * update the item with the given id
	 * 
	 * @param id
	 * @param item
	 * @return true if the item was updated, false otherwise
	 */
	public boolean updateItem(int id, Item item) {
		for (Item i : inventory) {
			if (i.getItemId() == id) {
				i.setItemName(item.getItemName());
				i.setItemDesc(item.getItemDesc());
				i.setItemPrice(item.getItemPrice());
				i.setItemQuantity(item.getItemQuantity());
				i.setItemCategory(item.getItemCategory());
				i.setItemSupplier(item.getItemSupplier());
				return true;
			}
		}
		return false;
	}


}