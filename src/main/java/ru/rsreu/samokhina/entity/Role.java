package ru.rsreu.samokhina.entity;

public class Role {
	private int id;
	private String title;

	/**
	 *
	 * @return role id int
	 */
	public int getId() {
		return id;
	}

	/**
	 *
	 * @param id role id int
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 *
	 * @return role title String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 *
	 * @param title role title String
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * constructor
	 */
	public Role() {
	}

	/**
	 * constructor
	 * @param id
	 * @param title
	 */
	public Role(int id, String title) {
		this.id = id;
		this.title = title;
	}
}
