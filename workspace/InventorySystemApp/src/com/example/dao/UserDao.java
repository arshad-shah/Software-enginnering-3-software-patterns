package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.business.InventoryManager;
import com.example.exceptions.DaoException;


public class UserDao extends Dao {

	/**
	 * find user using username and password
	 * @param uname
	 * @param pword
	 * @return	inventoryManager object
	 * @throws DaoException
	 */
	public InventoryManager findUserByUsernamePassword(String uname, String pword) throws DaoException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		InventoryManager inventoryManager = null;
		try {
			con = this.getConnection();

			String query = "SELECT * FROM USER WHERE USERNAME = ? AND PASSWORD = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pword);

			rs = ps.executeQuery();
			if (rs.next()) {
				int userId = rs.getInt("ID");
				String name = rs.getString("NAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				inventoryManager = new InventoryManager(name, username, password);
			}
		} catch (SQLException e) {
			throw new DaoException("findUserByUsernamePassword " + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					freeConnection(con);
				}
			} catch (SQLException e) {
				throw new DaoException("findUserByUsernamePassword" + e.getMessage());
			}
		}
		return inventoryManager; // inventoryManager may be null 
	}
	
	/**
	 * add user to database using name, username and password
	 * @param manager The inventory manager
	 * @return true if user is added successfully
	 * @throws DaoException
	 */
	public boolean addUser(InventoryManager manager) throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean added = false;
		try {
			con = this.getConnection();

			String query = "INSERT INTO USER (NAME,USERNAME, PASSWORD) VALUES (?,?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1, manager.getManagerName());
			ps.setString(2, manager.getUsername());
			ps.setString(3, manager.getPassword());

			int rows = ps.executeUpdate();
			if (rows > 0) {
				added = true;
			}
		} catch (SQLException e) {
			throw new DaoException("addUser " + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					freeConnection(con);
				}
			} catch (SQLException e) {
				throw new DaoException("addUser" + e.getMessage());
			}
		}
		return added;
	}


	/**
	 * delete user from database using userId
	 * @param userId
	 * @return true if user is deleted successfully
	 * @throws DaoException
	 */
	public boolean deleteUserById(int userId) throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean deleted = false;
		try {
			con = this.getConnection();

			String query = "DELETE FROM USER WHERE ID = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, userId);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				deleted = true;
			}
		} catch (SQLException e) {
			throw new DaoException("deleteUserById " + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					freeConnection(con);
				}
			} catch (SQLException e) {
				throw new DaoException("deleteUserById" + e.getMessage());
			}
		}
		return deleted;
	}
	
	/**
	 * check if user name already exists in database
	 * @param uname
	 * @return true if user name already exists
	 * @throws DaoException
	 */
	public boolean checkUserNameExists(String uname) throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean exists = false;
		try {
			con = this.getConnection();

			String query = "SELECT * FROM USER WHERE USERNAME = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, uname);

			rs = ps.executeQuery();
			if (rs.next()) {
				exists = true;
			}
		} catch (SQLException e) {
			throw new DaoException("checkUserNameExists " + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					freeConnection(con);
				}
			} catch (SQLException e) {
				throw new DaoException("checkUserNameExists" + e.getMessage());
			}
		}
		return exists;
	}

	/**
	 * update password of user in database
	 * using the username
	 * @param username
	 * @param password
	 * @return true if password is updated successfully
	 */
	public boolean updatePassword(String username, String password) throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean updated = false;
		try {
			con = this.getConnection();

			String query = "UPDATE USER SET PASSWORD = ? WHERE USERNAME = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, password);
			ps.setString(2, username);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				updated = true;
			}
		} catch (SQLException e) {
			throw new DaoException("updatePassword " + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					freeConnection(con);
				}
			} catch (SQLException e) {
				throw new DaoException("updatePassword" + e.getMessage());
			}
		}
		return updated;
	}
}
