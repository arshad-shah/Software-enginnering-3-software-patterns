package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.business.Inventory;
import com.example.business.Item;
import com.example.exceptions.DaoException;

public class InventoryDao extends Dao {

	/**
	 * return all items in inventory
	 * @return	list of items
	 * @throws DaoException
	 */
	public Inventory getInventory() throws DaoException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Inventory i = new Inventory();
		Item item = null;
		try {
			con = this.getConnection();

			String query = "SELECT * FROM INVENTORY";
			ps = con.prepareStatement(query);

			rs = ps.executeQuery();
			while (rs.next()) {
				int inventoryId = rs.getInt("itemid");
				String name = rs.getString("ITEM_NAME");
				String description = rs.getString("ITEM_DESC");
				int price = rs.getInt("ITEM_PRICE");
				int quantity = rs.getInt("ITEM_QUANTITY");
				String category = rs.getString("ITEM_CATEGORY");
				String supplier = rs.getString("ITEM_SUPPLIER");
				item = new Item(inventoryId, name, description, price, quantity, category, supplier);
				i.addItem(item);
			}
		} catch (SQLException e) {
			throw new DaoException("getInventory " + e.getMessage());
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
				throw new DaoException("getInventory" + e.getMessage());
			}
		}
		return i; // i may be null 
	}

	/**
	 * return item with given id
	 * @param itemid the id of the item
	 * @return 	the item
	 * @throws DaoException
	 */
	public Item getItem(int itemid) throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Item item = null;
		try {
			con = this.getConnection();

			String query = "SELECT * FROM INVENTORY WHERE ITEMID = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, itemid);

			rs = ps.executeQuery();
			while (rs.next()) {
				int inventoryId = rs.getInt("itemid");
				String name = rs.getString("ITEM_NAME");
				String description = rs.getString("ITEM_DESC");
				int price = rs.getInt("ITEM_PRICE");
				int quantity = rs.getInt("ITEM_QUANTITY");
				String category = rs.getString("ITEM_CATEGORY");
				String supplier = rs.getString("ITEM_SUPPLIER");
				item = new Item(inventoryId, name, description, price, quantity, category, supplier);
			}
		} catch (SQLException e) {
			throw new DaoException("getItem " + e.getMessage());
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
				throw new DaoException("getItem" + e.getMessage());
			}
		}
		return item; // item may be null 
	}

	/**
	 * add an item to the inventory
	 * @param item The item object
	 * @throws DaoException
	 * @return true if item added, false if not
	 */
	public boolean addItem(Item item) throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean result = false;
		try {
			con = this.getConnection();

			String query = "INSERT INTO INVENTORY(ITEMID, ITEM_NAME, ITEM_DESC, ITEM_PRICE, ITEM_QUANTITY, ITEM_CATEGORY, ITEM_SUPPLIER) VALUES (?,?,?,?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setInt(1,item.getItemId());
			ps.setString(2, item.getItemName());
			ps.setString(3, item.getItemDesc());
			ps.setInt(4, item.getItemPrice());
			ps.setInt(5, item.getItemQuantity());
			ps.setString(6, item.getItemCategory());
			ps.setString(7, item.getItemSupplier());

			int rows = ps.executeUpdate();
			if (rows > 0) {
				result = true;
			}
		} catch (SQLException e) {
			throw new DaoException("addItem " + e.getMessage());
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					freeConnection(con);
				}
			} catch (SQLException e) {
				throw new DaoException("addItem " + e.getMessage());
			}
		}
		return result;
	}



	/**
	 * delete an item in the inventory
	 * @param itemId the id of the item to delete
	 * @return true if item deleted, false if not
	 * @throws DaoException
	 */
	public boolean deleteItem(int itemId) throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean result = false;
		try {
			con = this.getConnection();

			String query = "DELETE FROM INVENTORY WHERE ITEMID = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, itemId);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				result = true;
			}
		} catch (SQLException e) {
			throw new DaoException("deleteItem " + e.getMessage());
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					freeConnection(con);
				}
			} catch (SQLException e) {
				throw new DaoException("deleteItem " + e.getMessage());
			}
		}
		return result;
	}

	/**
	 * update an item in the inventory
	 * @return true if item updated, false if not
	 * @throws DaoException
	 */
	public boolean updateItem(Item item) throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean result = false;
		try {
			con = this.getConnection();

			String query = "UPDATE INVENTORY SET ITEM_NAME = ?, ITEM_DESC = ?, ITEM_PRICE = ?, ITEM_QUANTITY = ?, ITEM_CATEGORY = ?, ITEM_SUPPLIER = ? WHERE ITEMID = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, item.getItemName());
			ps.setString(2, item.getItemDesc());
			ps.setInt(3, item.getItemPrice());
			ps.setInt(4, item.getItemQuantity());
			ps.setString(5, item.getItemCategory());
			ps.setString(6, item.getItemSupplier());
			ps.setInt(7, item.getItemId());

			int rows = ps.executeUpdate();
			if (rows > 0) {
				result = true;
			}
		} catch (SQLException e) {
			throw new DaoException("updateItem " + e.getMessage());
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					freeConnection(con);
				}
			} catch (SQLException e) {
				throw new DaoException("updateItem " + e.getMessage());
			}
		}
		return result;
	}

	/**
	 * get the max id of the items and return it
	 * @return the max id of the items
	 * @throws DaoException
	 */
	public int getMaxItemId() throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int maxId = 0;
		try {
			con = this.getConnection();

			String query = "SELECT MAX(ITEMID) FROM INVENTORY";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if (rs.next()) {
				maxId = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new DaoException("getMaxItemId " + e.getMessage());
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
				throw new DaoException("getMaxItemId " + e.getMessage());
			}
		}
		return maxId;
	}
}