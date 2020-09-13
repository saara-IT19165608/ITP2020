/*
 * ITP 2020 Textile Management System
 * 
 * @author V. Yahdhursheika - IT19186948
 */

package com.itp.service;

import com.itp.model.Product;
import com.itp.util.DBConnectionUtil;

import java.util.logging.*;
import java.sql.*;

/*
 * This class implements iProductService interface
 * by overriding all of its abstract methods
 */

public class ProductServiceImpl implements iProductService {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ProductServiceImpl.class.getName());
	/*
	 * This method adds a product object to the DB
	 * @override
	 * @param Product object
	 * @return status
	 */
	public int addProduct(Product p) {
		
		/* Setting up the connection*/
		Connection con = DBConnectionUtil.getConnection();
		
		//initializing status variable to get execution status of sql query
		int status = 0;
		
		//Sql query saved inside query
		try {
			String query = "INSERT INTO textilemanagementsystem.Product" +
							"(name, category, qty, size, price, reOrderLevel)" +
							"VALUES(?,?,?,?,?,?)";
			
			/*setting up SQL query with the values by getting the values
				from the product class calling the get methods */
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, p.getProductName());
			ps.setString(2, p.getProductCategory());
			ps.setInt(3, p.getProductQty());
			ps.setString(4, p.getProductSize());
			ps.setDouble(5, p.getProductPrice());
			ps.setInt(6, p.getProductReOrderLevel());
			
			/*Executing the SQL statement and storing the result of
			 * execution in status variable
			 */
			status = ps.executeUpdate();
			
			
		} catch(Exception ex) {
			log.log(Level.SEVERE, ex.getMessage());
			ex.printStackTrace();
		}
		
		return status;
		
	}

}
