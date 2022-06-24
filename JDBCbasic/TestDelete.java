package JDBCbasic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {
	public static void main(String[] args) throws Exception {
		
		testdelete();
		
		
		
	}

	private static void testdelete() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","root");
		Statement stmt = conn.createStatement();
		int rs = stmt.executeUpdate("delete from emp where id=7");
		System.out.println(rs+ "record deleted");
		
		
		
		
	}

}
