package com.revature.respositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import com.revature.models.AuthorId;
import com.revature.models.Employee;
import com.revature.models.EmployeeInfo;
import com.revature.models.Picture;
import com.revature.models.ReimburseR;
import com.revature.models.Request;
import com.revature.models.Update;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);

	public boolean insert(Employee e) {
		
		
		PreparedStatement stmt = null;
		
		try {
			
			Connection conn = ConnectionUtil.getConnection();
			String sql = "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) " + 
							"VALUES (?, ?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, e.getUsername());
			stmt.setString(2, e.getPassword());
			stmt.setString(3, e.getFirstName());
			stmt.setString(4, e.getLastName());
			stmt.setString(5, e.geteMail());
			stmt.setInt(6, e.getUserRole());
			
			if (!stmt.execute()) {
				return false;
			}
				
			
		} catch (SQLException ex) {
			log.warn("Unable to inser user", ex);
			return false;
		} 
		
		return true;
	}

	public boolean update(Employee e) {
		
		return false;
	}

	public List<Employee> findAll() {
		
		List<Employee> list = new ArrayList<Employee>();
		
		try {
			
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ers_users";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("ers_users_id");
				String username = rs.getString("ers_username");
				String password = rs.getString("ers_password");
				String firstName = rs.getString("user_first_name");
				String lastName = rs.getString("user_last_name");
				String eMail = rs.getString("user_email");
				int userRole = rs.getInt("user_role_id");
				
				Employee e = new Employee(id, username, password, firstName, lastName, eMail, userRole);
				list.add(e);
				
			}
			
		
				
			
		} catch (SQLException ex) {
			log.warn("Unable to retrieve all users", ex);
		
		} 
		
		return list;
	}

	@Override
	public int createRequest(Request request) throws SQLException {
		int count = 0;
		try  {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO brocktone.ers_reimbursement (reimb_amount, reimb_description, reimb_submitted, reimb_author, reimb_status_id, reimb_type_id) "
					+ "VALUES (?, ?, current_timestamp, ?, 1, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setDouble(1, request.getAmount());
			preparedStatement.setString(2, request.getDescription());
			preparedStatement.setInt(3, request.getAuthor());
			preparedStatement.setInt(4, request.getType());

			count = preparedStatement.executeUpdate();
		} catch (SQLException  e) {
			
		}
		return count;
	}
	
	@Override
	public List<ReimburseR> findAllR(int authorId) {
List<ReimburseR> list = new ArrayList<ReimburseR>();
		
		try {
			
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = 1 AND reimb_author = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, authorId);
			ResultSet rs = stmt.executeQuery();
			 
			while(rs.next()) {
				int id = rs.getInt("reimb_id");
				double amount  = rs.getDouble("reimb_amount");
				String submitted = rs.getString("reimb_submitted");
				String resolved = rs.getString("reimb_resolved");
				String description = rs.getString("reimb_description");
				int author = rs.getInt("reimb_author");
				int resolver = rs.getInt("reimb_resolver");
				int status = rs.getInt("reimb_status_id");
				int type = rs.getInt("reimb_type_id");
				
				ReimburseR r = new ReimburseR(id, amount, submitted, resolved, description, author, resolver, status, type);
				list.add(r);
				
				System.out.println(r);
				
				
			}
		
		
	} catch (SQLException e) {
		log.warn(e);
	}
		
	return list;
	}
	

	
	
	

	

@Override
public List<ReimburseR> findAllresolved(int authorId) {
List<ReimburseR> list = new ArrayList<ReimburseR>();
	
	try {
		
		Connection conn = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = 2 AND reimb_author = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, authorId);
		ResultSet rs = stmt.executeQuery();
		 
		while (rs.next()) {
			int id = rs.getInt("reimb_id");
			double amount  = rs.getDouble("reimb_amount");
			String submitted = rs.getString("reimb_submitted");
			String resolved = rs.getString("reimb_resolved");
			String description = rs.getString("reimb_description");
			int author = rs.getInt("reimb_author");
			int resolver = rs.getInt("reimb_resolver");
			int status = rs.getInt("reimb_status_id");
			int type = rs.getInt("reimb_type_id");
			
			ReimburseR r = new ReimburseR(id, amount, submitted, resolved, description, author, resolver, status, type);
			list.add(r);
			
			System.out.println(r);
			
			
		}
	
	
} catch (SQLException e) {
	log.warn(e);
}
	
return list;
}



@Override
public int createUpdate(Update update) throws SQLException {
	int count = 0;
	try  {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "UPDATE brocktone.ers_users SET ers_username = ?, ers_password = ?, user_first_name = ?, user_last_name = ?, user_email= ? WHERE ers_users_id = ?";
				
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, update.getUsername());
		preparedStatement.setString(2, update.getPassword());
		preparedStatement.setString(3, update.getFirstName());
		preparedStatement.setString(4, update.getLastName());
		preparedStatement.setString(5, update.getEmail());
		preparedStatement.setInt(6, update.getId());

		count = preparedStatement.executeUpdate();
	} catch (SQLException  e) {
		
	}
	return count;
}




@Override
public EmployeeInfo getInfo(int authorId)  {
	EmployeeInfo employeeInfo = null;
	try (Connection connection = ConnectionUtil.getConnection()) {

		String sql = "SELECT ers_users_id, ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id FROM brocktone.ers_users WHERE ers_users_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, authorId);
		ResultSet rs = preparedStatement.executeQuery();

		if (rs.next()) {
			employeeInfo = new EmployeeInfo();
			employeeInfo.setId(rs.getInt("ers_users_id"));
			employeeInfo.setUsername(rs.getString("ers_username"));
			employeeInfo.setPassword(rs.getString("ers_password"));
			employeeInfo.setFirstName(rs.getString("user_first_name"));
			employeeInfo.setLastName(rs.getString("user_last_name"));
			employeeInfo.seteMail(rs.getString("user_email"));
			employeeInfo.setUserRole(rs.getInt("user_role_id"));
			
		} else {
		//	throw new AccountNotFoundException("Account Number: " + accountNumber + "was not found");
		}

	} catch (SQLException e ) {
		
	}

	return employeeInfo;


}

@Override
public int createPicture(Picture picture) throws SQLException {
	int count = 0;
	try  {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "INSERT INTO brocktone.ers_reimbursement (reimb_receipt)"
				+ "VALUES (?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setBytes(1, picture.getPicture());

		count = preparedStatement.executeUpdate();
		
		
	} catch (SQLException  e) {
		
	}
	return count;
}


}









