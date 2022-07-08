package BatchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class BatchP {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MarksheetModel", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?,?)");
		ps.setInt(1, 10);
		ps.setString(2, "113");
		ps.setString(3, "mohan");
		ps.setString(4, "jain");
		ps.setInt(5, 46);
		ps.setInt(6, 58);
		ps.setInt(7,42);
		
		ps.addBatch();
		
		ps.setInt(1, 11);
		ps.setString(2, "114");
		ps.setString(3, "ayush");
		ps.setString(4, "mehra");
		ps.setInt(5, 66);
		ps.setInt(6, 64);
		ps.setInt(7,74);
		
		ps.addBatch();
	
		System.out.println("Inserted Succesfully");
		

		ps.setInt(1, 12);
		ps.setString(2, "115");
		ps.setString(3, "asmit");
		ps.setString(4, "kumar");
		ps.setInt(5, 30);
		ps.setInt(6, 48);
		ps.setInt(7,28);
		
		ps.addBatch();
		
		int[] d = ps.executeBatch();
		
		System.out.println("Inserted Succesfully");
		
		
		
		conn.close();
		
		
		
	}

}
