package Basic;
                                                     
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Collable {
	public static void main(String[] args) throws Exception {
		
		testcol();
		
		                                                    //check krna h isse
	}

	private static void testcol() throws Exception {
		
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","root");
			CallableStatement cal = conn.prepareCall("{call empcount(?)}");
			cal.registerOutParameter(1, Types.INTEGER);
			cal.execute();
			System.out.println("empcount"+cal.getInt(1));
			
		}


}
