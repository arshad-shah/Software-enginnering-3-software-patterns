package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.Inventory;
import com.example.business.Item;
import com.example.service.InventoryService;

public class DeleteItemCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// get inventory InventoryService
		InventoryService inventoryService = new InventoryService();
		String forwardToJsp = "";		
		
		String itemIdString = request.getParameter("itemid");

		//Check we have a username and password...
		if (itemIdString != null){
			int itemid = Integer.parseInt(itemIdString);
			
			boolean itemDeletedFromInventory = inventoryService.deleteItemUsingItemID(itemid);
			if (itemDeletedFromInventory){

				//If login successful, store the session id for this client...
				HttpSession session = request.getSession();
				String clientSessionId = session.getId();
				session.setAttribute("loggedSessionId", clientSessionId);

				//get the inventory from the database
				Inventory inventory = inventoryService.DisplayInventory();

				session.setAttribute("inventory", inventory);
				
				int maxItemId = inventoryService.getMaxItemId();
				session.setAttribute("maxItemId", maxItemId);

				forwardToJsp = "/inventory.jsp";				
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("heading", "delete Item Failure");
				session.setAttribute("message", "Item could not be deleted. try again.");
				forwardToJsp = "/inventoryFailure.jsp";	
			}
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("heading", "delete Item Failure");
			session.setAttribute("message", "item could not be found.");
			forwardToJsp = "/inventoryFailure.jsp";	
		}
		return forwardToJsp;
	}

}
