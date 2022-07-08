package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD_Prepared {
	
public static void main(String[] args) throws Exception {
	
	     testSelect();
	   //  testInsert();
	    // testUpdate();
	    // testDelete();
	     
	              
	
}



private static void testDelete() throws Exception {
	// TODO Auto-generated method stub
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
	
	PreparedStatement ps = conn.prepareStatement("delete from emp where id=?");

	ps.setInt(1, 3);
	
	int y= ps.executeUpdate();
	
	System.out.println(y+"DELETED");
	
	conn.close();
	ps.close();
	
}

private static void testUpdate() throws Exception {
	// TODO Auto-generated method stub

	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
	
	PreparedStatement ps = conn.prepareStatement("update emp set fname=?, lname=? where id=?");
	
    ps.setString(1, "bablu");
    ps.setString(2, "sharma");
    ps.setInt(3, 6);
    
    int e = ps.executeUpdate();
    
    System.out.println(e+"UPDATED");
    
    conn.close();
    ps.close();
    
	
	
}

private static void testInsert() throws Exception {
	// TODO Auto-generated method stub
	

	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
	
	int id=8;
	String fname="rupesh";
	String lname="badole";
	int salary= 25900;
	int dept_id=4;
			
			
	PreparedStatement ps = conn.prepareStatement("insert into emp values (?,?,?,?,?)");
	
	ps.setInt(1, id);
	ps.setString(2, fname);
	ps.setString(3, lname);
	ps.setInt(4, salary);
	ps.setInt(5, 3);
	
	
	int a = ps.executeUpdate();
	
	System.out.println(a+"INSERTED");
	
	conn.close();
	ps.close();
	
}

private static void testSelect() throws Exception {
	// TODO Auto-generated method stub

	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
	
	PreparedStatement ps = conn.prepareStatement("select * from emp");
	
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()) {
		System.out.print(" "+rs.getInt(1));
		System.out.print(" "+rs.getString(2));
		System.out.print(" "+rs.getString(3));
		System.out.print(" "+rs.getInt(4));
		System.out.println(" "+rs.getInt(5));
		
		
		
	}
	conn.close();
	ps.close();
	rs.close();
}

}
