package com.learn.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learn.model.TechDetails;

public class TechDetailsDao {
	private Connection con;
	private String url = "jdbc:mysql://localhost:3306/practice";
	private String user = "root";
	private String password = "9502";

	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TechDetails getTechDetails(int id) {
		TechDetails td = null; // Start with null to indicate no data found
		String query = "SELECT * FROM techdetails WHERE id=?";
		try {
			connect(); // Connect to the database
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				td = new TechDetails(); // Instantiate only when we have results
				td.setId(rs.getInt(1));
				td.setName(rs.getString(2));
				td.setTechnology(rs.getString(3));
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(); // Ensure the connection is closed
		}
		return td;
	}

	public int saveTechDetails(int id, String name, String technology) {
		int count = 0;
		String query = "INSERT INTO techdetails VALUES (?, ?, ?)";
		try {
			connect(); // Connect to the database
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, id);
			st.setString(2, name);
			st.setString(3, technology);
			count = st.executeUpdate();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(); // Ensure the connection is closed
		}
		return count;
	}

	private void closeConnection() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
