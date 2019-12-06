package com.dzone.albanoj2.example.rest.domain;

public class Order implements Identifiable {

	private Long id;
	private String description;
	private long costInCents;
	private boolean isComplete;
	private String result;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCostInCents(long cost) {
		costInCents = cost;
	}

	public long getCostInCents() {
		return costInCents;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public void markComplete() {
		setComplete(true);
	}

	public void markIncomplete() {
		setComplete(false);
	}

	public boolean isComplete() {
		return isComplete;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		String set = (result == null || result.length() < 52) ? "52122200 01445432 34213553 20445145 01413130 530102355"
				: result;
		Cube c = new Cube(set);
		System.out.println(set);
		this.result = c.springTest();
		// this.result = c.springTest();
	}
}
