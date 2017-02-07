package com.revature.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojo.UserPojo;
import com.revature.userDao.DaoFunctions;

@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        UserPojo user = new UserPojo(Integer.parseInt(req.getParameter("id")), req.getParameter("username"), req.getParameter("password"), req.getParameter("firstname"), req.getParameter("lastname"), req.getParameter("email"), 2);  
        
       // UserPojo user = new UserPojo(Integer.parseInt(req.getParameter("id")), req.getParameter("email"), req.getParameter("username"), req.getParameter("password"), req.getParameter("firstname"), req.getParameter("lastname"), 2);
        
        DaoFunctions daoUser = new DaoFunctions();
        int status;
        if(user != null){
        	status = daoUser.employeeUpdate(user);
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("OwnRecords.jsp");
        	
        	
        }
	}
	
	
	
	
	
	
	

}
