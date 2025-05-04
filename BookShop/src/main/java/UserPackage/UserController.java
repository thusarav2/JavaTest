package UserPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BookShopPackage.BookModel;
import BookShopPackage.DBConnection;

public class UserController {
	//Connect DB
		private static boolean isSuccess;
		private static Connection con = null;
		private static Statement stmt = null;
		private static ResultSet rs = null;
		
		//User registered data ---> insert function
		public static boolean insertdata(String name, String gmail, String password, String phone) {
			boolean isSuccess = false;
			try {
				//DB connection call
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				
				//SQL Query
				String sql = "insert into user values(0, '"+name+"', '"+gmail+"', '"+password+"', '"+phone+"')";
				int rs = stmt.executeUpdate(sql);
				if(rs > 0) {
					isSuccess = true;
				}
				else {
					isSuccess = false;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return isSuccess;
		}
		
		//Login Validation
		public static List<UserModel> loginValidate(String gmail, String password) {
	        ArrayList<UserModel> user = new ArrayList<>();
	        try {
	            // DB connection call
	            con = DBConnection.getConnection();
	            stmt = con.createStatement();

	            // Corrected SQL Query with AND to combine conditions
	            String sql = "select * from user where gmail='" + gmail + "' and password='" + password + "'";
	            rs = stmt.executeQuery(sql);  // Using executeQuery to retrieve data
	            
	            if (rs.next()) {
	                int id = rs.getInt(1);
	                String name = rs.getString(2);
	                String gmailR = rs.getString(3); // Renamed to avoid shadowing
	                String passwordR = rs.getString(4); // Renamed to avoid shadowing
	                String phone = rs.getString(5);

	                UserModel u = new UserModel(id, name, gmailR, passwordR, phone);
	                user.add(u);
	            }
	        } catch (Exception e) {
	            e.printStackTrace(); 
	        }
	        return user;
	    }
		
		//display user data function
		public static List<UserModel> userProfile(String ID){
			
			int convertID = Integer.parseInt(ID);
			ArrayList<UserModel> user = new ArrayList<>();
			
			 try {
				 // DB connection call
				 con = DBConnection.getConnection();
				 stmt = con.createStatement();
				 
				 String sql = "select * from user where id='"+convertID+"'";
				 rs = stmt.executeQuery(sql);

		            if (rs.next()) {
		                int id = rs.getInt(1);
		                String name = rs.getString(2);
		                String gmailR = rs.getString(3); // Renamed to avoid shadowing
		                String passwordR = rs.getString(4); // Renamed to avoid shadowing
		                String phone = rs.getString(5);

		                UserModel u = new UserModel(id, name, gmailR, passwordR, phone);
		                user.add(u);
		            }
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
			 return user;
		}
		
		//User profile update
		public static boolean updateProfile(String id,String name, String gmail, String password, String phone) {
			try {
				//DB connection call
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				
				//Sql query
				String sql = "update user set name='"+name+"', phone='"+gmail+"', password='"+password+"', phone='"+phone+"'"
						+ "where id='"+id+"'";
				int rs = stmt.executeUpdate(sql);
				if(rs > 0) {
					isSuccess = true;
				}
				else {
					isSuccess = false;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return isSuccess;
		}
		
		// GetByID function
		public static List<UserModel> getById(String Id){
			int convertedID  = Integer.parseInt(Id);
			
			ArrayList <UserModel> book = new ArrayList<>();
			
			try {
				//DB connection call
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				
				//Query
				String sql = "select * from user where id = '" + convertedID + "'";
				
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					int id = rs.getInt(1); 
					String name = rs.getString(2); 
					String gmail = rs.getString(3);
					String password = rs.getString(4);
					String phone = rs.getString(5);
					
					UserModel bk = new UserModel(id, name, gmail, password, phone);
					book.add(bk);
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			return book;
		}
		
		//Delete Function
		public static boolean deleteProfile(String id) {
			int convID = Integer.parseInt(id);
			
			try {
				//DB connection call
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				
				String sql = "delete from user where id = '"+convID+"'";
				
				int rs = stmt.executeUpdate(sql);
				if(rs > 0) {
					isSuccess = true;
				}
				else {
					isSuccess = true;
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			return isSuccess;
		}
 }
