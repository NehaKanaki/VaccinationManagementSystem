package com.cears.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import com.cears.service.*;

public class DatabaseConnectivity {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/vmsdatabase";
    private static String user = "root";
    private static String pwd = "root2004";
    
    private static String INSERT_QUERY = "insert into registration values(null,?,?,?,?,?,?,?,?,?)";
   
    public int insert(ArrayList list) {
    int recordCount=0;
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
                insert.setString(7, (String) list.get(6));
                insert.setString(8, (String) list.get(7));
                insert.setString(9,(String) list.get(8) );
                recordCount = insert.executeUpdate();

}catch (ClassNotFoundException e) {
    e.printStackTrace();
} catch (SQLException e) {
    e.printStackTrace();
} catch (Exception e) {
    e.printStackTrace();
}
    return  recordCount;
    }
}