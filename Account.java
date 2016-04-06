package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account{
	String user = "root"; 
	String password="";
	String url="jdbc:mysql://localhost:3306/";
	String dbname="hospital"; 
	String driver="com.mysql.jdbc.Driver";
	Connection con;
	
	public int checkLogin(String email, String password) throws Exception{
		dbConnect();
		
		int count = 0; 
		String sql = "select count(*) as count from admin where email = ? AND password = ?"; 
		PreparedStatement pstmt = con.prepareStatement(sql); 
		pstmt.setString(1, email); 
		pstmt.setString(2, password); 
		ResultSet rst = pstmt.executeQuery(); 

		while(rst.next()){
			count = rst.getInt("count");
		} 
		dbClose(); 
		if(count == 0){
			dbConnect();
			int count1 = 0; 
			String sql1 = "select count(*) as count from user where email = ? AND password = ?"; 
			PreparedStatement pstmt1 = con.prepareStatement(sql1); 
			pstmt1.setString(1, email); 
			pstmt1.setString(2, password); 
			ResultSet rst1 = pstmt.executeQuery(); 

			while(rst1.next()){
				count1 = rst.getInt("count");
			} 
			dbClose();
			if(count1 == 0)
				return 0; 
			else
				
				return 1;
		}
		else 
			return 3;

	}	
	
	
	
	public void dbConnect() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
	    con = DriverManager.getConnection(url+dbname,user,password); 
	} 
	
	public void dbClose() throws SQLException{ 
		con.close();
	}
}
