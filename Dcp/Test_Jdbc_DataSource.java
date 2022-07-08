package Dcp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test_Jdbc_DataSource {
	
	public static void main(String[] args) throws Exception {
		
		
		
		select();
	}

	private static void select() throws Exception {
		// TODO Auto-generated method stub
		
		String s = "select roolno, Name from marksheet";
		
		Connection conn = Jdbc_DataSource.getConnection();
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(s);
		
		System.out.println("db pool connection");
		System.out.println("rollno,Name");
		
		while (rs.next()) {
			System.out.println("\t " + rs.getInt(1));
			System.out.println("\\t " + rs.getString(2));
			System.out.println( " ***************** wooooooooohhhooooooo ");
			}

	}

}
