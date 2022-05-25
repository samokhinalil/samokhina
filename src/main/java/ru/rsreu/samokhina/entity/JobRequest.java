package ru.rsreu.samokhina.entity;

import java.util.Date;

public class JobRequest {
	private int id;
	private Date startDate;
	private Date endDate;
	private JobType jobType;
	private String description;
	private State state;
	private int initiatorId;

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
	public Date getStartDate() {
		return startDate;
	}

	/**
	 *
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 *
	 * @return
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 *
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 *
	 * @return
	 */
	public JobType getJobType() {
		return jobType;
	}

	/**
	 *
	 * @param jobType
	 */
	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	/**
	 *
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 *
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 *
	 * @return
	 */
	public State getState() {
		return state;
	}

	/**
	 *
	 * @param state
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 *
	 * @return
	 */
	public int getInitiator() {
		return initiatorId;
	}

	/**
	 *
	 * @param initiator
	 */
	public void setInitiator(int initiator) {
		this.initiatorId = initiator;
	}

	/**
	 *
	 */
	public JobRequest() {
	}

	/**
	 *
	 * @param id
	 * @param startDate
	 * @param endDate
	 * @param jobType
	 * @param description
	 * @param state
	 * @param initiator
	 */
	public JobRequest(int id, Date startDate, Date endDate, JobType jobType, String description, State state, int initiator) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.jobType = jobType;
		this.description = description;
		this.state = state;
		this.initiatorId = initiator;
	}
}
