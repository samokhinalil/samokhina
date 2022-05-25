package ru.rsreu.samokhina.dao;

import ru.rsreu.samokhina.entity.State;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StateDAO {
	Connection connection;

	/**
	 *
	 * @return
	 * @throws SQLException
	 */
	public List<State> selectStates() throws SQLException {
		List<State> states = new ArrayList<>();

		connection = ConnectionFactory.getConnection();
		Statement statement = connection.createStatement();
		String sql = Resourcer.getString("query.state.select");
		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {
			states.add(new State(result.getInt("id"),
					result.getString("title")));
		}
		connection.close();

		return states;
	}

	/**
	 *
	 * @param title
	 * @throws SQLException
	 */
	public void addState(String title) throws SQLException {
		connection = ConnectionFactory.getConnection();

		String sql = Resourcer.getString("query.state.add");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, title);
		statement.executeUpdate();

		connection.close();
	}
}
