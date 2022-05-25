package ru.rsreu.samokhina.dao;

import ru.rsreu.samokhina.entity.JobType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobTypeDAO {
	Connection connection;

	/**
	 *
	 * @return
	 * @throws SQLException
	 */
	public List<JobType> selectJobTypes() throws SQLException {
		List<JobType> jobTypes = new ArrayList<>();

		connection = ConnectionFactory.getConnection();
		Statement statement = connection.createStatement();
		String sql = Resourcer.getString("query.jobtype.select");
		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {
			jobTypes.add(new JobType(result.getInt("id"),
					result.getString("title")));
		}
		connection.close();

		return jobTypes;
	}

	/**
	 *
	 * @param title
	 * @throws SQLException
	 */
	public void addType(String title) throws SQLException {
		connection = ConnectionFactory.getConnection();

		String sql = Resourcer.getString("query.jobtype.add");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, title);
		statement.executeUpdate();

		connection.close();
	}
}
