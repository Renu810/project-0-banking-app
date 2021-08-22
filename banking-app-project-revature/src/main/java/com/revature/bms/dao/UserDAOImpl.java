package com.revature.bms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bms.model.User;
import com.revature.bms.util.DBConnection;


public class UserDAOImpl implements UserDAO{

	Connection connection = DBConnection.getDBConnection();


public boolean validateUser(User user)
{   

	
		
		try {
			PreparedStatement statement = connection.prepareStatement("select * from hr.userdata where username = ? and password = ?");
			statement.setString(1,user.getUserName());
			statement.setLong(2,user.getPassword());
			 ResultSet res = statement.executeQuery();
			 System.out.println(res.next());
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
//		ResultSet res = null;
//		try {
//			if(res.next())
//			{
//				//user is valid
//				return true;
//			}
//			else
//			{
//				//user is invalid
//				return false;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
	

	
	}
}
