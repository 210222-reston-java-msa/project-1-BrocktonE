package com.revature.respositories;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.AuthorId;
import com.revature.models.Employee;
import com.revature.models.EmployeeInfo;
import com.revature.models.Picture;
import com.revature.models.ReimburseR;
import com.revature.models.Request;
import com.revature.models.Update;

public interface EmployeeDAO {
	
	public boolean insert(Employee e);
	//returns true if sucessfully inserted
	public boolean update(Employee e);
	
	public List<Employee> findAll();
	
	public List<ReimburseR> findAllR(int authorId);
	
	public List<ReimburseR> findAllresolved(int authorId);
	
	public int createRequest(Request request) throws SQLException;
	
	public int createUpdate(Update update) throws SQLException;
	
	public EmployeeInfo getInfo(int id);
	
	public int createPicture(Picture picture) throws SQLException;

}
