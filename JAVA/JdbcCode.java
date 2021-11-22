package org.truyum.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

public class JdbcCode {
	static String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
	
	public static boolean storeItems(Items i1) {
		String insert = "insert into truyum.items values(?,?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedstatement = connection.prepareStatement(insert);
			System.out.println("platform created");
			preparedstatement.setString(1, i1.getName());
			preparedstatement.setString(2, i1.getActive());
			preparedstatement.setString(3, i1.getCategory());
			preparedstatement.setString(4, i1.getDateOfLaunch());
			preparedstatement.setString(5, i1.getFreeDelivery());
			preparedstatement.setString(6, i1.getPrice());
			preparedstatement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static List getItems() {
		String insert = "select * from truyum.items";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedstatement = connection.prepareStatement(insert);
			System.out.println("platform created");
			ResultSet resultSet = preparedstatement.executeQuery();
			List<Items> l1 = new ArrayList<Items>();
			while(resultSet.next()) {
				Items i1 = new Items();
				i1.setName(resultSet.getString(1));
				i1.setActive(resultSet.getString(2));
				i1.setCategory(resultSet.getString(3));
				i1.setDateOfLaunch(resultSet.getString(4));
				i1.setFreeDelivery(resultSet.getString(5));
				i1.setPrice(resultSet.getString(6));
				l1.add(i1);
			}
			return l1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean deleteAdminItems(String name) {
		String delete = "delete from truyum.items where name=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedstatement = connection.prepareStatement(delete);
			System.out.println("platform created");
			preparedstatement.setString(1, name);
			preparedstatement.executeUpdate();
			System.out.println("row deleted");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean searchAndStoreItem(String name) {
		String select = "select * from truyum.items where name=?";
		String insert = "insert into truyum.cart values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedstatement = connection.prepareStatement(select);
			System.out.println("platform created");
			preparedstatement.setString(1, name);
			ResultSet set = preparedstatement.executeQuery();
			if(set.next()) {
			System.out.println("row find");
			PreparedStatement preparedstatement1 = connection.prepareStatement(insert);
			System.out.println("platform created");
			preparedstatement1.setString(1, set.getString("Name"));
			preparedstatement1.setString(2, set.getString("freeDelivery"));
			preparedstatement1.setString(3, set.getString("price"));
			preparedstatement1.executeUpdate();
			}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static List getCartItems() {
		String select = "select * from truyum.cart";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedstatement = connection.prepareStatement(select);
			System.out.println("platform created");
			ResultSet resultSet = preparedstatement.executeQuery();
			List<Items> l1 = new ArrayList<Items>();
			while(resultSet.next()) {
				Items i1 = new Items();
				i1.setName(resultSet.getString(1));
				i1.setFreeDelivery(resultSet.getString(2));
				i1.setPrice(resultSet.getString(3));
				l1.add(i1);
			}
			return l1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	public static boolean searchAndDeleteItem(String name) {
		String delete = "delete from truyum.cart where name=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedstatement = connection.prepareStatement(delete);
			System.out.println("platform created");
			preparedstatement.setString(1, name);
			preparedstatement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
