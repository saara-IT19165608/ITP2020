package com.itp.service;
import com.itp.model.Order;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;


public interface IOrderService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IOrderService.class.getName());


	
	
	public void addOrder(Order order);

	
	 
	public Order getOrderByID(String orderID);
	
	
	
	 
	public ArrayList<Order> getOrders();
	

	 
	public Order updateOrder(String orderID, Order order);

	
	 
	public void removeOrder(String orderID);

}


