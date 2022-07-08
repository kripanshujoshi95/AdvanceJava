package Basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Prepared {
	public static void main(String[] args) throws Exception {
		
		//testSelect();
		//testInsert();
		//testUpdate();
		testDelete();
	
		
	}



	private static void testDelete() throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("Basic.app");
		System.out.println(rb.getString("Driver"));
		Class.forName("Driver");
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),rb.getString("Password"));
		
		PreparedStatement ps = conn.prepareStatement("delete from emp where id=?");
		ps.setInt(1, 3);
		
		int i= ps.executeUpdate();
		System.out.println(i+"RECORD DELETE");
		conn.close();
		ps.close();
		
	}

	private static void testUpdate() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/instagram","root","root");
		PreparedStatement ps = conn.prepareStatement("update emp set fname=?, lname=? where id=?");
		ps.setString(1, "Radheshyam");
		ps.setString(2, "Patel");
		ps.setInt(3, 2);
		
		int i = ps.executeUpdate();
		System.out.println(i+"RECORD UPDATED");
		conn.close();
		ps.close();
		
		
	}

	private static void testInsert() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/instagram","root","root");
		    int id = 6;
			String fname = "rohit";
			String lname = "patidar";
			int salary = 52014;
			int dept_id=102;
		
		PreparedStatement ps = conn.prepareStatement("insert into emp values(?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2,fname);
		ps.setString(3, lname);
		ps.setInt(4, salary);
		ps.setInt(5, dept_id);
		
		int i = ps.executeUpdate();
		System.out.println(i+"RECORD INSERTED");
		
		conn.close();
		ps.close();
		
		
	}

	private static void testSelect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/instagram","root","root");
		PreparedStatement ps = conn.prepareStatement("select * from emp");
	    ResultSet rs = ps.executeQuery();
	    
	    while(rs.next()) {
	    System.out.println(rs.getInt(1));
	    System.out.println(rs.getString(2));
	    System.out.println(rs.getString(3));
	    System.out.println(rs.getString(4));
	    System.out.println(rs.getString(5));
	    }
	    conn.close();
	    ps.close();
	    rs.close();	
	}
	
	

}
