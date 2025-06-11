package dynamic_amazon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicInsertApp {
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the id");
		int id = sc.nextInt();
		
		System.out.println("Enter the name");
		String name = sc.next();
		
		System.out.println("Enter the brand");
		String brand = sc.next();
		
		System.out.println("Enter the price");
		double price = sc.nextDouble();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon","root","root");
			
			PreparedStatement ps = c.prepareStatement("insert into product values(?,?,?,?)");
			
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setString(3,brand);
			ps.setDouble(4,price);
			
			int res = ps.executeUpdate();
			
			System.out.println(res+" : Row inserted");
			
			ps.close();
			c.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
	

