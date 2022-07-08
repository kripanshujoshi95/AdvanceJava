package Dcp;

import java.beans.PropertyVetoException;
import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class Jdbc_DataSource {

	private static Jdbc_DataSource jds=null;
	
	private ComboPooledDataSource ds = null;
	
	public Jdbc_DataSource() throws Exception {
		
		ds=new ComboPooledDataSource();
		
		ds.setDriverClass("com.mysql.jdbc.Driver");
		
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/Marksheet");
		
		ds.setUser("root");
		
		ds.setPassword("root");
		
		ds.setInitialPoolSize(1);
		
		ds.setAcquireIncrement(1);
		
		ds.setMaxPoolSize(5);
		
		}
	
	public static Jdbc_DataSource getInstance() throws Exception {
		
		if (jds==null) {
			jds= new Jdbc_DataSource();
		}
		return jds;
		
	}
	
	public  static Connection getConnection() throws Exception {
		return getInstance().getConnection();
		
	}
	
	
	
}
