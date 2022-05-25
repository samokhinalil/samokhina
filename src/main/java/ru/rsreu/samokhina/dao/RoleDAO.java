package ru.rsreu.samokhina.dao;

import ru.rsreu.samokhina.entity.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {
	Connection connection;

	/**
	 *
	 * @return
	 * @throws SQLException
	 */
	public List<Role> selectRoles() throws SQLException {
		List<Role> roles = new ArrayList<>();

		connection = ConnectionFactory.getConnection();
		Statement statement = connection.createStatement();
		String sql = Resourcer.getString("query.role.select");
		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {
			roles.add(new Role(result.getInt("id"),
					result.getString("title")));
		}
		connection.close();

		return roles;
	}

	/**
	 *
	 * @param title
	 * @return
	 * @throws SQLException
	 */
	public Role getRoleByTitle(String title) throws SQLException {
		Role role = null;

		connection = ConnectionFactory.getConnection();
		String sql = Resourcer.getString("query.role.bytitle");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, title);
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			role = new Role(result.getInt("id"),
					result.getString("title"));
		}
		connection.close();

		return role;
	}
}
