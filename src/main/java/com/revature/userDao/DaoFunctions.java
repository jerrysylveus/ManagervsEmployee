package com.revature.userDao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.ReimbursementPojo;
import com.revature.pojo.UserPojo;

public class DaoFunctions implements UserDao {
	
	static{
        try {
            Class.forName ("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	private final static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String username = "managervsemployee_db";
	private final static String password = "p4ssw0rd";
	
	
	
	
	@Override
	public UserPojo loggingIn(String uName, String passw) {
		
		UserPojo user = null;
		try(Connection con = DriverManager.getConnection(url,username,password);){
			//String sqlQuery = "SELECT U_ID, U_USERNAME, U_PASSWORD, U_FIRSTNAME, U_LASTNAME, U_EMAIL, UR_ID FROM ERS_USERS WHERE U_USERNAME = ? AND U_PASSWORD = ?";
			String sqlQuery = "SELECT * FROM ERS_USERS WHERE U_USERNAME = ? AND U_PASSWORD = ?";
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, uName);
			ps.setString(2, passw);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			if(rs.next())
			{
				System.out.println("Your password is correct, you are now logged in.");
				user = new UserPojo(rs.getInt("U_ID"), rs.getString("U_USERNAME"), rs.getString("U_PASSWORD"), rs.getString("U_FIRSTNAME" ),rs.getString("U_LASTNAME"), rs.getString("U_EMAIL"), rs.getInt("UR_ID"));
			}
			else
				System.out.println("Your user name and or password may be invalid.");
			//System.out.println("Please Try Again.");
			System.out.println(" ");
			rs.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.print(user);
		return user;
	
	}




	@Override
	public List<UserPojo> getEmployeeRecords() {
		List<UserPojo> list = new ArrayList<UserPojo>();
		try(Connection con = DriverManager.getConnection(url,username,password);){
			String sqlQuery = "SELECT * FROM ERS_USERS WHERE UR_ID = ?";
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, 2);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				UserPojo u = new UserPojo();
				u.setU_id(rs.getInt("U_ID"));
				u.setU_userName(rs.getString("U_USERNAME"));
				u.setU_password(rs.getString("U_PASSWORD"));
				u.setU_firstName(rs.getString("U_FIRSTNAME"));
				u.setU_lastName(rs.getString("U_LASTNAME"));
				u.setU_email(rs.getString("U_EMAIL"));
				u.setUserRolesId(rs.getInt("UR_ID"));
				list.add(u);
			}
		rs.close();
		con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
	}
		return list;
		
	}




	//@Override
	/*public UserPojo EmployeeviewOwnRecords(int id) {
		UserPojo u = null;
		try(Connection con = DriverManager.getConnection(url,username,password);){
			String sqlQuery = "SELECT * FROM ERS_USERS WHERE UR_ID = ?";
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				u.setU_id(rs.getInt("U_ID"));
				u.setU_userName(rs.getString("U_USERNAME"));
				u.setU_password(rs.getString("U_PASSWORD"));
				u.setU_firstName(rs.getString("U_FIRSTNAME"));
				u.setU_lastName(rs.getString("U_LASTNAME"));
				u.setU_email(rs.getString("U_EMAIL"));
				u.setUserRolesId(rs.getInt("UR_ID"));
				
			}
		rs.close();
		con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
	}
		return u;
	}*/




	@Override
	public List<UserPojo> EmployeeViewOwnRecords(UserPojo u) {
		//UserPojo u = new UserPojo();
		List<UserPojo> list = new ArrayList<UserPojo>();
		try(Connection con = DriverManager.getConnection(url,username,password);){
			String sqlQuery = "SELECT * FROM ERS_USERS WHERE U_ID = ?";
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, u.getU_id());
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				//UserPojo u = new UserPojo();
				u.setU_id(rs.getInt("U_ID"));
				u.setU_userName(rs.getString("U_USERNAME"));
				u.setU_password(rs.getString("U_PASSWORD"));
				u.setU_firstName(rs.getString("U_FIRSTNAME"));
				u.setU_lastName(rs.getString("U_LASTNAME"));
				u.setU_email(rs.getString("U_EMAIL"));
				u.setUserRolesId(rs.getInt("UR_ID"));
				list.add(u);
			}
		rs.close();
		con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
	}
		return list;
		
	}




	@Override
	public UserPojo getEmployeeById(int id) {
		UserPojo u = null;
		try(Connection con = DriverManager.getConnection(url,username,password);){
			String sqlQuery = "SELECT * FROM ERS_USERS WHERE U_ID = ?";
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				u = new UserPojo();
				u.setU_id(rs.getInt("U_ID"));
				u.setU_userName(rs.getString("U_USERNAME"));
				u.setU_password(rs.getString("U_PASSWORD"));
				u.setU_firstName(rs.getString("U_FIRSTNAME"));
				u.setU_lastName(rs.getString("U_LASTNAME"));
				u.setU_email(rs.getString("U_EMAIL"));
				u.setUserRolesId(rs.getInt("UR_ID"));
				
			}
		rs.close();
		con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
	}
		return u;
	}




	@Override
	public int employeeUpdate(UserPojo user) {
		int status = 0;
		//UserPojo user = null;
		System.out.println("employee update here");
		try(Connection con = DriverManager.getConnection(url,username,password);){
			String sqlQuery = "UPDATE ERS_USERS SET U_USERNAME =?, U_PASSWORD = ?, U_FIRSTNAME =? "
					+ ",U_LASTNAME =?, U_EMAIL = ? WHERE U_ID = ?";
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			//ps.setInt(1, user.getU_id());
			ps.setString(1, user.getU_userName());
			ps.setString(2, user.getU_password());
			ps.setString(3, user.getU_firstName());
			ps.setString(4, user.getU_lastName());
			ps.setString(5, user.getU_email());
			ps.setInt(6, user.getU_id());
			status = ps.executeUpdate();
			ResultSet rs = ps.getResultSet();
			System.out.println(" more employee update here");
					
		//rs.close();
		con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
	}
		return status;
	
		
	}




	@Override
	public boolean saveReimbursement(ReimbursementPojo r) {
		System.out.println("In save reimbursement");
		try(Connection con = DriverManager.getConnection(url,username,password);){
			System.out.println("Saving the Reimbursement ");
			String sqlQuery = "INSERT INTO ERS_REIMBURSEMENTS(R_AMOUNT, R_DESCRIPTION, R_RECEIPT, R_SUBMITTED, R_RESOLVED, U_ID_AUTHOR,  "
					+ "RT_TYPE) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			
			ps.setDouble(1,r.getrAmount());
			ps.setString(2,r.getrDescription());
			
			InputStream stream = new ByteArrayInputStream(r.getrReceipt().getBytes(StandardCharsets.UTF_8));
			ps.setBinaryStream(3, stream, (int) r.getrReceipt().length());
			
			ps.setTimestamp(4, r.getrSubmitted());
			ps.setTimestamp(5, r.getrResolved());
			ps.setInt(6, r.getU_idAuthor());
			ps.setInt(7, r.getRtType());
			
			
			ps.execute();
			
	//rs.close();
			//con.commit();
			con.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(" Save Reimbursement not sucessful ");
			return false;
		}
		System.out.println(" Save Reimbursement Succesful ");
		return true;
	}




	@Override
	public List<ReimbursementPojo> getOutstandingReimbursements(int id) {
	
			//UserPojo u = new UserPojo();
			List<ReimbursementPojo> list = new ArrayList<ReimbursementPojo>();
			try(Connection con = DriverManager.getConnection(url,username,password);){
				String sqlQuery = " SELECT * FROM ERS_REIMBURSEMENTS WHERE RT_STATUS IS NULL AND U_ID_AUTHOR = ?";
				PreparedStatement ps = con.prepareStatement(sqlQuery);
				ps.setInt(1, id);
				ps.executeQuery();
				ResultSet rs = ps.getResultSet();
				while(rs.next()){
					
					//UserPojo u = new UserPojo();
					ReimbursementPojo r = new ReimbursementPojo(rs.getDouble("R_AMOUNT"), rs.getString("R_DESCRIPTION"),
							 "", rs.getTimestamp("R_SUBMITTED"), rs.getInt("U_ID_AUTHOR"), rs.getInt("RT_TYPE"));
					list.add(r);
	
				}
			rs.close();
			con.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
		}
			return list;
			
		}



	
	

	@Override
	public List<ReimbursementPojo> unprocessedReimbursements() {
		List<ReimbursementPojo> list = new ArrayList<ReimbursementPojo>();
		try(Connection con = DriverManager.getConnection(url,username,password);){
			String sqlQuery = " SELECT R_ID, R_AMOUNT, R_DESCRIPTION, utl_raw.cast_to_varchar2(dbms_lob.substr(R_RECEIPT,3,1)) AS R_RECEIPT,"
					+ " R_SUBMITTED, R_RESOLVED, U_ID_AUTHOR, U_ID_RESOLVER, RT_TYPE, RT_STATUS FROM ERS_REIMBURSEMENTS";

			PreparedStatement ps = con.prepareStatement(sqlQuery);
			
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			Blob lob = null;
			while(rs.next()){
				 /*lob=rs.getBlob("R_RECEIPT");	
				 InputStream in = lob.getBinaryStream();
				   ByteArrayOutputStream out = new ByteArrayOutputStream();*/
				   //OutputStream outputStream = new FileOutputStream("blobImage.png");
				
				//public ReimbursementPojo(int rId, double rAmount, String rDescription, String rReceipt, Timestamp rSubmitted,
				//Timestamp rResolved, int u_idAuthor, int u_idResolver, int rtType, int rtStatus) {
				
				
				//UserPojo u = new UserPojo();
				ReimbursementPojo r = new ReimbursementPojo(rs.getInt("R_ID"), rs.getDouble("R_AMOUNT"), rs.getString("R_DESCRIPTION"),
						 rs.getString("R_RECEIPT"), rs.getTimestamp("R_SUBMITTED"),rs.getTimestamp("R_RESOLVED"), rs.getInt("U_ID_AUTHOR"),rs.getInt("U_ID_RESOLVER"),
						 rs.getInt("RT_TYPE"),rs.getInt("RT_STATUS"));
				list.add(r);
								
			}
		rs.close();
		con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
	}
		return list;
	}
	
	
	
	

	
	
	
}




