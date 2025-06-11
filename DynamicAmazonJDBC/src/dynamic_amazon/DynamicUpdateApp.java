package dynamic_amazon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicUpdateApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the value of new column");
		String keyValue = sc.next();

		System.out.println("Enter the column id");
		int id = sc.nextInt();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon", "root", "root");

			PreparedStatement ps = null;

			System.out.println("Select the option");
			System.out.println("Enter 1 for id");
			System.out.println("Enter 2 for name");
			System.out.println("Enter 3 for brand");
			System.out.println("Enter 4 for price");
			int choice = sc.nextInt();

			switch (choice) {

			case 1: {
				ps = c.prepareStatement("update product set id=? where id=?");

				ps.setString(1, keyValue);
				ps.setInt(2, id);

				int res = ps.executeUpdate();
				System.out.println(res + " : Row updated");

				break;
			}

			case 2: {
				ps = c.prepareStatement("update product set name=? where id=?");

				ps.setString(1, keyValue);
				ps.setInt(2, id);

				int res1 = ps.executeUpdate();
				System.out.println(res1 + " : Row updated");

				break;
			}

			case 3: {
				ps = c.prepareStatement("update product set brand=? where id=?");

				ps.setString(1, keyValue);
				ps.setInt(2, id);

				int res11 = ps.executeUpdate();
				System.out.println(res11 + " : Row updated");

				break;
			}

			case 4: {
				ps = c.prepareStatement("update product set price=? where id=?");

				ps.setString(1, keyValue);
				ps.setInt(2, id);

				int res12 = ps.executeUpdate();
				System.out.println(res12 + " : Row updated");

				break;
			}

			default:
				System.out.println("Enter a valid choice number");
				break;
			}

			try {
			ps.close();
			}catch(Exception e) {
				
			}
			c.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
