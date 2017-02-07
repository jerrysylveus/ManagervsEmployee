package com.revature.login.servlet;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)
public class FileUploadDB extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	static{
        try {
            Class.forName ("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	
	//@Override
	
		
		  // database connection settings
	    private final String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
	    private final String dbUser = "managervsemployee_db";
	    private final String dbPass = "p4ssw0rd";
	    
	    /*private final static String url = "jdbc:oracle:thin:@localhost:1521:xe";
		private final static String username = "managervsemployee_db";
		private final static String password = "p4ssw0rd";*/
	     
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // gets values of text fields
	        double amount = Double.parseDouble(request.getParameter("amount"));
	        String description = request.getParameter("description");
	       int authorid = Integer.parseInt(request.getParameter("authorid"));
	       int typeid = Integer.parseInt(request.getParameter("typeid"));
	       String timeSubmitted = request.getParameter("timeSubmitted");
	         
	        InputStream inputStream = null; // input stream of the upload file
	         
	        // obtains the upload file part in this multipart request
	        Part filePart = request.getPart("photo");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	        }
	         
	        Connection conn = null; // connection to the database
	        String message = null;  // message will be sent back to client
	         
	        //try {
	            // connects to the database
	        	try(Connection conn1 = DriverManager.getConnection(dbURL,dbUser,dbPass);){
	           // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	            //conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
	 
	            // constructs SQL statement
	            String sql = "INSERT INTO ERS_REIMBURSEMENTS(R_AMOUNT, R_DESCRIPTION, R_RECEIPT, R_SUBMITTED,"
	            		+ " U_ID_AUTHOR, RT_TYPE)VALUES(?,?,?,?,?,?)";
	            PreparedStatement statement = conn1.prepareStatement(sql);
	            statement.setDouble(1, amount);
	            statement.setString(2, description);
	            statement.setInt(4, authorid);
	            statement.setInt(5, typeid);
	            statement.setString(6, timeSubmitted);
	             
	            if (inputStream != null) {
	                // fetches input stream of the upload file for the blob column
	                statement.setBlob(3, inputStream);
	            }
	 
	            // sends the statement to the database server
	            int row = statement.executeUpdate();
	            if (row > 0) {
	                message = "File uploaded and saved into database";
	            }
	        } catch (SQLException ex) {
	            message = "ERROR: " + ex.getMessage();
	            ex.printStackTrace();
	        } finally {
	            if (conn != null) {
	                // closes the database connection
	                try {
	                    conn.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	            // sets the message in request scope
	            request.setAttribute("Message", message);
	             
	            // forwards to the message page
	            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
	        }
	    }
		
		
	}
	
	


