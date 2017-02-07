package com.revature.userDao;


import java.util.List;

import com.revature.pojo.ReimbursementPojo;
import com.revature.pojo.UserPojo;

public interface UserDao {
	
	public UserPojo loggingIn(String uName, String passw);
	public List<UserPojo> getEmployeeRecords();
	public List<UserPojo> EmployeeViewOwnRecords(UserPojo u);
	//public UserPojo EmployeeviewOwnRecords(int id);
	public UserPojo getEmployeeById(int id);
	public int employeeUpdate(UserPojo u);
	public boolean saveReimbursement(ReimbursementPojo r);
	public List <ReimbursementPojo> getOutstandingReimbursements(int id);
	
	public List <ReimbursementPojo> unprocessedReimbursements();
	

}
