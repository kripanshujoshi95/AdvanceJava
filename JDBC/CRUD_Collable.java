package JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class CRUD_Collable {
	
	public static void main(String[] args) throws Exception {
	        // testCount();	
	         testDelete();
		
	}    
	    private static void testDelete() throws Exception {
	    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/engineer","root","root");
	    	
	    	CallableStatement cs = conn.prepareCall("{CALL DELETE(?)}");   // CALL (storedprocedure name)
	    	
	    	cs.registerOutParameter(1, Types.INTEGER);
	    	
	    	cs.execute();
	                                                             
	    	                                                       //or//       // int count= cs.getInt(1);
	    	System.out.println("delete :"+ cs.getInt(1));                        // System.out.println("count :"+ count);
	    	
	    	
		
	}
		private static void testCount() throws Exception {
		
	   Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/engineer","root","root");
		
		CallableStatement cs = conn.prepareCall("{CALL coll(?)}");   // CALL (storedprocedure name)
		
		cs.registerOutParameter(1, Types.INTEGER);
		
		cs.execute();
	                                                         
		                                                       //or//       // int count= cs.getInt(1);
		System.out.println("count :"+ cs.getInt(1));                        // System.out.println("count :"+ count);
		
	
	
		
	}
	
	
	 

	
	

}
