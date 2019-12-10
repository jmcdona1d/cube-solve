package com.dzone.albanoj2.example.rest.domain;

public class Order implements Identifiable {

	private Long id;
	private String description;
	private long costInCents;
	private boolean isComplete;
	private String input;
	private String[] result;
	private String firstSet;

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

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		String set = (input == null || input.length() < 52) ? "52122200 01445432 34213553 20445145 01413130 30102355"
				: input;
		this.input = set;
		Cube c = new Cube(this.input);
		int j = c.solveCube();
		setResult(c.getSolveInstructionsArray());
		setFirstSet(c.getSolveInstructionsArray()[0]);
	}

	public String[] getResult() {
		return result;
	}

	public void setResult(String[] result) {
		this.result = result;
	}

	public void setFirstSet(String firstSet) {
		this.firstSet = firstSet;
	}

	public String getFirstSet() {
		return this.firstSet;
	}
}
