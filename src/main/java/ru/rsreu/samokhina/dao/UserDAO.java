package ru.rsreu.samokhina.dao;

import ru.rsreu.samokhina.entity.Role;
import ru.rsreu.samokhina.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	private Connection connection;

	/**
	 *
	 * @param login
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public User checkAccess(String login, String password) throws SQLException {
		User user = null;

		connection = ConnectionFactory.getConnection();
		String sql = Resourcer.getString("query.user.check");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, login);
		statement.setString(2, password);
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			user = new User(result.getInt("id"),
					result.getString("name"),
					result.getString("login"),
					new Role(result.getInt("roleId"),
							result.getString("title")));
		}

		connection.close();

		return user;
	}

	/**
	 *
	 * @return
	 * @throws SQLException
	 */
	public List<User> selectUsers() throws SQLException {
		List<User> users = new ArrayList<>();

		connection = ConnectionFactory.getConnection();
		Statement statement = connection.createStatement();
		String sql = Resourcer.getString("query.user.select");
		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {
			users.add(new User(result.getInt("id"),
					result.getString("name"),
					result.getString("login"),
					new Role(result.getInt("roleid"),
							result.getString("title"))));
		}
		connection.close();

		return users;
	}

	/**
	 *
	 * @return
	 * @throws SQLException
	 */
	public List<User> selectExperts() throws SQLException {
		List<User> users = new ArrayList<>();

		connection = ConnectionFactory.getConnection();
		Statement statement = connection.createStatement();
		String sql = Resourcer.getString("query.user.expert.select");
		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {
			users.add(new User(result.getInt("id"),
					result.getString("name"),
					result.getString("login"),
					new Role(result.getInt("roleid"),
							result.getString("title"))));
		}
		connection.close();

		return users;
	}

	/**
	 *
	 * @param name
	 * @param login
	 * @param password
	 * @param roleId
	 * @throws SQLException
	 */
	public void addUser(String name, String login, String password, int roleId) throws SQLException {
		connection = ConnectionFactory.getConnection();

		String sql = Resourcer.getString("query.user.add");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, name);
		statement.setString(2, login);
		statement.setString(3, password);
		statement.setInt(4, roleId);
		statement.executeUpdate();

		connection.close();
	}

	/**
	 *
	 * @param name
	 * @param login
	 * @param password
	 * @param userId
	 * @throws SQLException
	 */
	public void updateUser(String name, String login, String password, int userId) throws SQLException {
		connection = ConnectionFactory.getConnection();

		String sql = Resourcer.getString("query.user.update");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, name);
		statement.setString(2, login);
		statement.setString(3, password);
		statement.setInt(4, userId);
		statement.executeUpdate();

		connection.close();
	}

	/**
	 *
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public User getUserById(int userId) throws SQLException {
		User user = null;

		connection = ConnectionFactory.getConnection();
		String sql = Resourcer.getString("query.user.getbyid");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, userId);
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			user = new User(result.getInt("id"),
					result.getString("name"),
					result.getString("login"),
					result.getString("password"),
					new Role(result.getInt("roleid"),
							result.getString("title")));
		}
		connection.close();

		return user;
	}

	/**
	 *
	 * @param deletedUserId
	 * @throws SQLException
	 */
	public void deleteUser(int deletedUserId) throws SQLException {
		connection = ConnectionFactory.getConnection();

		String sql = Resourcer.getString("query.user.delete");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, deletedUserId);
		statement.executeUpdate();

		connection.close();
	}
}
