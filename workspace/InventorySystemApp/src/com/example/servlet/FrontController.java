package com.example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.command.Command;
import com.example.command.CommandFactory;
import com.example.exceptions.CommandCreationException;;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns={"/FrontController"})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_ACTION = "LoginUser";
	private static final String LOGOUT_ACTION = "LogoutUser";
	private static final String ADD_USER_ACTION = "SignUpUser";
	private static final String ADD_USER_ACTION_CLICK = "SignUpUserClick";
	private static final String RESET_PASSWORD_ACTION_CLICK = "ResetPasswordClick";
	private static final String RESET_PASSWORD_ACTION = "ResetPassword";
	private static final String ADD_ITEM_ACTION = "AddItem";
	private static final String ADD_ITEM_ACTION_CLICK = "AddItemClick";
	//delete item
	private static final String DELETE_ITEM_ACTION = "DeleteItem";
	private static final String UPDATE_ITEM_ACTION = "UpdateItem";
	private static final String GET_ITEM_ACTION = "GetItem";

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest (request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}	
	
	
	/**
	 * Common method to process all client requests (GET and POST)
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {

		String forwardToJsp = null;		
		String action = request.getParameter("action");
		
		
		if(action.equalsIgnoreCase(ADD_USER_ACTION_CLICK)) {
			forwardToJsp = "/signUp.jsp";
			forwardToPage(request, response, forwardToJsp);
			return;
		}
		else if(action.equalsIgnoreCase(RESET_PASSWORD_ACTION_CLICK)) {
			forwardToJsp = "/resetPassword.jsp";
			forwardToPage(request, response, forwardToJsp);
			return;
		}
		else if(action.equalsIgnoreCase(ADD_ITEM_ACTION_CLICK)) {
			forwardToJsp = "/addItem.jsp";
			forwardToPage(request, response, forwardToJsp);
			return;
		}
		else if(action.equalsIgnoreCase(LOGOUT_ACTION)) {
			request.getSession().invalidate();
            try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
		/*
		 * NOTE: AS A SPECIAL CASE, THIS SECTION OF THE CODE DEALS WITH CHECKING LOGIN DETAILS...
		 */
		
		//Check if this is not a login request...
		if (!action.equalsIgnoreCase(LOGIN_ACTION) && !action.equalsIgnoreCase(ADD_USER_ACTION) && !action.equalsIgnoreCase(RESET_PASSWORD_ACTION)) {

			//If not a login request then need to check that user is  
			//logged in before processing ANY requests.

			//Check to see if the session id coming from the client matches the id stored at login...
			HttpSession session = request.getSession();

			//If user not logged in...
			if (session.getId() != session.getAttribute("loggedSessionId")) {
				forwardToJsp = "/loginFailure.jsp";
				forwardToPage(request, response, forwardToJsp);
				return;
			}
		}
		
		
		//Now we can process whatever the request is...
		//We just create a Command object to handle the request...
		CommandFactory factory = CommandFactory.getInstance();
		Command command = null;
		
		try {
			command = factory.createCommand(action);
			forwardToJsp = command.execute(request, response);
		} catch (CommandCreationException e) {			
			e.printStackTrace();
			forwardToJsp = "/errorPage.jsp";
		}		
		
		forwardToPage(request, response, forwardToJsp);
	}
	
	
	/**
	 * Forward the server to the supplied page
	 */
	private void forwardToPage(HttpServletRequest request, HttpServletResponse response, String page){
		
		//Get the request dispatcher object and forward the request to the appropriate JSP page...
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
