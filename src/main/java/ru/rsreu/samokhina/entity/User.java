package ru.rsreu.samokhina.entity;

public class User {
	private int id;
	private String name;
	private String login;
	private String password;
	private Role role;

	/**
	 *
	 * @return int user id
	 */
	public int getId() {
		return id;
	}

	/**
	 *
	 * @param id int user id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 *
	 * @return user name String
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * @param name user name String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *
	 * @return login String
	 */
	public String getLogin() {
		return login;
	}

	/**
	 *
	 * @param login String
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 *
	 * @return password String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 *
	 * @param password String
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 *
	 * @return user role Object type Role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 *
	 * @param role user role Object type Role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * constructor User
	 * @param id
	 * @param name
	 * @param login
	 * @param role
	 */
	public User(int id, String name, String login, Role role) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.role = role;
	}

	/**
	 * constructor User
	 * @param id
	 * @param name
	 * @param login
	 * @param password
	 * @param role
	 */
	public User(int id, String name, String login, String password, Role role) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.role = role;
	}
}
