package ru.rsreu.samokhina.entity;

public class State {
	private int id;
	private String title;

	/**
	 *
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 *
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 *
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 *
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 *
	 */
	public State() {
	}

	/**
	 *
	 * @param id
	 * @param title
	 */
	public State(int id, String title) {
		this.id = id;
		this.title = title;
	}
}
