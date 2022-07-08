package MetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetaData {
	
	public static void main(String[] args) throws Exception {
		
		testSelect();
		
		
		
	}

	private static void testSelect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube", "root", "root");
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");

		ResultSetMetaData rsmd = rs.getMetaData();
		
		System.out.println("Catelog Name : "+ rsmd.getCatalogName(1));
		System.out.println("Table Name : "+ rsmd.getTableName(1));
		
		int  columnCount = rsmd.getColumnCount();
		
		System.out.println("Total Columns : "+ columnCount);
		for (int i = 1; i <= columnCount; i++) {
			System.out.println("Column :" +(i));
			System.out.println("Label :"+ rsmd.getColumnLabel(i));
			System.out.println("Name :"+ rsmd.getColumnName(i));
			System.out.println("Type :"+ rsmd.getColumnTypeName(i));
			System.out.println("Size :"+ rsmd.getColumnDisplaySize(i));
			System.out.println("Precision :"+ rsmd.getPrecision(i));
			
			
		}
		
		
	}

}
