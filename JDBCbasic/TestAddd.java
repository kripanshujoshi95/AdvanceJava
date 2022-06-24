package JDBCbasic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestAddd {
	
	public static void main(String[] args) throws Exception {
		
		testAddd();		
			
		}

		private static void testAddd() throws Exception, Exception, Exception {
	
		
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube", "root", "root");
			Statement stmt = conn.createStatement();
			int rs = stmt.executeUpdate("insert into emp value(8,'Shyam','Badole',55216,102)");
			
			
			System.out.print(rs+"record(s)updated");

		}
}
