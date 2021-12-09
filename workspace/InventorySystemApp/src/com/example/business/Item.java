/**
 * 
 */
package com.example.business;

import com.example.service.InventoryService;

public class Item {
	/**
	 * item object with itemid, itemname, itemdesc, itemprice, itemquantity, itemcategory, itemsupplier
	 * @param itemId
	 * @param itemName
	 * @param itemDesc
	 * @param itemPrice
	 * @param itemQuantity
	 * @param itemCategory
	 * @param itemSupplier
	 */
	private int itemId;
	private String itemName;
	private String itemDesc;
	private int itemPrice;
	private int itemQuantity;
	private String itemCategory;
	private String itemSupplier;
	
	public Item(int inventoryId, String name, String description, int price, int quantity, String category, String supplier) {
		this.itemId = inventoryId;
		this.itemName = name;
		this.itemDesc = description;
		this.itemPrice = price;
		this.itemQuantity = quantity;
		this.itemCategory = category;
		this.itemSupplier = supplier;
	}
	
	public Item() {
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}


	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemSupplier() {
		return itemSupplier;
	}

	
	public void setItemSupplier(String itemSupplier) {
		this.itemSupplier = itemSupplier;
	}
}