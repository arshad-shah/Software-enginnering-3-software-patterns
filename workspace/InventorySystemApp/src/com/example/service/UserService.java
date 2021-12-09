package com.example.service;

import com.example.business.InventoryManager;
import com.example.dao.UserDao;
import com.example.exceptions.DaoException;

public class UserService {
	//user dao class
	UserDao userdao = new UserDao();

	/**
	 * This method is used to login to the system

	 * @param username The username
	 * @param password The password
	 * @return the InventoryManager object
	 */
	public InventoryManager login(String username, String password) {
		InventoryManager manager = null;
		try {
			manager = userdao.findUserByUsernamePassword(username, password);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return manager;
	}

	/**
	 * This method is used to add the user to the system
	 * @param inventoryManager The inventoryManager object
	 * @return true if the user is added successfully
	 */
	public boolean signUp(InventoryManager inventoryManager) {
		boolean IsUserSignupSuccessful = true;
		try {
			IsUserSignupSuccessful = userdao.addUser(inventoryManager);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return IsUserSignupSuccessful;
	}

	/**
	 * check if a user is in the system
	 * @param username The username
	 * @return true if the user is in the system
	 */
	public boolean checkUsername(String username) {
		boolean IsUserAlreadyRegistered = false;
		try {
			IsUserAlreadyRegistered = userdao.checkUserNameExists(username);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return IsUserAlreadyRegistered;
	}

	/**
	 * this method is used to update the password of the user
	 * @param username The username
	 * @param password The password
	 * @return true if the password is updated successfully
	 */
	public boolean updatePassword(String username, String password) {
		boolean IsPasswordUpdated = false;
		try {
			IsPasswordUpdated = userdao.updatePassword(username, password);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return IsPasswordUpdated;
	}	
}