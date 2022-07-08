package MarksheetModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarksheetModel {
	
	
	public Integer nextPk() throws Exception {
		
		int pk = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Marksheetmodel","root","root");
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			pk = rs.getInt(1);

		}
		return pk + 1 ;
		
	}
	
	public void add(MarksheetBean bean) throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("in.com.Bundle.System");   //package.tablename
		
		//System.out.println(rb.getString("Driver"));

		Class.forName(rb.getString("Driver")).newInstance();
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),rb.getString("password"));
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("Insert into marksheet values(?,?,?,?,?,?,?)");
		ps.setInt(1, nextPk());
		ps.setString(2, bean.getRollno());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setInt(5, bean.getPhysics());
		ps.setInt(6, bean.getChemistry());
		ps.setInt(7, bean.getMaths());

		int i = ps.executeUpdate();
		System.out.println("Inserted : " + i);
		
		conn.commit();
		ps.close();
		conn.close();
	}
	
	public void update(MarksheetBean bean) throws Exception {
		
		ResourceBundle rb = ResourceBundle.getBundle("in.com.Bundle.System");
				
		Class.forName(rb.getString("Driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("password"));
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("update marksheet set Rollno=?, FName=?, Lname=?, Physics=?, Chemistry=?, Maths=? where id=?");
		
		ps.setString(1, bean.getRollno());
		ps.setString(2, bean.getFname());
		ps.setString(3, bean.getLname());
		ps.setInt(4, bean.getPhysics());
		ps.setInt(5, bean.getChemistry());
		ps.setInt(6, bean.getMaths());
		ps.setInt(7, bean.getId());
		
		int i = ps.executeUpdate();
		conn.commit();
		System.out.println(i + ":Record Updated");
		ps.close();
		conn.close();
	}
	
	public void Delete(MarksheetBean bean) throws Exception {
		
		ResourceBundle rb= ResourceBundle.getBundle("in.com.Bundle.System");
		
		Class.forName(rb.getString("Driver"));
		
		Connection conn =DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("password"));
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("delete from marksheet where rollno=?");
		
		ps.setString(1, bean.getRollno());
		
		int d= ps.executeUpdate();
		
		conn.commit();
		
		System.out.println(d+ "DELETED");
		
		conn.close();
	    ps.close();
		
		}
	

	public List<MarksheetBean> Get(MarksheetBean bean) throws Exception{
		
		ResourceBundle rb = ResourceBundle.getBundle("in.com.Bundle.System");
		
		Class.forName(rb.getString("Driver"));
		
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),rb.getString("password"));
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("select * from marksheet where Rollno=?");
		
		ps.setString(1, bean.getRollno());
		
	    ResultSet rs = ps.executeQuery();
	    
	    ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();
	    
	    while(rs.next()) {
	    	
	    MarksheetBean bean1 = new MarksheetBean();
	    bean1.setId(rs.getInt(1));
	    bean1.setRollno(rs.getString(2));
	    bean1.setFname(rs.getString(3));
		bean1.setLname(rs.getString(4));
		bean1.setPhysics(rs.getInt(5));
		bean1.setChemistry(rs.getInt(6));
		bean1.setMaths(rs.getInt(7));
	     
	    list.add(bean1);
	    
	    	
	    }
		return list;
		
	}
	
	public List<MarksheetBean> search() throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("in.com.Bundle.System");
		Class.forName(rb.getString("Driver")).newInstance();
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("password"));

		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("select * from marksheet");
		ResultSet rs = ps.executeQuery();
		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();
		while (rs.next()) {

			MarksheetBean bean1 = new MarksheetBean();
			bean1.setId(rs.getInt(1));
			bean1.setRollno(rs.getString(2));
			bean1.setFname(rs.getString(3));
			bean1.setLname(rs.getString(4));
			bean1.setPhysics(rs.getInt(5));
			bean1.setChemistry(rs.getInt(6));
			bean1.setMaths(rs.getInt(7));
			list.add(bean1);
		}
		return list;
	}
	
	public List<MarksheetBean> MeritList() throws Exception{
		
		ResourceBundle rb = ResourceBundle.getBundle("in.com.Bundle.System");
		
		Class.forName(rb.getString("Driver"));
		Connection conn =DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("password"));
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("select *,  ((physics + chemistry + maths)/3) as percentage from marksheet where (physics > 40 AND chemistry> 40 AND Maths > 40) order by (physics + chemistry + maths) desc");
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();
		
		while(rs.next()) {
			
			MarksheetBean bean1 = new MarksheetBean();
			bean1.setId(rs.getInt(1));
			bean1.setRollno(rs.getString(2));
			bean1.setFname(rs.getString(3));
			bean1.setLname(rs.getString(4));
			bean1.setPhysics(rs.getInt(5));
			bean1.setChemistry(rs.getInt(6));
			bean1.setMaths(rs.getInt(7));
			list.add(bean1);
			
		}
		return list;
	}
	
}