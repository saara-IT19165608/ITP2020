package com.itp.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.itp.model.Order;
import com.itp.util.CommonConstants;
import com.itp.util.CommonUtil;
import com.itp.util.DBConnectionUtil;
import com.itp.util.QueryUtil;

public class OrderServiceImpl implements IOrderService {
	

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(OrderServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createOrderTable();
	}

	private PreparedStatement preparedStatement;

	
	public static void createOrderTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			// Create new  table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}


	
	@Override
	public void addOrder(Order order) {

		String orderID = CommonUtil.generateIDs(getOrderIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ORDERS));
			connection.setAutoCommit(false);
			
			//Generate leave IDs
			order.setOrderID(orderID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, order.getOrderID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, order.getProduct());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, order.getQuantity());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR,  order.getSubTotal());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, order.getDiscount());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, order.getTotal());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN,order.getPurchaseDate());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT,order.getStatus());


			// Add order
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	
	  
	 
	@Override
	public Order getOrderByID(String orderID) {

		return actionOnLeave(orderID).get(0);
	}
	
	
	 // Get all list of orders
	
	@Override
	public ArrayList<Order> getOrders() {
		
		return actionOnLeave(null);
	}



	@Override
	public void removeOrder(String orderID) {

		// Before deleting check whether order  ID is available
		if (orderID != null && !orderID.isEmpty()) {
			/*
			 * Remove order query will be retrieved from orderQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_ORDER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, orderID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	// This performs GET order by ID and Display all orders
	
	private ArrayList<Order> actionOnLeave(String orderID) {

		ArrayList<Order> orderList = new ArrayList<Order>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			if (orderID != null && !orderID.isEmpty()) {
				
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ORDER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, orderID);
			}
			
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_ORDERS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Order order = new Order();
				order.setOrderID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				order.setProduct(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				order.setQuantity(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				order.setSubTotal(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				order.setDiscount(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				order.setTotal(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				order.setPurchaseDate(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				order.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				
				orderList.add(order);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return orderList;
	}

	
	 // Get the updated order
	 
	@Override
	public Order updateOrder(String orderID, Order order) {

		
		if (orderID != null && !orderID.isEmpty()) {
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_ORDER));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, order.getProduct());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, order.getQuantity());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, order.getSubTotal());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, order.getDiscount());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, order.getTotal());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, order.PurchaseDate());
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, order.getStatus());
                preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, order.getOrderID());
                preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		
		
		return getOrderByID(orderID);
	}
	
	// returns ArrayList<String> Array of order id list
	
	private ArrayList<String> getOrderIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ORDER_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
}
