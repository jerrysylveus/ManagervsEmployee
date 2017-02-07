package com.revature.login.servlet;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Timestamp;
import java.io.*;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

import com.revature.pojo.ReimbursementPojo;
import com.revature.pojo.UserPojo;
import com.revature.userDao.DaoFunctions;
import com.sun.org.apache.xerces.internal.parsers.SAXParser;



@MultipartConfig
@WebServlet("/uploadFile")
public class uploadFile extends HttpServlet {

	/**
	 * 
	 */
	

	private static final long serialVersionUID = 1L;

	/*private String extractFileName(javax.servlet.http.Part part) {
    String contentDisp = part.getHeader("content-disposition");
    String[] items = contentDisp.split(";");
    for (String s : items) {
        if (s.trim().startsWith("filename")) {
            return s.substring(s.indexOf("=") + 2, s.length()-1);
        }
    }
    return "";
}*/
	
	//@Override
	/*protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" ");
		System.out.println("Checking the upload File java");
		
		
		/* ServletInputStream httpIn = req.getInputStream();        
		    byte[] httpInData = new byte[req.getContentLength()];
		    System.out.println("length - " + req.getContentLength());
		    byte[] data = new byte[req.getContentLength()];
            int bytesRead = 0;
            do {
                bytesRead = httpIn.read(data);
            } while (bytesRead > -1);
		
			System.out.println(data);*/
		
			
			//Blob photo = util.getBlobData(req.getParameter("name"));
			  // util.close();
	//}
	/*private int rId;
	private double rAmount;
	private String rDescription;
	//private BLOB rReceipt;
	private String rReceipt;
	//private TIMESTAMP rSubmitted;
	//private TIMESTAMP rResolved;
	private Timestamp rSubmitted;
	private Timestamp rResolved;
	private int u_idAuthor;
	private int u_idResolver;
	private int rtType;
	private int rtStatus;*/
	
	
	 private boolean isMultipart;
	   private String filePath;
	   private int maxFileSize = 50 * 1024;
	   private int maxMemSize = 4 * 1024;
	   private File file;

	   
	   public void doPost(HttpServletRequest request, 
	               HttpServletResponse response)
	              throws ServletException, java.io.IOException {
		   System.out.println("Checking if the doposit is working");
	     
	       
	      isMultipart = ServletFileUpload.isMultipartContent(request);
	      response.setContentType("text/html");
	      java.io.PrintWriter out = response.getWriter( );
	      if( !isMultipart ){
	         out.println("<html>");
	         out.println("<head>");
	         out.println("<title>Servlet upload</title>");  
	         out.println("</head>");
	         out.println("<body>");
	         out.println("<p>No file uploaded</p>"); 
	         out.println("</body>");
	         out.println("</html>");
	         return;
	      }
	      
	      System.out.println("Checking after the multipart");
	      
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	      // maximum size that will be stored in memory
	      factory.setSizeThreshold(maxMemSize);
	      // Location to save data that is larger than maxMemSize.
	      factory.setRepository(new File("c:\\temp"));
	      
	  System.out.println(" checking right after factory.setSizeThresold");
	      // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      // maximum file size to be uploaded.
	      upload.setSizeMax( maxFileSize );
	      
	 System.out.println("Checking after upload.setSizeMax");
	      try{ 
	      // Parse the request to get file items.
	      List fileItems = upload.parseRequest(request);
	    
	      // Process the uploaded file items
	      Iterator i = fileItems.iterator();

	      out.println("<html>");
	      out.println("<head>");
	      out.println("<title>Servlet upload</title>");  
	      out.println("</head>");
	      out.println("<body>");
	      
	      String amount = " ";
	      String description = " ";
	      String rtype = "";
	      
	      
	      while ( i.hasNext () ) 
	      {
	         FileItem fi = (FileItem)i.next();
	         if(fi.isFormField()){
	        	System.out.println("field name = " + fi.getFieldName()); 
	        	if(fi.getFieldName().equals("amt")){
	        		amount = fi.getString();
	        	}
	        	else if(fi.getFieldName().equals("description")){
	        		description = fi.getString();
	        	}
	        	else if(fi.getFieldName().equals("rtype")){
	        		rtype = fi.getString();
	        	}
	         }
	         
	      }
	      i = fileItems.iterator();
	      while ( i.hasNext () ) {
	    	  FileItem fi = (FileItem)i.next();
	          if ( !fi.isFormField () )	
	         {
	            // Get the uploaded file parameters
	            String fieldName = fi.getFieldName();
	            String fileName = fi.getName();
	            String contentType = fi.getContentType();
	            boolean isInMemory = fi.isInMemory();
	            long sizeInBytes = fi.getSize();
	            // Write the file
	            if( fileName.lastIndexOf("\\") >= 0 ){
	               file = new File( filePath + 
	               fileName.substring( fileName.lastIndexOf("\\"))) ;
	            }else{
	               file = new File( filePath + 
	               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
	            }
	            
	            
	            //fi.write( file ) ;
		       System.out.println(" Checking Before fi.getString");
		       String receipt = fi.getString();
		            
		       System.out.println("Checking after fi.getString");
		      int user =((UserPojo)request.getSession().getAttribute("user")).getU_id();
		       System.out.println("user = " + user);
		       
		            
		           //int id = Integer.valueOf(request.getParameter("id"));
		      System.out.println(" Checking After declaring double amount");
		      //String amt = request.getParameter("amt");
		      
		      //System.out.println("amount = " + amt);
		      
		     // double amount = Double.valueOf(request.getParameter("amt"));
		      //double amount = request.getParameter("amount");
		 		   
		 	  System.out.println(" Checking After declaring double amount 2");
		 		
		 		  // String description = request.getParameter("description");
		 	       Timestamp time = new Timestamp(System.currentTimeMillis());
		 	       //int uida = Integer.valueOf(request.getParameter("idAuthor"));
		 	       //int uidr = Integer.valueOf(request.getParameter("u_idResolver"));
		 	       
		 	       //int rtype = Integer.valueOf(request.getParameter("rtype"));
		 	       System.out.println("Creating reimbursement to be saved.");
		 	       
		 	       System.out.println("amount = " + amount);
		 	       
		            ReimbursementPojo r = new ReimbursementPojo( Double.valueOf(amount), description, receipt, time, user, Integer.valueOf(rtype));
		            DaoFunctions userDao = new DaoFunctions();
		            
		            System.out.println("Going to call Reimbursement");
		            userDao.saveReimbursement(r);
	            
	            
	           System.out.println(receipt);
	            out.println("Uploaded Filename: " + fileName + "<br>");
	         }
	      }
	      out.println("</body>");
	      out.println("</html>");
	      }catch(Exception ex) {
	       System.out.println(ex);
	      }
	   }
	   
	   
	   
	   public void doGet(HttpServletRequest request, 
	                       HttpServletResponse response)
	        throws ServletException, java.io.IOException {
	        
	        throw new ServletException("GET method used with " +
	                getClass( ).getName( )+": POST method required.");
	   } 
	
	
	
	
	

}
