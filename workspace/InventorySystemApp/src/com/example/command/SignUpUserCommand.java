package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.Inventory;
import com.example.business.InventoryManager;
import com.example.service.InventoryService;
import com.example.service.UserService;

public class SignUpUserCommand implements Command {

	/**
	 *  Signup a user
	 * using name , username, password
	 * @param response
	 * @param request
	 * @return String forwardToJsp
	 */

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		UserService userService = new UserService();
		// get inventory InventoryService
		InventoryService inventoryService = new InventoryService();
		String forwardToJsp = "";

		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//Check we have a username and password...
		if (name != null && username != null && password != null) {

			//first check if the username is already in the system
			if (!userService.checkUsername(username)) {
				InventoryManager manager = new InventoryManager(name, username, password);

				//Make call to the 'Model' using the UserServive class to signup...
				boolean userSigningUp = userService.signUp(manager);

				//login the user
				if (userSigningUp) {
					//Make call to the 'Model' using the UserServive class to login...
					InventoryManager userLoggingIn = userService.login(username, password);

					//If login successful, store the session id for this client...
					HttpSession session = request.getSession();
					String clientSessionId = session.getId();
					session.setAttribute("loggedSessionId", clientSessionId);

					session.setAttribute("user", manager.getManagerName());

					//get the inventory from the database
					Inventory inventory = inventoryService.DisplayInventory();

					session.setAttribute("inventory", inventory);
					
					int maxItemId = inventoryService.getMaxItemId();
					session.setAttribute("maxItemId", maxItemId);

					forwardToJsp = "/inventory.jsp";
				} else {
					forwardToJsp = "/loginFailure.jsp";
				}
			} else {
				forwardToJsp = "/signupFailure.jsp";
			}
		}
		else {
			forwardToJsp = "/loginFailure.jsp";
		}
		return forwardToJsp;
	}
}