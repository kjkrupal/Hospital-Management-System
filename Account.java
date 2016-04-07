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
	
	public boolean checkLoginAdmin(String email, String password) throws Exception{
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
		if(count == 0)
			return false;
		else 
			return true;

	}
	public boolean checkLoginUser(String email, String password) throws Exception{
		dbConnect();
		
		int count = 0; 
		String sql = "select count(*) as count from user where email = ? AND password = ?"; 
		PreparedStatement pstmt = con.prepareStatement(sql); 
		pstmt.setString(1, email); 
		pstmt.setString(2, password); 
		ResultSet rst = pstmt.executeQuery(); 

		while(rst.next()){
			count = rst.getInt("count");
		} 
		dbClose(); 
		if(count == 0)
			return false;
		else 
			return true;

	}
	public String checkUserRole(String email) throws Exception{
		dbConnect();
		
		String sql = "select role from user where email = ?"; 
		PreparedStatement pstmt = con.prepareStatement(sql); 
		pstmt.setString(1, email);  
		ResultSet rst = pstmt.executeQuery(); 
		String role = "";
		while(rst.next()){
			role = rst.getString(1);
		} 
		dbClose(); 
		return role;

	}
	
	
	
	
	public void dbConnect() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
	    con = DriverManager.getConnection(url+dbname,user,password); 
	} 
	
	public void dbClose() throws SQLException{ 
		con.close();
	}
}
