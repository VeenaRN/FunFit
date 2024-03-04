package com.xadmin.usermanagement.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.usermanagement.bean.Batch;

public class BatchDao {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/gymmanagement?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Veen@1234567";
	private String jdbcDriver="com.mysql.jdbc.Driver";

	private static final String INSERT_BATCH_SQL ="INSERT INTO batches (batch_name,session_type,instructor,location)VALUES"+"(?,?,?,?);";
	
	private static final String SELECT_BATCH_BY_ID = "select id,batch_name,session_type,instructor,location from batches where id  =?";
	private static final String SELECT_ALL_BATCH = "SELECT * FROM batches";
	private static final String DELETE_BATCH_SQL = "delete from batches where id=?;";
	private static final String UPDATE_BATCH_SQL = "update batches set batch_name = ?,session_type= ?,instructor=?,location=? where id  = ?;";
	
public BatchDao() {
	 	
	}
protected Connection getConnection()
{
	Connection connection = null;
	try {
		Class.forName(jdbcDriver);
		connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	} catch (SQLException e) {
		
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	return connection;	
}

public void insertBatch(Batch batch) {
	
	System.out.println("INSERT_BATCH_SQL");
	
	
	try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BATCH_SQL)) {
		preparedStatement.setString(1, batch.getBatch_name());
		//preparedStatement.setString(2, batch.getSession_time());
		preparedStatement.setString(2, batch.getSession_type());
		preparedStatement.setString(3, batch.getInstructor());
		preparedStatement.setString(4, batch.getLocation());
		//preparedStatement.setString(6,user.getRegistration_date());
		System.out.println(preparedStatement);
		preparedStatement.executeUpdate();
	} catch (SQLException e) {
		printSQLException(e);
	}
	
}


//select batch by id

public Batch selectBatch(int id)
{
Batch batch =null;
//establishing connection
try (Connection connection =getConnection();
		//create stmt using conn. object
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BATCH_BY_ID);){
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			//execute
			ResultSet rs=preparedStatement.executeQuery();
			
			//process Resultset object
			while(rs.next()) { 
				
				String batch_name=rs.getString("batch_name");
				//String session_time=rs.getString("session_time");
				String session_type=rs.getString("session_type");
				String instructor=rs.getString("instructor");
				String location=rs.getString("location");
				
				batch=new Batch(id,batch_name,session_type,instructor,location);
			}
			
		}catch (SQLException e) {
			printSQLException(e);
		}
		return batch;
}


//select all user


public List<Batch> selectAllBatches()
{
List <Batch> batches=new ArrayList<>();

//establish connection
try (Connection connection =getConnection();
		
	//create stmt using conn object
		PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_BATCH);){
		System.out.println(preparedStatement);
		//execute query
		ResultSet rs=preparedStatement.executeQuery();
		
		//process resultset
		while(rs.next()) {
			int id =rs.getInt("id");
			String batch_name=rs.getString("batch_name");
			//String session_time =rs.getString("session_time");
			String session_type=rs.getString("session_type");
			String instructor=rs.getString("instructor");
			String location=rs.getString("location");
			
			batches.add(new Batch(id,batch_name,session_type,instructor,location));
		}
}catch (SQLException e) {
	printSQLException(e);
}
return batches;

}
//update batch info


	public boolean updateBatch(Batch batch)throws SQLException
	{
		boolean rowUpdated=false;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_BATCH_SQL);) {
			System.out.println("updated Batch:"+statement);
			statement.setString(1, batch.getBatch_name());
			//statement.setString(2, batch.getSession_time());
			statement.setString(2, batch.getSession_type());
			statement.setString(3, batch.getInstructor());
			statement.setString(4, batch.getLocation());
			statement.setInt(5, batch.getId());
	
			rowUpdated = statement.executeUpdate() > 0;
		}catch(SQLException e) {
			printSQLException(e);
		}
		return rowUpdated;
	}

//delete batch
	
	
	public boolean deleteBatch(int id) throws SQLException
	{
	boolean rowDeleted=false;
	try(Connection connection=getConnection();
			PreparedStatement statement =connection.prepareStatement(DELETE_BATCH_SQL);){
		statement.setInt(1, id);
		rowDeleted=statement.executeUpdate()>0;
	}catch (SQLException e) {
		printSQLException(e);
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
