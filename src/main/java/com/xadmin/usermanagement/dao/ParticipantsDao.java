package com.xadmin.usermanagement.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.usermanagement.bean.Participants;

public class ParticipantsDao {

	private String jdbcURL = "jdbc:mysql://localhost:3306/gymmanagement?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Veen@1234567";
	private String jdbcDriver = "com.mysql.jdbc.Driver";

	private static final String INSERT_USERS_SQL = "INSERT INTO participants"
			+ "(name,gender,email,address,phone,batch_id)VALUES" + "(?,?,?,?,?,?);";

	private static final String SELECT_USER_BY_ID = "select id,name,gender,email,address,phone,batch_id from participants where id  =?";
	private static final String SELECT_ALL_USERS = "select * from participants";
	private static final String DELETE_USERS_SQL = "delete from participants where id  = ?;";
	private static final String UPDATE_USERS_SQL = "update participants set name = ?,gender=?,email= ?,address=?,phone=?,batch_id=? where id  = ?;";

	public ParticipantsDao() {
		
		

	}

	protected Connection getConnection() {
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
	// insert user

	public void insertUser(Participants part) {

		System.out.println("INSERT_USERS_SQL");

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, part.getName());
			preparedStatement.setString(2, part.getGender());
			preparedStatement.setString(3, part.getEmail());
			preparedStatement.setString(4, part.getAddress());
			preparedStatement.setString(5, part.getPhone());
			preparedStatement.setInt(6, part.getBatch_id());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	// select user by id

	public Participants selectUser(int id) {
		Participants part = null;
		
		try (Connection connection = getConnection();
				
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			
			while (rs.next()) {

				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				// changed
				int batch_id = rs.getInt("batch_id");

				part = new Participants(id, name, gender, email, address, phone, batch_id);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		return part;
	}

	// select all users

	public List<Participants> selectAllUsers() {
		List<Participants> part = new ArrayList<>();

		
		try (Connection connection = getConnection();

				
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				int batch_id = rs.getInt("batch_id");// changed

				part.add(new Participants(id, name, gender, email, address, phone, batch_id));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return part;

	}

	// update user method

	public boolean updateUser(Participants part) throws SQLException {
		boolean rowUpdated = false;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			System.out.println("updated USer:" + statement);
			statement.setString(1, part.getName());
			statement.setString(2, part.getGender());
			statement.setString(3, part.getEmail());
			statement.setString(4, part.getAddress());
			statement.setString(5, part.getPhone());
			statement.setInt(6, part.getBatch_id());// changed

			statement.setInt(7, part.getId());

			rowUpdated = statement.executeUpdate() > 0;
			System.out.println(rowUpdated);
		} catch (Exception e) {
			System.out.println(e);
		}
		return rowUpdated;
	}
	// delete user from databse

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
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
