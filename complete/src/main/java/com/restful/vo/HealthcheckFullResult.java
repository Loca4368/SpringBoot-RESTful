package com.restful.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class HealthcheckFullResult extends HealthcheckResult{
	private String currentTime;
	private String application;
	private DateFormat dateFormat;
	private final String dateFormatPattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	private final String timeZone = "GMT";

	public HealthcheckFullResult(String application) {

		this.dateFormat = new SimpleDateFormat(dateFormatPattern);
		this.dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
		this.currentTime = dateFormat.format(new Date());
		this.application = application;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public String getApplication() {
		return application;
	}
}
