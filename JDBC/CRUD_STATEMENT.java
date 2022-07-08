package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD_STATEMENT {
	public static void main(String[] args) throws Exception {
		
		//testSelect();
		//testInsert();
		//testUpdate();
		//testDelete();
		testGet();
		
		
		
		
	}

	private static void testGet() throws Exception {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hariom","root","root");
		
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("select * from emp where id=5");
		
		while(rs.next()) {
			
			System.out.print(" "+rs.getInt("id"));
			System.out.print(" "+rs.getString("fname"));
			System.out.print(" "+rs.getString("lname"));
			System.out.print(" "+rs.getInt("salary"));
			System.out.println(" "+rs.getInt("dept_id"));
			
		}
		
		
	}

	private static void testDelete() throws Exception {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hariom","root","root");
		
		Statement st = conn.createStatement();
		
		int w = st.executeUpdate("delete from emp where id=7");
		
		System.out.println(w+"DELETED");
		
	}

	private static void testUpdate() throws Exception {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hariom","root","root");
		
		Statement st = conn.createStatement();
		
		int a = st.executeUpdate("update emp set fname='yash', lname='joshi' where id=5");
		
		System.out.println(a+"UPDATED");
		
		
	}

	private static void testInsert() throws Exception {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hariom","root","root");
		
		Statement st = conn.createStatement();
		
		int i = st.executeUpdate("insert into emp values (9, 'piyush' ,'badole',54000,3)");
		
		System.out.println(i+"INSERTED");
		
		
		
	}

	private static void testSelect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hariom","root","root");
		
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("select * from emp");
		
		while(rs.next()) {
			System.out.print(" "+rs.getInt("id"));
			System.out.print(" "+rs.getString("fname"));
			System.out.print(" "+rs.getString("lname"));
			System.out.print(" "+rs.getInt("salary"));
			System.out.println(" "+rs.getInt("dept_id"));
			}
		
		
		
	}

}
