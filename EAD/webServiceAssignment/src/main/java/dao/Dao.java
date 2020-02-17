package dao;
import com.restfull.webServiceAssignment.Item;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * This class will deal with the database named as webServicesDatabase
 * @author Kunal
 *
 */
public class Dao {
	Connection con =null;
	/**
	 * constructor is used for JDBC connection setup
	 */
	public Dao()  {
		String url = "jdbc:mysql://localhost:3306/webservicesdatabase";
		String username = "root";
		String password = "kunal";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
	
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}	
	/**
	 * This function gets a particular item from the database 
	 * @param name
	 * @return Item object
	 */
	public Item getItemByName(String name) {
		String query = "select * from items where name = "+name;
		Item item = new Item();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				
				item.setName(rs.getString(1));
				item.setQuantity(rs.getInt(2));
			}
		}
		catch(Exception e) {
			
		}
		return item;
	}
	/**
	 * This function returns all the items present in the database
	 * @return List of all items
	 */
	public List<Item> getAllItems() {
		List <Item> items = new ArrayList<Item>();
		String query = "select * from items";
		try {
			System.out.println("conn = "+con.isClosed());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("result set "+rs);
			while(rs.next()) {
				Item item = new Item();
				System.out.println("hello item:"+rs.getString(1));
				item.setName(rs.getString(1));
				item.setQuantity(rs.getInt(2));
				System.out.println(item);
				items.add(item);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(items);
		return items;
	}
	
	/**
	 * This function delete a particular item by its name
	 * @param name
	 */
	public void deleteItem(String name) {
		String query = "delete from items where name = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,name);
			pstmt.executeUpdate();
			}
		catch(Exception e) {
		System.out.println(e.getStackTrace());
		}
	}
	/**
	 * this function deletes all the items from the database
	 */
	public void deleteAllItem() {
		String query = "truncate table items";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();
			}
		catch(Exception e) {
		System.out.println(e.getStackTrace());
		}
	}
	/**
	 * This function updates a particular item in the database with the specified item
	 * @param item
	 */
	public void updateItem(Item item,String name) {
		String query = "update items set name=?,quantity=? where name=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, item.getName());
			pstmt.setInt(2, item.getQuantity());
			pstmt.setString(3, name);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());	
		}
	}
	
	/**
	 * this function will update the whole items by a new items array
	 * @param item
	 */
	public void updateAllItem(ArrayList<Item> item) {
		int index = 0;
		try {
			deleteAllItem();
		    while(!item.isEmpty()) {
		    	Item i= item.get(index++);
		    	addNewItem(i);
		    }
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}	
	
	/**
	 * This function will add an item to the database
	 * @param item
	 */
	public void addNewItem(Item item) {
		String query = "insert into items values(?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, item.getName());
			pstmt.setInt(2, item.getQuantity());
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			
		}
	} 
}
