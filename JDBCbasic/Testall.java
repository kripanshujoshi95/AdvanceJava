package JDBCbasic;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class Testall {
	public static void main(String[] args) throws Exception {
		testSelect();
		// testInsert();
	   // testUpdate();
		 //testDelete();
		//testget();
	}

	private static void testget() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assig", "root", "root");
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from marksheet where Id=2");

		while (rs.next()) {

			System.out.println(rs.getString("ID"));
			System.out.println(rs.getString("RollNo"));
			System.out.println(rs.getString("FName"));
			System.out.println(rs.getString("LName"));
			System.out.println(rs.getString("Physics"));
			System.out.println(rs.getString("Chemistry"));
			System.out.println(rs.getString("Maths"));

		}
	}

	private static void testDelete() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assig", "root", "root");
		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("delete from Marksheet where id=12");
		System.out.println(i + " :RecordDeleted");

	}

	private static void testUpdate() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assig", "root", "root");
		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("update marksheet set Rollno='127' ,fname='saloni' where id=10");
		System.out.println(i + " :RecordUpdated");

	}

	private static void testInsert() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assig", "root", "root");
		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into Marksheet values (12,112,'neha','sharma',89,90,78)");
		System.out.println(i + "RecordInserted");

	}

	private static void testSelect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assig", "root", "root");
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from Marksheet");

		while (rs.next()) {

			System.out.print("\t" + rs.getString("ID"));
			System.out.print("\t" + rs.getString("RollNo"));
			System.out.print("\t" + rs.getString("FName"));
			System.out.print("\t" + rs.getString("LName"));
			System.out.print("\t" + rs.getString("Physics"));
			System.out.print("\t" + rs.getString("Chemistry"));
			System.out.println("\t" + rs.getString("Maths"));

		}
		stmt.close();
		rs.close();
		conn.close();

	}

}
