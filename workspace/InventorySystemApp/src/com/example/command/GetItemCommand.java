package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.Inventory;
import com.example.business.Item;
import com.example.service.InventoryService;

public class GetItemCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// get inventory InventoryService
		InventoryService inventoryService = new InventoryService();
		String forwardToJsp = "";		
		
		String itemIdString = request.getParameter("itemid");

		//Check we have a username and password...
		if (itemIdString != null){
			int itemid = Integer.parseInt(itemIdString);
			
			Item itemFromInventory = inventoryService.getItemUsingItemID(itemid);
			if (itemFromInventory != null){

				//If login successful, store the session id for this client...
				HttpSession session = request.getSession();
				String clientSessionId = session.getId();
				session.setAttribute("loggedSessionId", clientSessionId);

				session.setAttribute("item", itemFromInventory);

				forwardToJsp = "/editItem.jsp";				
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("heading", "get Item failure");
				session.setAttribute("message", "Item not found");
				forwardToJsp = "/inventoryFailure.jsp";	
			}
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("heading", "get Item Failure");
			session.setAttribute("message", "Item not found");
			forwardToJsp = "/inventoryFailure.jsp";	
		}
		return forwardToJsp;
	}

}
