package dynamic_amazon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicDeleteApp {

public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the column id");
		int id = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon","root","root");
			
			PreparedStatement ps = c.prepareStatement("delete from product where id=?");
			
			ps.setInt(1,id);
			
			int res = ps.executeUpdate();
			System.out.println(res+" : Row deleted");
			
			ps.close();
			c.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
	}
}
