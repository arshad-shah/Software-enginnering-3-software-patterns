package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.Inventory;
import com.example.business.InventoryManager;
import com.example.service.InventoryService;
import com.example.service.UserService;

public class LoginUserCommand implements Command {

	
	@Override
	public String execute(
			HttpServletRequest request, HttpServletResponse response) {
		
		// get inventory InventoryService
		InventoryService inventoryService = new InventoryService();
			
		UserService userService = new UserService();
		String forwardToJsp = "";		

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//Check we have a username and password...
		if (username != null && password != null){

			//Make call to the 'Model' using the UserServive class to login...
			InventoryManager userLoggingIn = userService.login(username, password);

			if (userLoggingIn != null){

				//If login successful, store the session id for this client...
				HttpSession session = request.getSession();
				String clientSessionId = session.getId();
				session.setAttribute("loggedSessionId", clientSessionId);

				session.setAttribute("user", userLoggingIn.getManagerName());

				//get the inventory from the database
				Inventory inventory = inventoryService.DisplayInventory();

				session.setAttribute("inventory", inventory);
				int maxItemId = inventoryService.getMaxItemId();
				session.setAttribute("maxItemId", maxItemId);

				forwardToJsp = "/inventory.jsp";				
			}
			else {
				forwardToJsp = "/loginFailure.jsp";	
			}
		}
		else {
			forwardToJsp = "/loginFailure.jsp";	
		}
		return forwardToJsp;
	}

}
