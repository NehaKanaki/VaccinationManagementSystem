package com.cears.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.cears.service.DashBoard;
public class Booking {
	private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/vmsdatabase";
    private static String user = "root";
    private static String pwd = "root2004";
    
    private static String INSERT_QUERY = "insert into appointment values(?,?,?,?,?,?)";
	
    public void insert(ArrayList list) {
    Connection con = null;
    PreparedStatement insert = null;
    
    try {
        Class.forName(driver);
        con = DriverManager.getConnection(url, user, pwd);
                insert = con.prepareStatement(INSERT_QUERY);
                insert.setString(1,(String) list.get(0));
                insert.setString(2, (String) list.get(1));
                insert.setString(3, (String) list.get(2));
                insert.setString(4, (String) list.get(3));
                insert.setString(5, (String) list.get(4));
                insert.setString(6, (String) list.get(5));
                int res = insert.executeUpdate();

    	}catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
