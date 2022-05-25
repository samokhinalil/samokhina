package ru.rsreu.samokhina.entity;

public class Count {
	private int requestId;
	private int decisionId;
	private int count;

	public Count(int requestId, int decisionId, int count) {
		this.requestId = requestId;
		this.decisionId = decisionId;
		this.count = count;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getDecisionId() {
		return decisionId;
	}

	public void setDecisionId(int decisionId) {
		this.decisionId = decisionId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
