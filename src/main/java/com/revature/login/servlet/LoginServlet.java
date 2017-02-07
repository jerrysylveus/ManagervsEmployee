package com.revature.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojo.UserPojo;
import com.revature.userDao.DaoFunctions;

@MultipartConfig
@WebServlet("/Login")


public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Testing - GET");
		//super.doGet(req, resp);
		
	}

	
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

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("we got a hit");
		// lets read the file 
		//FileItem
		
		/*ServletContext context = getServletContext();
		req.getParts();
		for (javax.servlet.http.Part part : req.getParts()) {
			
			String file = extractFileName(part);
			System.out.println(file);
			
		}*/
		
		String usname = req.getParameter("username");
        String pass = req.getParameter("password");
        String id = req.getParameter("id");
        PrintWriter out = resp.getWriter();
        
       // HttpSession session = req.getSession();
       int status;
        UserPojo user = null;
       
        DaoFunctions daoUser = new DaoFunctions();
        user = daoUser.loggingIn(usname, pass);
         
		if(user != null){
			if(user.getUserRolesId() == 1){
					req.getSession().setAttribute("user", user);
					req.getSession().setAttribute("id", id);
					resp.sendRedirect("managerLogin.jsp");
				}
			
			else if(user.getUserRolesId() == 2){
					//req.getSession.setAttribiute("authState", new object())
					req.getSession().setAttribute("user", user);
					req.getSession().setAttribute("id", id);
					resp.sendRedirect("employeeLogin.jsp");
				}
			/*else if(user.getU_id() == user.getU_id()){
				daoUser.EmployeeViewOwnRecords(user);
				req.getSession().setAttribute("user", user);
				resp.sendRedirect("OwnRecords.jsp" + user);
				out.println("Welcome");
			}
			else if(user.getU_id() == user.getU_id()){
				user = daoUser.getEmployeeById(Integer.parseInt(id));
				//req.getSession().setAttribute("user", user);
				req.getSession().setAttribute("user", user);
				resp.sendRedirect("editForm.jsp");/*
					/*if(user.getU_id() == user.getU_id()){
						status = daoUser.employeeUpdate(user);
						req.getSession().setAttribute("user", user);
						resp.sendRedirect("OwnRecords.jsp");*/
						
					//}
			
				
			}
			/*else if( user == user.getU_id()){
				daoUser.employeeUpdate(user);
				req.getSession().setAttribute("user", user);
				resp.sendRedirect("OwnRecords.jsp");
			}*/
		//}
		else{
		
			System.out.println("Redirecting to login.jsp");
			resp.sendRedirect("Login.jsp");
			//req.setAttribute("error", "Unknown user, please try again");
            //req.getRequestDispatcher("/Login.jsp").forward(req, resp);
		}
       
	}


	
	
	 
	
	
	
	
	
}
