package Basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Statements {
	public static void main(String[] args) throws Exception {
		

           // testSelect();
		   // testInsert();
		   // testUpdated();
		      testDelete();
		      
		
		
		
	}

	private static void testDelete() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("delete from emp where id=4");
		System.out.println(i+"RECORD DELETED");
		
	}

	private static void testUpdated() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("update emp set fname='ajay',lname='chouhan'where id =3");
		System.out.println(i+"RECORD UPDATED");
		
	}

	private static void testInsert() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
	Statement stmt = conn.createStatement();
	int i = stmt.executeUpdate("insert into emp values(6, 'raju', 'soni', 68216,2)");
	
	System.out.println(i+"RECORD INSERTED");
	
		
	}

	private static void testSelect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from emp");
		
		while(rs.next()) {
		System.out.print(rs.getInt(1));
		System.out.print(rs.getString(2));
		System.out.print(rs.getString(3));
		System.out.print(rs.getString(4));
		System.out.println(rs.getString(5));
		
	}
	}	
		
	}


