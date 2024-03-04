package com.xadmin.usermanagement.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.usermanagement.bean.User;

public class UserDao {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/gymmanagement?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Veen@1234567";
	private String jdbcDriver="com.mysql.jdbc.Driver";
	
	
	private static final String INSERT_USERS_SQL ="INSERT INTO participants"+"(name,age,email,phone,batchname,address)VALUES"+"(?,?,?,?,?,?);";
	
	private static final String SELECT_USER_BY_ID = "select participant_id,name,age,email,phone,batchname,address from participants where participant_id  =?";
	private static final String SELECT_ALL_USERS = "select * from participants";
	private static final String DELETE_USERS_SQL = "delete from participants where participant_id  = ?;";
	private static final String UPDATE_USERS_SQL = "update participants set name = ?,age=?,email= ?,phone=?,batchname=?,address=? where participant_id  = ?;";
	
	public UserDao() {
	 	
	}
	
	protected Connection getConnection()
	{
		Connection connection = null;
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;	
	}
	//insert user
	
	public void insertUser(User user) {
		
		System.out.println("INSERT_USERS_SQL");
		
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getAge());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.setString(5, user.getBatchname());
			preparedStatement.setString(6, user.getAddress());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	
	//select user by id
	
	public User selectUser(int participant_id)
	{
	User user =null;
	//establishing connection
	try (Connection connection =getConnection();
			//create stmt using conn. object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);){
				preparedStatement.setInt(1, participant_id);
				System.out.println(preparedStatement);
				//execute
				ResultSet rs=preparedStatement.executeQuery();
				
				//process Resultset object
				while(rs.next()) { 
					
					String name=rs.getString("name");
					String age=rs.getString("age");
					String email=rs.getString("email");
					String phone=rs.getString("phone");
					//changed
					String batchname=rs.getString("batchname");
					String address=rs.getString("address");
					
					user=new User(participant_id,name,age,email,phone,batchname,address);
				}
				
			}catch (SQLException e) {
				printSQLException(e);
			}
			return user;
	}
	
	//select all users
	
	public List<User> selectAllUsers()
	{
	List <User> users=new ArrayList<>();
	
	//establish connection
	try (Connection connection =getConnection();
			
		//create stmt using conn object
			PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_USERS);){
			System.out.println(preparedStatement);
			//execute query
			ResultSet rs=preparedStatement.executeQuery();
			
			//process resultset
			while(rs.next()) {
				int participant_id =rs.getInt("participant_id");
				String name=rs.getString("name");
				String age=rs.getString("age");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				String batchname=rs.getString("batchname");//changed
				String address=rs.getString("address");
				
				users.add(new User(participant_id,name,age,email,phone,batchname,address));
			}
	}catch (SQLException e) {
		printSQLException(e);
	}
	return users;
	
	}
	
	//update user method
	
	public boolean updateUser(User user)throws SQLException
	{
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			System.out.println("updated USer:"+statement);
			statement.setString(1, user.getName());
			statement.setString(2, user.getAge());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPhone());
			statement.setString(5, user.getBatchname());//changed
			statement.setString(6, user.getAddress());
			statement.setInt(7, user.getParticipant_id());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	//delete user from databse
	
	public boolean deleteUser(int participant_id ) throws SQLException
	{
	boolean rowDeleted;
	try(Connection connection=getConnection();
			PreparedStatement statement =connection.prepareStatement(DELETE_USERS_SQL);){
		statement.setInt(1, participant_id);
		rowDeleted=statement.executeUpdate()>0;
	}
		return rowDeleted;
	}
		
		private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

