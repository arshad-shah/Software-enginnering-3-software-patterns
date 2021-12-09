package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.Inventory;
import com.example.business.Item;
import com.example.service.InventoryService;

public class UpdateItemCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// get inventory InventoryService
		InventoryService inventoryService = new InventoryService();
		String forwardToJsp = "";		
		
		String itemidString = request.getParameter("itemid");
		String itemName = request.getParameter("itemName");
		String itemDesc = request.getParameter("itemDesc");
		String itemPriceString = request.getParameter("itemPrice");
		String itemQuantityString = request.getParameter("itemQuantity");
		String itemCategory = request.getParameter("itemCategory");
		String itemSupplier = request.getParameter("itemSupplier");

		//Check we have a username and password...
		if (itemName != null && itemDesc != null && itemPriceString != null && itemQuantityString != null && itemCategory != null && itemSupplier != null){
			int itemid = Integer.parseInt(itemidString);
			int itemPrice = Integer.parseInt(itemPriceString);
			int itemQuantity = Integer.parseInt(itemQuantityString);
			
			//Make call to the 'Model' using the UserServive class to login...
			Item itemCreated = new Item(itemid,itemName,itemDesc,itemPrice,itemQuantity,itemCategory,itemSupplier);
			boolean itemAddedToInventory = inventoryService.updateItem(itemCreated);
			if (itemAddedToInventory){

				//If login successful, store the session id for this client...
				HttpSession session = request.getSession();
				String clientSessionId = session.getId();
				session.setAttribute("loggedSessionId", clientSessionId);

				//get the inventory from the database
				Inventory inventory = inventoryService.DisplayInventory();
				
				int maxItemId = inventoryService.getMaxItemId();
				session.setAttribute("maxItemId", maxItemId);

				session.setAttribute("inventory", inventory);

				forwardToJsp = "/inventory.jsp";				
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("heading", "Update Item Failure");
				session.setAttribute("message", "Updating the Item failed.");
				forwardToJsp = "/inventoryFailure.jsp";	
			}
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("heading", "Update Item Failure");
			session.setAttribute("message", "Updating the Item failed.");
			forwardToJsp = "/inventoryFailure.jsp";		
		}
		return forwardToJsp;
	}

}
