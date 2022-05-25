package ru.rsreu.samokhina.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	/**
	 *
	 */
	private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	/**
	 *
	 */
	private static String user = "LILIYASAMOKHINA";
	/**
	 *
	 */
	private static String password = "1234";
	/**
	 *
	 */
	private static Connection connection;

	/**
	 *
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			connection = DriverManager.getConnection(url, user, password);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
