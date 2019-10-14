package com.restful.vo;

public class HealthcheckShortResult extends HealthcheckResult {
	private String status;

	public HealthcheckShortResult(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}